package com.example.designpatterns.creational.factorymethod

import com.example.designpatterns.creational.factorymethod.factory.Dialog
import com.example.designpatterns.creational.factorymethod.factory.HtmlDialog
import com.example.designpatterns.creational.factorymethod.factory.WindowsDialog

private var dialog: Dialog? = null

fun main() {
    configure()
    runBusinessLogic()
}

fun configure() {
    dialog = if (System.getProperty("os.name")?.equals("Windows 10") == true) {
        WindowsDialog()
    } else {
        HtmlDialog()
    }
}

fun runBusinessLogic() {
    dialog?.renderWindow()
}
