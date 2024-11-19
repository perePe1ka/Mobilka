package com.example.firstlab

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class CharactersRepository {

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true // Игнорируем неизвестные ключи в JSON
            })
        }
    }

    suspend fun fetchCharacters(): List<Character> {
        return client.get("https://anapioficeandfire.com/api/characters?page=1&pageSize=50")
            .body()
    }
}






