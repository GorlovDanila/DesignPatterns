package com.example.designpatterns.creational.abstractfactory.buttons

class MacOsButton : Button {

    override fun paint() {
        println("You have created MacOSButton.")
    }
}