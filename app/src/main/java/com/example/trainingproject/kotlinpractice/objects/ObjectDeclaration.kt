package com.example.kotlinpractice.objects
/*
    This file contains example of object declaration using companion object and object keyword.
 */
fun main() {

    val venila = IceCream
    val chocolate = IceCream
    venila.flavour = "venila"
    Fruits.getDetails() // There are a lot of  fruits in the basket  fruit is round
    println(venila === chocolate) // true
}

class Fruits(val name: String) {
    val isSweet = true

    companion object {
        val isRound = true

        fun getDetails() {
            println("There are a lot of  fruits in the basket ")
            if (isRound) println("fruit is round") else println("fruit is not round")
        }
    }
}

object IceCream {
    var flavour = "chocolate"
    var price = 45.0

    fun feelsGood() = println("Ice cream makes your day ")
}