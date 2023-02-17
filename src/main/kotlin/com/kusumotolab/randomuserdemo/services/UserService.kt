package com.kusumotolab.randomuserdemo.services

import com.kusumotolab.randomuserdemo.clients.randomuser.RandomUserClient
import com.kusumotolab.randomuserdemo.models.RandomUserResponse
import org.springframework.stereotype.Service

@Service
class UserService(private val randomUserClient: RandomUserClient) {
    fun getRandomUserWithSeed(seed: String): List<RandomUserResponse>? {
        val responseFromApi = randomUserClient.getRandomUserWithSeed(seed)
        return responseFromApi?.results?.map {
            RandomUserResponse(
                firstName = it.name.first,
                lastName = it.name.last,
                gender = it.gender,
                email = it.email
            )
        }?.toList()
    }
}