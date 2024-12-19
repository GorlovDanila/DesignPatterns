package com.example.designpatterns.creational.builder.component

class Engine(
    val volume: Double,
    var mileage: Double,
) {
    private var started: Boolean = false

    fun on() {
        started = true
    }

    fun off() {
        started = false
    }

    fun isStarted(): Boolean = started

    fun go(mileage: Double) {
        if (started) {
            this.mileage += mileage
        } else {
            System.err.println("Cannot go(), you must start engine first!")
        }
    }
}
