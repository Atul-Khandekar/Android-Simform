package com.example.kotlinpractice.exceptionhandling
/*
    - This file contains example of handling different exceptions like divide by zero and index out of bound .
    - It also contains custom exception with use of throw keyword.
 */
fun main() {

    val numbers = listOf(10, 20, 30)
    val denominator = 0
    try {
        val number = 100 / denominator
    } catch (e: Exception) {
        println("Exception caught") // Exception caught
        println(e.message) // prints / by zero
    }

    try {
        println(numbers[3])
    } catch (a: ArrayIndexOutOfBoundsException) {
        println("index out of bound caught") // prints index out of bound caught
        println(a.message) //prints  Index 3 out of bounds for length 3
    }
    val age = 10
    checkAge(age) // prints  The given age is 10
}

fun checkAge(value: Int) {
    if (value < 0) throw Exception("Number must be greater than 0")
    println("The given age is $value ")
}