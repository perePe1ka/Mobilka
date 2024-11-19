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
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun fetchCharactersInRange(): List<Character> {
        val pageSize = 50
        val startPage = 20
        val endPage = 20

        val characters = mutableListOf<Character>()

        for (page in startPage..endPage) {
            val currentPageCharacters: List<Character> = client.get("https://anapioficeandfire.com/api/characters") {
                url {
                    parameters.append("page", page.toString())
                    parameters.append("pageSize", pageSize.toString())
                }
            }.body()
            characters.addAll(currentPageCharacters)
        }
        return characters
    }
}

//Выполняет HTTP-запросы с использованием Ktor-клиента.
//Отправляет запрос к API, получает ответ в формате JSON и преобразует его в список объектов класса Character.
//Тут используется плагин ContentNegotiation для автоматической десериализации JSON в объекты Kotlin.





