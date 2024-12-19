package com.example.designpatterns.creational.builder.cars

import com.example.designpatterns.creational.builder.component.Engine
import com.example.designpatterns.creational.builder.component.GPSNavigator
import com.example.designpatterns.creational.builder.component.Transmission
import com.example.designpatterns.creational.builder.component.TripComputer

class Car(
    val carType: CarType,
    private val seats: Int,
    val engine: Engine,
    private val transmission: Transmission,
    private val tripComputer: TripComputer? = null,
    private val gpsNavigator: GPSNavigator,
    var fuel: Double = 0.0,
)
