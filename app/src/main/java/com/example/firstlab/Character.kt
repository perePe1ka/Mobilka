package com.example.firstlab

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Character(
    val url: String,
    val name: String = "Unknown",
    val culture: String = "Unknown",
    val born: String = "Unknown",
    val titles: List<String> = emptyList(),
    val aliases: List<String> = emptyList(),
    @SerialName("playedBy") val playedBy: List<String> = emptyList()
)


//модель данных, которая представляет информацию о персонаже, такую как имя, культура, дата рождения, титулы.
// Аннотация @Serializable позволяет библиотеке Kotlinx Serialization преобразовывать данные из JSON-ответа API в объект этого класса.