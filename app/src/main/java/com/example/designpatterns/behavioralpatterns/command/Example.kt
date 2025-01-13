package com.example.designpatterns.behavioralpatterns.command

// Сначала сделаем получателя, содержащего реализации каждого действия, которое может быть выполнено.

// Receiver
class Bulb {

    fun turnOn() = println("Bulb has been lit")

    fun turnOff() = println("Darkness!")
}

// Теперь сделаем интерфейс, который будет реализовывать каждая команда. Также сделаем набор команд.
interface Command {

    fun execute()

    fun undo()

    fun redo()
}

// Command
class TurnOn(private val bulb: Bulb) : Command {

    override fun execute() = bulb.turnOn()

    override fun undo() = bulb.turnOff()

    override fun redo() = execute()
}

class TurnOff(private val bulb: Bulb) : Command {

    override fun execute() = bulb.turnOff()

    override fun undo() = bulb.turnOn()

    override fun redo() = execute()
}

// Теперь сделаем вызывающего Invoker, с которым будет взаимодействовать клиент для обработки команд.

// Invoker
class RemoteControl {

    fun submit(command: Command) = command.execute()
}

fun main() {
    val bulb = Bulb()
    val turnOn = TurnOn(bulb)
    val turnOff = TurnOff(bulb)
    val remoteControl = RemoteControl()

    remoteControl.submit(turnOn)
    remoteControl.submit(turnOff)
}

/*
  Шаблон «Команда» можно использовать и для реализации системы на основе транзакций.
  То есть системы, в которой вы сохраняете историю команд по мере их выполнения.
  Если последняя команда выполнена успешно, то всё хорошо. В противном случае система
  итерирует по истории и делает undo для всех выполненных команд.
 */