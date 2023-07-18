package com.example.kotlinpractice.delegation

import kotlin.properties.Delegates
/*
    - This file contains example of delegation where class Student is delegating to university .
    - It also contains example of delegation properties .
 */
fun main() {

    val college = College()
    val school = School()
    val student = Student(school)
    val adult = Student(college)
    student.read() // prints Student is reading in school
    adult.read() // prints Student is reading in college
    val test = Change()
    test.name = "changed name" // prints initial string -> changed name
    test.name = "changing name second time" // prints changed name -> changing name second time
    var number by Delegates.vetoable(15) { _, old, new ->
        println("$old -> $new")
        new > old
    }
    number = 20 // prints 15 -> 20
    number = 10 // prints 20 -> 10
}

interface University {
    fun read()
}

class College : University {
    override fun read() = println("Student is reading in college  ")
}

class School : University {
    override fun read() = println("Student is reading in school ")
}

class Student(u: University) : University by u

class Change {
    var name: String by Delegates.observable("initial string") { _, old, new ->
        println("$old -> $new")
    }
}