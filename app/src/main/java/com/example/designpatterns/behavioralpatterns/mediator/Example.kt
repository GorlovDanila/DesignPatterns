package com.example.designpatterns.behavioralpatterns.mediator

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

// Простейший пример: чат («посредник»), в котором пользователи («коллеги») отправляют друг другу сообщения.
// Создадим «посредника»:
interface ChatRoomMediator {

    fun showMessage(user: User, message: String)
}

// Посредник
class ChatRoom : ChatRoomMediator {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun showMessage(user: User, message: String) {
        val time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM dd, yy HH:mm"))
        val sender = user.name

        println("$time [$sender]: $message")
    }
}

class User(val name: String, private val chatRoomMediator: ChatRoomMediator) {

    fun send(message: String) = chatRoomMediator.showMessage(this, message)
}

fun main() {
    val mediator = ChatRoom()

    val john = User("John Doe", mediator)
    val jane = User("Jane Doe", mediator)

    john.send("Hi there!")
    jane.send("Hey!")
}
