package com.example.designpatterns.creational.abstractfactory.factories

import com.example.designpatterns.creational.abstractfactory.buttons.Button
import com.example.designpatterns.creational.abstractfactory.buttons.MacOsButton
import com.example.designpatterns.creational.abstractfactory.chekboxes.Checkbox
import com.example.designpatterns.creational.abstractfactory.chekboxes.MacOsCheckbox

class MacOSFactory : GUIFactory {

    override fun createButton(): Button {
        return MacOsButton()
    }

    override fun createCheckbox(): Checkbox {
        return MacOsCheckbox()
    }
}