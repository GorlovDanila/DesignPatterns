package com.example.designpatterns.behavioralpatterns.templatemethod

/*
  Допустим, у нас есть программный инструмент, позволяющий тестировать,
  проводить контроль качества кода (lint), выполнять сборку, генерировать отчёты сборки (отчёты о покрытии кода,
  о качестве кода и т. д.), а также развёртывать приложение на тестовом сервере.

  Сначала наш базовый класс определяет каркас алгоритма сборки.
 */

abstract class Builder {

    // Шаблонный метод
    fun build() {
        test()
        lint()
        assemble()
        deploy()
    }

    abstract fun test()
    abstract fun lint()
    abstract fun assemble()
    abstract fun deploy()
}

class AndroidBuilder : Builder() {
    override fun test() {
        println("Running android tests")
    }

    override fun lint() {
        println("Linting the android code")
    }

    override fun assemble() {
        println("Assembling the android build")
    }

    override fun deploy() {
        println("Deploying android build to server")
    }
}

class IosBuilder : Builder() {
    override fun test() {
        println("Running ios tests")
    }

    override fun lint() {
        println("Linting the ios code")
    }

    override fun assemble() {
        println("Assembling the ios build")
    }

    override fun deploy() {
        println("Deploying ios build to server")
    }
}

fun main() {
    val androidBuilder = AndroidBuilder()
    androidBuilder.build()

    val iosBuilder = IosBuilder()
    iosBuilder.build()
}
