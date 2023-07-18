package com.example.kotlinpractice.enumclass
/*
    - This file contains example enum class COLOR and NAMES.
 */
fun main() {

    for (color in COLOR.values()) {
        print("${color.colorName} , ")
    } // prints Red , Blue , Green , yellow ,

    //below code can throw exception
    try {
        println(COLOR.valueOf("RD"))
    } catch (e: java.lang.Exception) {
        println(e)
    } // prints java.lang.IllegalArgumentException: No enum constant com.example.kotlinpractice.enumClass.COLOR.RD

    NAMES.AAYUSH.display() // prints This instance is AAYUSH
    println(NAMES.ATUL.lowerCase) // prints atul
    println(COLOR.RED.colorName) // prints  Red
    println(COLOR.RED.colorAge) // prints 18
}

enum class COLOR(var colorName: String, var colorAge: Int) {
    RED("Red", 18), BLUE("Blue", 20), GREEN("Green", 30), YELLOW("yellow", 50)
}

enum class NAMES(var lowerCase: String) {
    ATUL("atul"), AAYUSH("aayush");

    fun display() = println("This instance is $this")
}