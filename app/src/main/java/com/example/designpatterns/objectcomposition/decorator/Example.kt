package com.example.designpatterns.objectcomposition.decorator

// Возьмём в качестве примера кофе. Сначала просто реализуем интерфейс:
interface Coffee {

    fun getCost(): Int

    fun getDescription(): String
}

class SimpleCoffee : Coffee {

    override fun getCost() = 10

    override fun getDescription() = "Simple coffee"
}

// Можно сделать код расширяемым, чтобы при необходимости вносить модификации. Добавим «декораторы»:
class MilkCoffee(private val coffee: Coffee) : Coffee {

    override fun getCost(): Int = coffee.getCost() + 2

    override fun getDescription(): String = "${coffee.getDescription()}, milk"
}

class WhipCoffee(private val coffee: Coffee) : Coffee {

    override fun getCost(): Int = coffee.getCost() + 5

    override fun getDescription(): String = "${coffee.getDescription()}, whip"
}

class VanillaCoffee(private val coffee: Coffee) : Coffee {

    override fun getCost(): Int = coffee.getCost() + 3

    override fun getDescription(): String = "${coffee.getDescription()}, vanilla"
}

fun main() {
    var someCoffee: Coffee = SimpleCoffee()
    println(someCoffee.getCost())
    println(someCoffee.getDescription())

    someCoffee = MilkCoffee(someCoffee)
    println(someCoffee.getCost())
    println(someCoffee.getDescription())

    someCoffee = WhipCoffee(someCoffee)
    println(someCoffee.getCost())
    println(someCoffee.getDescription())

    someCoffee = VanillaCoffee(someCoffee)
    println(someCoffee.getCost())
    println(someCoffee.getDescription())
}