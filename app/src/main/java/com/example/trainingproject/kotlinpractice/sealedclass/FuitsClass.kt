package com.example.kotlinpractice.sealedclass
/*
    - This file contains example of sealed class and sealed interface .
 */
fun main() {

    val mangoes = Fruits.Mangos(45.5)
    val apples = Fruits.Apples(25)
    val bananas = Fruits.Bananas("Yellow")
    val cake = Cake()
    val chinese = Chinese()

    mangoes.display() // prints Price of mangoes is 45.5
    apples.display() // prints There are 25 apples in basket
    bananas.display() // prints Color of bananas is Yellow

    cake.madeOf() // prints Cake is made of Milk ,Chocolate and eggs
    chinese.madeOf() // prints Chinese food is made of veggies and spices

    fruitType(bananas) // prints These are Bananas
}

fun fruitType(fruits: Fruits) {
    when (fruits) {
        is Fruits.Mangos -> println("These are mangoes ")
        is Fruits.Apples -> println("These are Apples")
        is Fruits.Bananas -> println("These are Bananas")
    }
}

sealed class Fruits() {
    abstract fun display()

    class Mangos(val price: Double = 0.0) : Fruits() {
        override fun display() = println("Price of mangoes is $price")
    }

    class Apples(val quantity: Int = 0) : Fruits() {
        override fun display() = println("There are $quantity apples in basket ")
    }

    class Bananas(val color: String = " ") : Fruits() {
        override fun display() = println("Color of bananas is $color")
    }
}

sealed interface Edibles {
    fun madeOf()
}

class Cake : Edibles {
    override fun madeOf() = println("Cake is made of Milk ,Chocolate and eggs ")
}

class Chinese : Edibles {
    override fun madeOf() = println("Chinese food is made of veggies and spices ")
}