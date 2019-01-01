package com.sample.demo.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping

@RestController
class SampleController {

    @RequestMapping("/")
    fun index(): String {
        return "Hello kotlin!!"
    }
}