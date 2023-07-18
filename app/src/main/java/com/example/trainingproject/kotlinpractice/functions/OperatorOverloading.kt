package com.example.kotlinpractice.functions
/*
    - This file contains example of operator overloading for '+' and '-' operator .
 */
data class Name(val name: String)

data class Id(val id: Int)

fun main() {

    val name = Name("Atul")
    val id = Id(21)
    println(id + name) // prints Id 21 has name Atul
    println(id - 5) // prints Subtract 5 from 21
}

operator fun Id.plus(name: Name) = "Id ${this.id} has name ${name.name}"

operator fun Id.minus(number: Int) = "Subtract $number from ${this.id}"