package com.example.kotlinpractice.dataclass
/*
    - This file contains example of data class Student with its methods and behaviour .
 */
open class School {
    val schoolName = "Imperial school of excellence"
}

data class Student(val id: Int, val name: String, val age: Int) : School() {
    fun isAdult() = age >= 18
}

fun main() {

    val loki = Student(20, "Loki", 18)
    var clark = Student(20, "Loki", 18)
    val firstName = "Atul"
    val lastName = "Khandekar"
    val person = Pair(firstName, lastName)
    val birthDate = Triple(20, 4, 2005)

    println(loki == clark) //prints true
    println(loki) // prints Student(id=20, name=Loki, age=18)

    clark = clark.copy(name = "clark")
    println(clark) // prints Student(id=20, name=clark, age=18)

    //destructuring declaration
    val (id, name, age) = loki
    println(id) // prints 20
    println(name) // prints Loki
    println(age) // prints 18

    println(loki.schoolName) // prints Imperial school of excellence
    println("Is ${loki.name} an adult : ${loki.isAdult()}") // prints Is Loki an adult : true

    println(person) // prints (Atul, Khandekar)
    println(birthDate) // prints (20, 4, 2005)
}