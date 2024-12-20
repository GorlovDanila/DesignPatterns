package com.example.designpatterns.creational.prototype.shapes

abstract class Shape() {

    var x: Int? = null
    var y: Int? = null
    var color: String? = null

    constructor(target: Shape) : this() {
        x = target.x
        y = target.y
        color = target.color
    }

    abstract fun clone(): Shape

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Shape) return false

        if (x != other.x) return false
        if (y != other.y) return false
        if (color != other.color) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x ?: 0
        result = 31 * result + (y ?: 0)
        result = 31 * result + (color?.hashCode() ?: 0)
        return result
    }
}
