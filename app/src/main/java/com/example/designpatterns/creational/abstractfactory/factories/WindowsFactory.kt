package com.example.designpatterns.creational.abstractfactory.factories

import com.example.designpatterns.creational.abstractfactory.buttons.Button
import com.example.designpatterns.creational.abstractfactory.buttons.WindowsButton
import com.example.designpatterns.creational.abstractfactory.chekboxes.Checkbox
import com.example.designpatterns.creational.abstractfactory.chekboxes.WindowsCheckbox

class WindowsFactory : GUIFactory {

    override fun createButton(): Button {
        return WindowsButton()
    }

    override fun createCheckbox(): Checkbox {
        return WindowsCheckbox()
    }
}