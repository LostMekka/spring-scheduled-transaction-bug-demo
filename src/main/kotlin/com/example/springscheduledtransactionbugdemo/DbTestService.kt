package com.example.springscheduledtransactionbugdemo

import java.time.LocalDateTime
import javax.persistence.EntityManager
import org.springframework.stereotype.Service
import org.springframework.transaction.support.TransactionTemplate

@Service
class DbTestService(
    private val repo: TestRepository,
    private val tx: TransactionTemplate,
    private val em: EntityManager,
) {
    fun createOneEntity(name: String) = repo.save(TestEntity(name = name))

    fun listAll(): List<TestEntity> = repo.findAll()

    fun updateAllEntities() {
        // if this method is called from SchedulingService, the updated will not be written to the database!
        // but if it is called from TestController, it IS written to the database.
        //
        // if repo.findAll() is moved inside the transaction, everything works fine.
        // alternatively, a repo.save(entity) inside the for loop also fixes things.
        // it seems that running from a schedule causes entities not fetched inside the transaction to be unmanaged...

        val entities = repo.findAll()
        tx.execute {
            for (entity in entities) {
                // if called from SchedulingService, this prints false
                // if called from TestController, this prints true
                println("    entity named '${entity.name}' is managed: ${em.contains(entity)}")
                entity.lastChanged = LocalDateTime.now()
            }
        }
        println()
    }
}

