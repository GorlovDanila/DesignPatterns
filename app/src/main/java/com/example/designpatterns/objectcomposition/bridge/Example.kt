package com.example.designpatterns.objectcomposition.bridge

// Реализуем вышеописанный пример с веб-страницами. Сделаем иерархию WebPage:
abstract class WebPage(val theme: Theme) {

    abstract fun getContent()
}

class About(theme: Theme) : WebPage(theme) {

    override fun getContent() {
        println("About page in ${theme.getColor()}")
    }
}

class Careers(theme: Theme) : WebPage(theme) {

    override fun getContent() {
        println("Careers page in ${theme.getColor()}")
    }
}

// Отделим иерархию тем:
interface Theme {

    fun getColor(): String
}

internal class DarkTheme : Theme {

    override fun getColor(): String {
        return "Dark Black"
    }
}

internal class LightTheme : Theme {

    override fun getColor(): String {
        return "Off white"
    }
}

internal class AquaTheme : Theme {

    override fun getColor(): String {
        return "Light blue"
    }
}

fun main() {
    val darkTheme = DarkTheme()
    val about = About(darkTheme)
    val careers = Careers(darkTheme)
    about.getContent()
    careers.getContent()
}