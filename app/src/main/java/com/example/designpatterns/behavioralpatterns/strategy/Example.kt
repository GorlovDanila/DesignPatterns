package com.example.designpatterns.behavioralpatterns.strategy

// Возьмём вышеописанный пример. Сначала сделаем интерфейс стратегии и реализации самих стратегий.
interface SortStrategy {

    fun sort(dataset: Array<String>): Array<String>
}

class BubbleSortStrategy : SortStrategy {
    override fun sort(dataset: Array<String>): Array<String> {
        println("Sorting using bubble sort")
        return dataset
    }
}

class QuickSortStrategy : SortStrategy {

    override fun sort(dataset: Array<String>): Array<String> {
        println("Sorting using quick sort")
        return dataset
    }
}

// Теперь реализуем клиента, который будет использовать нашу стратегию.
class Sorter(private val sorter: SortStrategy) {

    fun sort(dataset: Array<String>): Array<String> = sorter.sort(dataset)
}

fun main() {
    val dataset = arrayOf("1", "5", "4", "3", "2", "8")

    var sorter = Sorter(BubbleSortStrategy())
    sorter.sort(dataset)

    sorter = Sorter(QuickSortStrategy())
    sorter.sort(dataset)
}