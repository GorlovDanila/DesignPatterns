package com.example.designpatterns.creational.factorymethod.factory

import com.example.designpatterns.creational.factorymethod.buttons.Button
import com.example.designpatterns.creational.factorymethod.buttons.HtmlButton

class HtmlDialog : Dialog() {

    override fun createButton(): Button {
        return HtmlButton()
    }
}