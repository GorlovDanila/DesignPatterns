package com.example.designpatterns.creational.abstractfactory

import com.example.designpatterns.creational.abstractfactory.buttons.Button
import com.example.designpatterns.creational.abstractfactory.chekboxes.Checkbox
import com.example.designpatterns.creational.abstractfactory.factories.GUIFactory

class Application(factory: GUIFactory) {

    private var button: Button? = null
    private var checkbox: Checkbox? = null

    init {
        button = factory.createButton()
        checkbox = factory.createCheckbox()
    }

    fun paint() {
        button?.paint()
        checkbox?.paint()
    }
}