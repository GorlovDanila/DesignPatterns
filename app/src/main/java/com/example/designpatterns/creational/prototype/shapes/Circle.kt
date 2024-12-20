package com.example.designpatterns.creational.prototype.shapes

class Circle : Shape {

    var radius: Int? = null

    constructor() : super()

    constructor(target: Circle) : super(target) {
        radius = target.radius
    }

    override fun clone(): Shape = Circle(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false

        other as Circle

        return radius == other.radius
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + (radius ?: 0)
        return result
    }
}
