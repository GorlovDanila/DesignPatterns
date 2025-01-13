package com.example.designpatterns.behavioralpatterns.iterator

class RadioStation(val frequency: Double)

class StationList : Iterable<RadioStation> {
    private val stations: MutableList<RadioStation> = mutableListOf()

    fun addStation(station: RadioStation) {
        stations.add(station)
    }

    fun removeStation(toRemove: RadioStation) {
        val toRemoveFrequency = toRemove.frequency
        stations.removeIf { it.frequency == toRemoveFrequency }
    }

    fun count(): Int {
        return stations.size
    }

    override fun iterator(): Iterator<RadioStation> {
        return object : Iterator<RadioStation> {
            private var index = 0

            override fun hasNext(): Boolean {
                return index < stations.size
            }

            override fun next(): RadioStation {
                if (!hasNext()) throw NoSuchElementException()
                return stations[index++]
            }
        }
    }
}

fun main() {
    val stationList = StationList()

    stationList.addStation(RadioStation(89.0))
    stationList.addStation(RadioStation(101.0))
    stationList.addStation(RadioStation(102.0))
    stationList.addStation(RadioStation(103.2))

    stationList.forEach { println(it.frequency) }

    stationList.removeStation(RadioStation(89.0))
}
