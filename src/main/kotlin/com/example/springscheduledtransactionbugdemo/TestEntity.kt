package com.example.springscheduledtransactionbugdemo

import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import org.springframework.data.jpa.repository.JpaRepository

@Entity
@Table(name = "test_table")
class TestEntity(
    @Id
    val id: UUID = UUID.randomUUID(),
    var name: String,
    var lastChanged: LocalDateTime = LocalDateTime.now(),
)

interface TestRepository : JpaRepository<TestEntity, UUID>
