package com.example.kotlinpractice.delegation
/*
 - This file contains example of engine delegating to vehicle.
 */
fun main() {

    val car = Car()
    val carEngine = Engine(car)
    carEngine.drive() // Car is Driven
    val truck = Truck()
    val truckEngine = Engine(truck)
    truckEngine.drive() // Truck is Driven
}

interface Vehicle {
    fun drive()
}

class Car : Vehicle {
    override fun drive() {
        println("Car is Driven ")
    }
}

class Truck : Vehicle {
    override fun drive() {
        println("Truck is Driven")
    }
}

class Engine(v: Vehicle) : Vehicle by v