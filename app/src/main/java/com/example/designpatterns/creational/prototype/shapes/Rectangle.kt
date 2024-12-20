package com.example.designpatterns.creational.prototype.shapes

class Rectangle : Shape {

    var width: Int? = null
    var height: Int? = null

    constructor() : super()

    constructor(target: Rectangle) : super(target) {
        width = target.width
        height = target.height
    }

    override fun clone(): Shape = Rectangle(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false

        other as Rectangle

        if (width != other.width) return false
        if (height != other.height) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + (width ?: 0)
        result = 31 * result + (height ?: 0)
        return result
    }
}
