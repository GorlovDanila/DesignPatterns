package com.example.designpatterns.creational.builder.cars

import com.example.designpatterns.creational.builder.component.Engine
import com.example.designpatterns.creational.builder.component.GPSNavigator
import com.example.designpatterns.creational.builder.component.Transmission
import com.example.designpatterns.creational.builder.component.TripComputer

class Manual(
    private val carType: CarType,
    private val seats: Int,
    private val engine: Engine,
    private val transmission: Transmission,
    private val tripComputer: TripComputer?,
    private val gpsNavigator: GPSNavigator?,
    ) {

    fun print(): String {
        var info = ""
        info += "Type of car: $carType\n"
        info += "Count of seats: $seats\n"
        info += (("Engine: volume - " + engine.volume) + "; mileage - " + engine.mileage) + "\n"
        info += "Transmission: $transmission\n"
        info += if (this.tripComputer != null) {
            "Trip Computer: Functional" + "\n"
        } else {
            "Trip Computer: N/A" + "\n"
        }
        info += if (this.gpsNavigator != null) {
            "GPS Navigator: Functional" + "\n"
        } else {
            "GPS Navigator: N/A" + "\n"
        }
        return info
    }
}
