package com.example.kotlinpractice.functions
/*
    - This file contains example of lambda expressions.
    - It also contains how lambda expressions can be used for callbacks.
    - It also shows how lambda can be passed as argument in another function.
 */
fun main() {

    val numbers = intArrayOf(-10, -5, 0, 5, 10, 15)
    println(numbers.filter { it > 0 }) // prints [5, 10, 15]

    val double: (Int) -> Int = { num ->
        num * 2
    }
    println(double(5)) // prints 10

    fun greet(lambda: (String) -> String) {
        val result = lambda("Atul")
        println("Good Morning : $result")
    }
    greet { name ->
        print("Greetings $name and ")
        name
    } //  prints Greetings Atul and Good Morning : Atul

    val birthday: (String, Int) -> Int = { name: String, age: Int ->
        print("happy birthday $name ,")
        println("$name turned $age today")
        56
    }
    val result = birthday("atul", 21) // prints happy birthday atul , atul turned 21 today
    println("returned value from lambda is $result") // prints returned value from lambda is 56
}
