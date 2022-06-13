package com.example.springscheduledtransactionbugdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class SpringScheduledTransactionBugDemoApplication

fun main(args: Array<String>) {
    runApplication<SpringScheduledTransactionBugDemoApplication>(*args)
}
