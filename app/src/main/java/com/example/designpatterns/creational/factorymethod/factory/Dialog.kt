package com.example.designpatterns.creational.factorymethod.factory

import com.example.designpatterns.creational.factorymethod.buttons.Button

abstract class Dialog {

    fun renderWindow() {
        val okButton: Button = createButton()
        okButton.render()
    }

    abstract fun createButton(): Button
}
