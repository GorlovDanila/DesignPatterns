package com.example.designpatterns.creational.abstractfactory.buttons

class WindowsButton : Button {

    override fun paint() {
        println("You have created WindowsButton.")
    }
}