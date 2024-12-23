package com.example.designpatterns.creational.abstractfactory.chekboxes

class WindowsCheckbox : Checkbox {

    override fun paint() {
        println("You have created WindowsCheckbox.")
    }
}