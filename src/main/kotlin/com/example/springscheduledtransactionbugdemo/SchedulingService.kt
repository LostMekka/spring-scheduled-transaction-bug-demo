package com.example.springscheduledtransactionbugdemo

import org.springframework.stereotype.Service
import org.springframework.scheduling.annotation.Scheduled

@Service
class SchedulingService(
    private val dbService: DbTestService,
) {
    @Scheduled(cron = "0/20 * * * * *")
    fun scheduledUpdate() {
        println("updateAll called by scheduled job")
        dbService.updateAllEntities()
    }
}
