package com.example.kotlinpractice.functions
/*
    - This file contains example of functions and how to define and call function.
    - It also shows example infix function.
 */
fun main() {

    var radius = 100.0
    display(
        50.0,
        "atul",
        "aniket",
        "aayush",
        circumference = 70.8
    ) // prints radius = 50.0 and circumference = 70.8 	atul , aniket , aayush , double of 5 is 10
    doubleNumber(5) // prints double of 5 is 10
    2 add 6 // prints 6 is inside generic function
}

fun display(radius: Double, vararg names: String, circumference: Double) {
    print("radius = $radius and circumference = $circumference \t")
    for (name in names) print("$name , ")
}

fun doubleNumber(number: Int) = println("double of $number is ${number * 2}")

infix fun <T> Int.add(x: T) {
    println("$x is inside generic function")
}