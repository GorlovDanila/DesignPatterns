package com.example.designpatterns.creational.abstractfactory

import com.example.designpatterns.creational.abstractfactory.factories.GUIFactory
import com.example.designpatterns.creational.abstractfactory.factories.MacOSFactory
import com.example.designpatterns.creational.abstractfactory.factories.WindowsFactory
import java.util.Locale


fun main() {
    val app = configureApp()
    app.paint()
}

fun configureApp(): Application {
    val osName = System.getProperty("os.name")?.lowercase(Locale.getDefault())
    val factory: GUIFactory = if (requireNotNull(osName) { "osName is null" }.contains("mac")) {
        MacOSFactory()
    } else {
        WindowsFactory()
    }
    return Application(factory)
}