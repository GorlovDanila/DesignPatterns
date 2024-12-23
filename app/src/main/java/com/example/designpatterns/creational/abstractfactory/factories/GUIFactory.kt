package com.example.designpatterns.creational.abstractfactory.factories

import com.example.designpatterns.creational.abstractfactory.buttons.Button
import com.example.designpatterns.creational.abstractfactory.chekboxes.Checkbox

interface GUIFactory {

    fun createButton(): Button

    fun createCheckbox(): Checkbox
}