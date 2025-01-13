package com.example.designpatterns.objectcomposition.facade

// Создадим класс computer:
class Computer {

    fun getElectricShock() = println("Ouch!")

    fun makeSound() = println("Beep beep!")

    fun showLoadingScreen() = println("Loading..")

    fun bam() = println("Ready to be used!")

    fun closeEverything() = println("Bup bup bup buzzzz!")

    fun sooth() = println("Zzzzz")

    fun pullCurrent() = println("Haaah!")
}

// Теперь «фасад»:
class ComputerFacade(private val computer: Computer) {

    fun turnOn() {
        computer.getElectricShock()
        computer.makeSound()
        computer.showLoadingScreen()
        computer.bam()
    }

    fun turnOff() {
        computer.closeEverything()
        computer.pullCurrent()
        computer.sooth()
    }
}

fun main() {
    val computer = ComputerFacade(Computer())
    computer.turnOn()
    computer.turnOff()
}