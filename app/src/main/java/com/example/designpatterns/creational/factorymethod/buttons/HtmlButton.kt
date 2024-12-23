package com.example.designpatterns.creational.factorymethod.buttons

class HtmlButton : Button {

    override fun render() {
        println("<button>Test Button</button>")
    }

    override fun onClick() {
        println("Click! Button says - 'Hello World!'")
    }
}