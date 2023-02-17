package com.kusumotolab.randomuserdemo.clients.randomuser

import com.kusumotolab.randomuserdemo.clients.randomuser.response.RandomUserResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate


@Component
class RandomUserClient(private val restTemplate: RestTemplate) {
    @Value("\${client.random-user.base-endpoint}")
    lateinit var baseEndpoint : String

    fun getRandomUserWithSeed(seed: String): RandomUserResponse? {
        val url = "$baseEndpoint/api/?seed=$seed"
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        val entity = HttpEntity<String>(headers)
        val response = restTemplate.exchange(url, HttpMethod.GET, entity, RandomUserResponse::class.java)

        return response.body
    }
}
