package com.example.designpatterns.creational.prototype.cache

import com.example.designpatterns.creational.prototype.shapes.Circle
import com.example.designpatterns.creational.prototype.shapes.Rectangle
import com.example.designpatterns.creational.prototype.shapes.Shape

class BundledShapeCache {

    private val cache: MutableMap<String, Shape> = mutableMapOf()

    init {
        val circle: Circle = Circle().apply {
            x = 5
            y = 7
            radius = 45
            color = "Green"
        }
        val rectangle: Rectangle = Rectangle().apply {
            x = 6
            y = 6
            width = 8
            height = 9
            color = "Blue"
        }
        cache.apply {
            put("Big green circle", circle)
            put("Medium blue rectangle", rectangle)
        }
    }

    fun get(key: String): Shape? = cache[key]?.clone()
}
