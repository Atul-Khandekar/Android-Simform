package com.example.kotlinpractice.delegation
/*
    - This file contains example delegation in the restaurant with waiter delegating to kitchen.
 */
fun main() {

    val chef = Chef()
    val waiter = Waiter(chef)
    println(waiter.prepapreStarters("soda")) // prints  Prepared Starters is SODA
    println(waiter.prepareMeal("paneer")) // prints Prepared Meal is PANEER
}

enum class Starters { SODA, WATER }
enum class Meal { PANEER, MANCHURIAN, ITALIAN }

interface Kitchen {
    fun prepareMeal(name: String): Meal?
}

class Chef : Kitchen {
    override fun prepareMeal(name: String): Meal? {
        print("Prepared Meal is ")
        return when (name) {
            "paneer" -> Meal.PANEER
            "manchurian" -> Meal.MANCHURIAN
            "italian" -> Meal.ITALIAN
            else -> null
        }
    }
}

//waiter delegating to kitchen
class Waiter(order: Kitchen) : Kitchen by order {
    fun prepapreStarters(name: String): Starters? {
        print("Prepared starters is ")
        return when (name) {
            "soda" -> Starters.SODA
            "water" -> Starters.WATER
            else -> null
        }
    }
}