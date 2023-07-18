package com.example.kotlinpractice.classes
/*
    - This file contains example of class Student and Person with its instance .
    - It also contains abstract class University having abstract method read()  which is implemented by class College.
 */
fun main() {

    val student = Student(34, "Atul", true)
    val person = Person("aayush", 5)
    println("Roll number  of student: ${student.rollNo}") // prints  Roll number  of student: 34
    println("is ${person.name} an adult? :  ${person.isAnAdult}") // prints  is aayush an adult? :  false
    val college = College("Gujarat University")
    college.write() // prints name of the university: Gujarat University
}

class Student(val rollNo: Int, val name: String, var ispassed: Boolean = false) {
    init {
        println("this is the first  initializer block in the student class")
    }

    init {
        println("this is the last property initalizer")
        if (ispassed) println("student has passed")
        else println("student has failed")
    }
}

class Person(var name: String, var age: Int) {
    var isAnAdult: Boolean = false

    init {
        if (age > 18) isAnAdult = true
    }
}

//Example of abstract class
abstract class University(val name: String) {
    abstract fun read()
    fun write() = println("name of the university: $name")
}

class College(name: String) : University(name) {
    override fun read() = println("Reading in college ")
}