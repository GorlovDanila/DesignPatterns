package com.example.designpatterns.behavioralpatterns.visitor

// Возьмём зоопарк: у нас есть несколько видов животных, и нам нужно послушать издаваемые ими звуки.
// Место посещения
interface Animal {

    fun accept(operation: AnimalOperation)
}

// Посетитель
interface AnimalOperation {

    fun visitMonkey(monkey: Monkey)

    fun visitLion(lion: Lion)

    fun visitDolphin(dolphin: Dolphin)
}

// Реализуем животных:
class Monkey : Animal {
    fun shout() {
        println("Ooh oo aa aa!")
    }

    override fun accept(operation: AnimalOperation) {
        operation.visitMonkey(this)
    }
}

class Lion : Animal {
    fun roar() {
        println("Roaaar!")
    }

    override fun accept(operation: AnimalOperation) {
        operation.visitLion(this)
    }
}

class Dolphin : Animal {
    fun speak() {
        println("Tuut tuttu tuutt!")
    }

    override fun accept(operation: AnimalOperation) {
        operation.visitDolphin(this)
    }
}

// Реализуем посетителя:
class Speak : AnimalOperation {

    override fun visitMonkey(monkey: Monkey) = monkey.shout()

    override fun visitLion(lion: Lion) = lion.roar()

    override fun visitDolphin(dolphin: Dolphin) = dolphin.speak()
}

// Это можно было сделать просто с помощью иерархии наследования, но тогда пришлось бы модифицировать животных при каждом добавлении к ним новых действий. А здесь менять их не нужно. Например, мы можем добавить животным прыжки, просто создав нового посетителя:
class Jump : AnimalOperation {

    override fun visitMonkey(monkey: Monkey) = println("Jumped 20 feet high! on to the tree!")

    override fun visitLion(lion: Lion) = println("Jumped 7 feet! Back on the ground!")

    override fun visitDolphin(dolphin: Dolphin) = println("Walked on water a little and disappeared")
}

fun main() {
    val monkey = Monkey()
    val lion = Lion()
    val dolphin = Dolphin()

    val speak = Speak()

    monkey.accept(speak)
    lion.accept(speak)
    dolphin.accept(speak)

    val jump = Jump()

    monkey.accept(speak)
    monkey.accept(jump)
    lion.accept(speak)
    lion.accept(jump)
    dolphin.accept(speak)
    dolphin.accept(jump)
}
