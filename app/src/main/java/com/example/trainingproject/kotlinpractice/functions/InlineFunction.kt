package com.example.kotlinpractice.functions
/*
    - This file contains example of inline function .
 */
fun main() {

    val number = 5
    println("factorial of $number is ${factorial(number)}") // factorial of 5 is 120
}

inline fun factorial(number: Int): Int {
    var result = 1
    for (i in 1..number) {
        result *= i
    }
    return result
}