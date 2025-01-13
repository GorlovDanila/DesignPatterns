package com.example.designpatterns.behavioralpatterns.holder

/*
  Текстовый редактор время от времени сохраняет своё состояние, чтобы можно было восстановить текст в каком-то прошлом виде.
  Сначала создадим объект «хранитель», в котором можно сохранять состояние редактора.
*/
class EditorMemento(val content: String)

// Теперь сделаем редактор («создатель»), который будет использовать объект «хранитель».
class Editor {
    private var content = ""

    fun type(words: String) {
        content = "$content $words"
    }

    fun getContent(): String = content

    fun save(): EditorMemento = EditorMemento(content)

    fun restore(memento: EditorMemento) {
        content = memento.content
    }
}

fun main() {
    val editor = Editor()

    // Пишем что-нибудь
    editor.type("This is the first sentence.")
    editor.type("This is second.")

    // Сохранение состояния в: This is the first sentence. This is second.
    val saved = editor.save()

    editor.type("And this is third.")

    // Output: Содержимое до сохранения
    println(editor.getContent())

    // Восстанавливаем последнее сохранённое состояние
    editor.restore(saved)

    println(editor.getContent())
}