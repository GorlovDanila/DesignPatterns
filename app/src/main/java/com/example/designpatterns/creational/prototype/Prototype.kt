package com.example.designpatterns.creational.prototype

import com.example.designpatterns.creational.prototype.shapes.Circle
import com.example.designpatterns.creational.prototype.shapes.Rectangle
import com.example.designpatterns.creational.prototype.shapes.Shape

fun main() {
    val shapes: MutableList<Shape> = mutableListOf()
    val shapesCopy: MutableList<Shape> = mutableListOf()

    val circle: Circle = Circle().apply {
        x = 10
        y = 20
        radius = 15
        color = "red"
    }
    shapes.add(circle)

    val anotherCircle: Circle = circle.clone() as Circle
    shapes.add(anotherCircle)

    val rectangle: Rectangle = Rectangle().apply {
        width = 10
        height = 20
        color = "blue"
    }
    shapes.add(rectangle)
    cloneAndCompare(shapes, shapesCopy)
}

private fun cloneAndCompare(shapes: List<Shape>, shapesCopy: MutableList<Shape>) {
    for (shape in shapes) {
        shapesCopy.add(shape.clone())
    }

    shapes.forEachIndexed { index, shape ->
        if (shape !== shapesCopy[index]) {
            println("$index : Shapes are different objects (yay!)")

            if (shape == shapesCopy[index]) {
                println("$index : And they are identical (yay!)")
            } else {
                println("$index : But they are not identical (booo!)")
            }
        } else {
            println("$index : Shape objects are the same (booo!)")
        }
    }
}
