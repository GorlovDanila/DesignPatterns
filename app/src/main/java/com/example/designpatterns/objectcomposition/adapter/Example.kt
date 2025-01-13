package com.example.designpatterns.objectcomposition.adapter

/*
  Представим себе охотника на львов.
  Создадим интерфейс Lion, который реализует все типы львов.
 */
interface Lion {

    fun roar()
}

class AfricanLion : Lion {

    override fun roar() {
        TODO("Not yet implemented")
    }
}

class AsianLion : Lion {

    override fun roar() {
        TODO("Not yet implemented")
    }
}

// Охотник должен охотиться на все реализации интерфейса Lion.
class Hunter {

    fun hunt(lion: Lion) {

    }
}

/*
  Добавим теперь дикую собаку WildDog, на которую охотник тоже может охотиться.
  Но у нас не получится сделать это напрямую, потому что у собаки другой интерфейс.
  Чтобы она стала совместима с охотником, нужно создать подходящий адаптер.
*/
class WildDog {

    fun bark() {

    }
}

// Адаптер вокруг собаки сделает её совместимой с охотником
class WildDogAdapter(val dog: WildDog) : Lion {

    override fun roar() {
        dog.bark()
    }
}

// Теперь WildDog может вступить в игру действие благодаря WildDogAdapter.

fun main() {
    val wildDog = WildDog()
    val wildDogAdapter = WildDogAdapter(wildDog)
    val hunter = Hunter()
    hunter.hunt(wildDogAdapter)
}