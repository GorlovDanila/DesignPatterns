package com.example.designpatterns.objectcomposition.proxy

// Реализуем интерфейс двери и саму дверь:
interface Door {

    fun open()

    fun close()
}

class LabDoor : Door {

    override fun open() = println("Opening lab door")

    override fun close() = println("Closing the lab door")
}

// Сделаем «заместителя», чтобы дверь могла выполнять защитную функцию:
class Security(private val door: Door) {

    fun open(password: String) {
        if (authenticate(password)) {
            door.open()
        } else {
            println("Big no! It ain't possible.")
        }
    }

    private fun authenticate(password: String) = password == "ecr@t"

    fun close() = door.close()
}

fun main() {
    val door = Security(LabDoor())
    door.open("invalid")

    door.open("ecr@t")
    door.close()
}

/*
  Ещё один пример связан с реализацией преобразователя данных (data-mapper). С помощью этого шаблона можно сделать ODM (Object Data Mapper) для MongoDB.
  Для этого необходимо написать «заместителя» вокруг mongo-классов, воспользовавшись волшебным методом __call().
  Все вызовы методов будут проходить к оригинальным mongo-классам через «заместителя», а извлечённые результаты возвращаться как есть.
*/
