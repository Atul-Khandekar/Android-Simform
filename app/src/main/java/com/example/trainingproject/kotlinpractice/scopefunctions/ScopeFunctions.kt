package com.example.kotlinpractice.scopefunctions
/*
    - This file contains example of scope functions.
 */
fun main() {

    val address = Address().let {
        it.street = "wall street"
        it.state = "Maharashtra"
        it.city = "Pune"
        it.postalCode = "234121"
        "${it.street} , ${it.state} , ${it.city} , ${it.postalCode} "
    }
    println(address) // prints wall street , Maharashtra , Pune , 234121

    val teacher = Teacher().apply {
        name = "Sandip"
        id = "T-145"
        subjects = arrayOf("Maths", "Chemistry")
    }

    teacher.run {
        print("Name of teacher: $name , ")
        print("Id of teacher : $id , ")
        println("Subjects taught by teacher : ${subjects.toList()}")
    }  // prints  Name of teacher: Sandip , Id of teacher : T-145  Subjects , taught by teacher : [Maths, Chemistry]

    val numbers = mutableListOf(10, 20, 30, 40)
    println(numbers) // prints [10, 20, 30, 40]
    numbers.also {
        it.add(50)
        it.add(60)
        it.add(70)
        it.remove(10)
    }
    println(numbers) // prints [20, 30, 40, 50, 60, 70]

    val person = Person("Rahul")
    val dog = Dog("Labrador")
    with(person) {
        with(dog) {
            println(name) // prints Labrador
            bark() // prints dog is barking
            sayHello() // prints human is saying hello
        }
    }

    // if name is null "Default" is assigned otherwise " appended" gets concatenated to string
    var name: String? = "Hello"
    name = name?.run {
        this + " appended"
    } ?: run {
        "Default"
    }
    println(name) // prints Hello appended
}

class Teacher {
    var name: String = ""
    var id: String = " "
    var subjects: Array<String> = emptyArray()
}

data class Address(
    var street: String = "",
    var city: String = " ",
    var state: String = " ",
    var postalCode: String = ""
)

class Person(val name: String) {
    fun sayHello() = println("human is saying hello ")
}

class Dog(val name: String) {
    fun bark() = println("dog is barking")
}