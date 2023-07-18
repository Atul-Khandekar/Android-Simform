package com.example.kotlinpractice.inlineclass
/*
    - This file contains example of inline class used as wrapper class for Name , Age and Password.
 */
@JvmInline
value class Age(val value: Int)

@JvmInline
value class Name(val value: String)

@JvmInline
value class Password(val value: String)

data class User(val name: Name, val password: Password, val age: Age)

fun main() {

    val user = User(Name("Atul"), Password("xyzw"), Age(21))
    println(user) // prints User(name=Name(value=Atul), password=Password(value=xyzw), age=Age(value=21))
}