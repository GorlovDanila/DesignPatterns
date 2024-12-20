package com.example.designpatterns.creational.prototype

import com.example.designpatterns.creational.prototype.cache.BundledShapeCache
import com.example.designpatterns.creational.prototype.shapes.Shape

fun main() {
    val cache = BundledShapeCache()
    val shape1: Shape? = cache.get("Big green circle")
    val shape2: Shape? = cache.get("Medium blue rectangle")
    val shape3: Shape? = cache.get("Medium blue rectangle")

    if (shape1 !== shape2 && shape1?.equals(shape2) == false) {
        println("Big green circle != Medium blue rectangle (yay!)")
    } else {
        println("Big green circle == Medium blue rectangle (booo!)")
    }

    if (shape2 !== shape3) {
        println("Medium blue rectangles are two different objects (yay!)\");")
        if (shape2 == shape3) {
            println("And they are identical (yay!)")
        } else {
            println("But they are not identical (booo!)")
        }
    } else {
        println("Rectangle objects are the same (booo!)")
    }
}
