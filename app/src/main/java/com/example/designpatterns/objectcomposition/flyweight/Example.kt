package com.example.designpatterns.objectcomposition.flyweight

// Сделаем типы чая и чайника.

// Приспособленец — то, что будет закешировано.
// Типы чая здесь — приспособленцы.
class KarakTea

// Действует как фабрика и экономит чай
class TeaMaker {

    private val availableTea: MutableList<KarakTea?> = mutableListOf()

    fun make(preference: Int): KarakTea {
        if (availableTea.getOrNull(preference) == null) {

            while (availableTea.size <= preference) {
                availableTea.add(null)
            }

            availableTea[preference] = KarakTea()
        }

        return requireNotNull(availableTea[preference]) { "availableTea[preference] is null" }
    }
}

class TeaShop(private val teaMaker: TeaMaker) {

    private val orders: MutableList<KarakTea?> = mutableListOf()

    fun takeOrder(teaType: String, table: Int) {
        while (orders.size <= table) {
            orders.add(null)
        }
        orders[table] = teaMaker.make(teaType.length)
    }

    fun serve() {
        orders.forEachIndexed { index, tea ->
            if (tea != null) {
                println("Serving tea to table# $index.")
            }
        }
    }
}

fun main() {
    val teaMaker = TeaMaker()
    val shop = TeaShop(teaMaker)

    shop.takeOrder("less sugar", 1)
    shop.takeOrder("more milk", 2)
    shop.takeOrder("without sugar", 5)

    shop.serve()
}
