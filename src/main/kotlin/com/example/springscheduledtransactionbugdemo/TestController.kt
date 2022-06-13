package com.example.springscheduledtransactionbugdemo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
    private val dbService: DbTestService,
) {
    @GetMapping("/createOne")
    fun create(@RequestParam(name = "name") name: String) = dbService.createOneEntity(name)

    @GetMapping("/listAll")
    fun listAll() = dbService.listAll()

    @GetMapping("/updateAll")
    fun updateAll() {
        println("updateAll called manually")
        dbService.updateAllEntities()
    }
}
