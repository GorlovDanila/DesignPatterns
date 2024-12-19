package com.example.designpatterns.creational.singleton

class Singleton private constructor(private val value: String) {

    fun getValue() = value

    companion object {

        private var instance: Singleton? = null

        fun getInstance(value: String): Singleton {
            if (instance == null) {
                instance = Singleton(value)
            }
            return requireNotNull(instance) { "instance is null" }
        }
    }
}

fun main() {
    val a = Singleton.getInstance("a")
    val b = Singleton.getInstance("b")

    println(a.getValue())
    println(b.getValue())
}
