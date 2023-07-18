package com.example.kotlinpractice.interfaces
/*
    - This file contains examples of class implementing interface.
 */
fun main() {

    val engineer = Engineer("Vishal", 5000000.32)
    val fireFighter = FireFighter("jacksons", 4972374.7)

    engineer.getInformation() // prints Vishal is an engineer and has salary of 5000000.32
    fireFighter.getInformation() // prints  jacksons is a Firefighter and has salary of 4972374.7
}

interface Person {
    val name: String
    val salary: Double

    fun getInformation()
}

class Engineer(override val name: String, override val salary: Double) : Person {
    override fun getInformation() {
        println("$name is an engineer and has salary of $salary")
    }
}

class FireFighter(override val name: String, override val salary: Double) : Person {
    override fun getInformation() {
        println("$name is a Firefighter and has salary of $salary")
    }
}