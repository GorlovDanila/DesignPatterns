package com.example.designpatterns.creational.builder.component

import com.example.designpatterns.creational.builder.cars.Car

class TripComputer() {

    private lateinit var car: Car

    fun setCar(car: Car) {
        this.car = car
    }

    fun showFuelLevel() {
        println("Fuel level: ${car.fuel}")
    }

    fun showStatus() {
        if (car.engine.isStarted()) {
            println("Car is started")
        } else {
            println("Car isn't started")
        }
    }
}
