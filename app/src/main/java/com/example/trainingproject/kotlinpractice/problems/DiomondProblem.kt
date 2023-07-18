package com.example.kotlinpractice.problems
/*
    - This file contains solution  to diamond problem .
 */
fun main() {

    val person = Check()
    person.check("customer") // prints This is form customer
}

interface Manager {
    fun displayManager() {
        println("This is from manager")
    }
}

interface Customer {
    fun displayCustomer() {
        println("This is form customer")
    }
}

abstract class Person() : Manager, Customer {
    fun getObject(name: String) {
        when (name) {
            "manager" -> displayManager()
            "customer" -> displayCustomer()
            else -> {
                println("Invalid keyword")
            }
        }
    }
}

class Check() : Person() {
    fun check(name: String) {
        getObject(name)
    }
}