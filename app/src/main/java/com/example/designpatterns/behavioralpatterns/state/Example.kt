package com.example.designpatterns.behavioralpatterns.state

/*
  Текстовый редактор меняет состояние текста, который вы печатаете, т. е. если выбрано полужирное начертание — то редактор печатает полужирным и т. д.

  Сначала сделаем интерфейс состояний и сами состояния:
 */
interface WritingState {

    fun write(words: String)
}

class UpperCase : WritingState {

    override fun write(words: String) {
        println(words.uppercase())
    }
}

class LowerCase : WritingState {

    override fun write(words: String) {
        println(words.lowercase())
    }
}

class Default : WritingState {

    override fun write(words: String) = println(words)
}

// Сделаем редактор:
class TextEditor(private var state: WritingState) {

    fun setState(state: WritingState) {
        this.state = state
    }

    fun type(words: String) = state.write(words)
}

fun main() {
    val editor = TextEditor(Default())
    editor.type("First line")

    editor.setState(UpperCase())
    editor.type("Second line")
    editor.type("Third line")

    editor.setState(LowerCase())
    editor.type("Fourth line")
    editor.type("Fifth line")
}