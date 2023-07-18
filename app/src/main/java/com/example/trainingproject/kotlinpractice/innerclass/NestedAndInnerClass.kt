package com.example.kotlinpractice.innerclass
/*
    - This file contains examples showing behaviour of Nested class and Inner class .
 */
fun main() {

    val india = Country()
    india.settingName("India")
    val state = india.State()
    state.getCountryName() //prints Name of Country: India
    state.getCountryStatus() //prints Country is developed
    val room = Building.Room()
    room.numberOfRooms = 5
    room.getRooms() //prints number of floors are 5
}

class Country {
    var name: String = ""
    private var isDeveloped = true

    fun settingName(name: String) {
        this.name = name
    }

    fun settingStatus(status: Boolean) {
        this.isDeveloped = status
    }

    inner class State {
        var stateName: String = " "
        fun getCountryName() = println("Name of Country: $name")
        fun getCountryStatus() {
            if (isDeveloped) println("Country is developed")
            else println("Country is not developed")
        }
    }
}

class Building {
    class Room {
        var numberOfRooms = 2
        fun getRooms() = println("number of floors are $numberOfRooms")
    }
}