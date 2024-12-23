package com.example.designpatterns.creational.factorymethod.factory

import com.example.designpatterns.creational.factorymethod.buttons.Button
import com.example.designpatterns.creational.factorymethod.buttons.WindowButton

class WindowsDialog : Dialog() {

    override fun createButton(): Button {
       return WindowButton()
    }
}