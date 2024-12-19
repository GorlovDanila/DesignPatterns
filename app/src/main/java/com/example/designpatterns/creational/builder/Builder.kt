package com.example.designpatterns.creational.builder

import com.example.designpatterns.creational.builder.builders.CarBuilder
import com.example.designpatterns.creational.builder.builders.CarManualBuilder
import com.example.designpatterns.creational.builder.cars.Car
import com.example.designpatterns.creational.builder.director.Director


fun main() {
    val director = Director()
    val carBuilder = CarBuilder()
    director.constructSportsCar(carBuilder)

    val car: Car = carBuilder.getResult()
    println("Car built:\n" + car.carType)

    val manualBuilder = CarManualBuilder()

    director.constructSportsCar(manualBuilder)
    val carManual = manualBuilder.getResult()
    println("Car manual built:\n" + carManual.print())
}
