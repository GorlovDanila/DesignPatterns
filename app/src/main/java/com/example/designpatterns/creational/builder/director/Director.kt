package com.example.designpatterns.creational.builder.director

import com.example.designpatterns.creational.builder.builders.Builder
import com.example.designpatterns.creational.builder.cars.CarType
import com.example.designpatterns.creational.builder.component.Engine
import com.example.designpatterns.creational.builder.component.GPSNavigator
import com.example.designpatterns.creational.builder.component.Transmission
import com.example.designpatterns.creational.builder.component.TripComputer


class Director {

    fun constructSportsCar(builder: Builder) {
        builder.setCarType(CarType.SPORTS_CAR)
        builder.setSeats(2)
        builder.setEngine(Engine(3.0, 0.0))
        builder.setTransmission(Transmission.SEMI_AUTOMATIC)
        builder.setTripComputer(TripComputer())
        builder.setGPSNavigator(GPSNavigator())
    }

    fun constructCityCar(builder: Builder) {
        builder.setCarType(CarType.CITY_CAR)
        builder.setSeats(2)
        builder.setEngine(Engine(1.2, 0.0))
        builder.setTransmission(Transmission.AUTOMATIC)
        builder.setTripComputer(TripComputer())
        builder.setGPSNavigator(GPSNavigator())
    }

    fun constructSUV(builder: Builder) {
        builder.setCarType(CarType.SUV)
        builder.setSeats(4)
        builder.setEngine(Engine(2.5, 0.0))
        builder.setTransmission(Transmission.MANUAL)
        builder.setGPSNavigator(GPSNavigator())
    }
}
