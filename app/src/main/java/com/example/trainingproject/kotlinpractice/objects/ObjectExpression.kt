package com.example.kotlinpractice.objects
/*
    - This file contains example of object expression
 */
fun main() {

    val india = object {
        val name = "India"
        val countryId = 45
        val isDeveloped = true

        fun getInformation() {
            println("name of country is $name")
            println("id of $name is $countryId")
            if (isDeveloped) println("$name is developed") else println("$name is not developed ")
            println("There are a lots of language spoken in $name like Hindi, Gujarati , Marathi , Tamil ")
        }
    }
    india.getInformation() // name of country is India  id of India is 45  India is developed  There are a lots of language spoken in India like Hindi, Gujarati , Marathi , Tamil
}
