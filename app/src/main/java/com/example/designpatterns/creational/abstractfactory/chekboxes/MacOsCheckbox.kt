package com.example.designpatterns.creational.abstractfactory.chekboxes

class MacOsCheckbox : Checkbox {

    override fun paint() {
        println("You have created MacOSCheckbox.")
    }
}