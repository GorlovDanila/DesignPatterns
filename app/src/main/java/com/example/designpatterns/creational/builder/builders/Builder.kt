package com.example.designpatterns.creational.builder.builders

import com.example.designpatterns.creational.builder.cars.CarType
import com.example.designpatterns.creational.builder.component.Engine
import com.example.designpatterns.creational.builder.component.GPSNavigator
import com.example.designpatterns.creational.builder.component.Transmission
import com.example.designpatterns.creational.builder.component.TripComputer

interface Builder {

    fun setCarType(type: CarType)
    fun setSeats(seats: Int)
    fun setEngine(engine: Engine)
    fun setTransmission(transmission: Transmission)
    fun setTripComputer(tripComputer: TripComputer)
    fun setGPSNavigator(gpsNavigator: GPSNavigator)
}