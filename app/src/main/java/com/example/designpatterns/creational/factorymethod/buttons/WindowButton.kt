package com.example.designpatterns.creational.factorymethod.buttons

class WindowButton : Button {

    override fun render() {
        println("WindowButton")
    }

    override fun onClick() {
        println("WindowButton clicked")
    }
}
