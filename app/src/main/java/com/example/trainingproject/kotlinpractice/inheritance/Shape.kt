package com.example.kotlinpractice.inheritance
/*
    - This file contains example inheritance.
    - It shows how class Circle and Rectangle inherit properties and methods from parent class Shape
    - It also shows example of overriding method if it is present in parent method.
 */
fun main() {

    val rectangle = Rectangle(15.0, 20.0)
    rectangle.getName() // prints This shape is rectangle
    println("Area of ${rectangle.name} is ${rectangle.getArea()} ") // prints Area of rectangle is 300.0

    val circle = Circle(50.0)
    circle.getName() // prints This shape is circle
    println("Area of ${circle.name}  is ${circle.getArea()}") // Area of circle  is 7850.0

    val king = King("Raja ravi verma", 50000000)
    val prince = Prince().apply {
        name = "Chandragupta"
        property = 4384874
    }
    king.getDetails() // prints King Raja ravi verma has 50000000 worth of peroperty
    prince.getDetails() // prints  Prince Chandragupta has 4384874 worth of peroperty
}

open class Shape(val name: String) {
    fun getName() = println("This shape is $name")
}

class Circle(private val radius: Double) : Shape("circle") {
    val circumference: Double
        get() = 2 * 3.14 * radius

    fun getArea() = radius * radius * 3.14
}

class Rectangle(private val height: Double, private val width: Double) : Shape("rectangle") {
    val perimeter: Double
        get() = 2 * (height + width)

    fun getArea() = height * width
}

open class King(var name: String = "", var property: Int = 0) {
    open fun getDetails() = println("King $name has $property worth of peroperty ")
}

class Prince() : King() {
    override fun getDetails() = println("Prince $name has $property worth of peroperty ")
}