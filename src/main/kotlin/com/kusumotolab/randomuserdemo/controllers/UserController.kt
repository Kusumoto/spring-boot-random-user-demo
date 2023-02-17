package com.kusumotolab.randomuserdemo.controllers

import com.kusumotolab.randomuserdemo.models.RandomUserResponse
import com.kusumotolab.randomuserdemo.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/users")
class UserController(private val userService: UserService) {
    @GetMapping("/{seed}")
    fun getRandomUserWithSeed(@Validated @PathVariable("seed") seed: String): ResponseEntity<List<RandomUserResponse>?> {
        return ResponseEntity(userService.getRandomUserWithSeed(seed), HttpStatus.OK)
    }
}






