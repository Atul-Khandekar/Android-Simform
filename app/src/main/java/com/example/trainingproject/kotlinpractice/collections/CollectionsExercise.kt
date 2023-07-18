package com.example.kotlinpractice.collections
/*
    - This file contains  examples of different transformations on collections .
 */
data class Person(val name: String, val age: Int)

fun main() {

    //filter out odd elements
    val list = listOf(1, 2, 3, 4)
    println(list.filter { it % 2 == 0 }) // prints [2, 4]

    //generate squares using map
    val numbers = listOf(1, 2, 4, 5, 8)
    val squares = numbers.map { it * it }
    println(squares) // prints [1, 4, 16, 25, 64]

    val people = listOf(
        Person("Atul", 25),
        Person("Aayush", 26),
        Person("Digvijay ", 35),
        Person("vishal", 50),
        Person("shyam", 24),
        Person("Hardik", 29),
        Person("Ajay", 20),
    )

    //print name people whose age is greater than 25
    println(people.filter { it.age > 25 }) // prints  [Person(name=Aayush, age=26), Person(name=Digvijay , age=35), Person(name=vishal, age=50), Person(name=Hardik, age=29)]

    //print the name of people whose age is less than 30 and whose name starts with 'a' or 'A'
    println(people.filter { it.age < 30 }.map { it.name }
        .filter { it.startsWith("a", true) }) // prints  [Atul, Aayush, Ajay]

    // print the name of people whose age is less than 30 and contains  at least 2 a's in name
    println(people.filter { it.age < 30 }.filter {
        it.name.count {
            it.equals(
                'a',
                true
            )
        } >= 2
    }) // prints  [Person(name=Aayush, age=26), Person(name=Ajay, age=20)]

    // print person with maximum age
    println(people.maxBy { it.age }) // prints  Person(name=vishal, age=50)

    //print maximum of all ages in people
    println(people.maxOf { it.age }) // prints  50

    //print people who are having maximum age
    println(people.filter { it.age == people.maxBy { it.age }.age }) // prints [Person(name=vishal, age=50)]

    val map = mutableMapOf(1 to "One", 2 to "Two", 3 to "Three", 4 to "Four")

    //change all integer keys to string keys
    val stringMap = map.mapKeys { it.key.toString() + "x" }
    println(stringMap) // prints  {1x=One, 2x=Two, 3x=Three, 4x=Four}

    // filtering out the keys which starts with odd numbers
    println(stringMap.filterKeys { it.first().code % 2 == 0 }) // prints  {2x=Two, 4x=Four}

    //filtering keys which ends with x with ignorecase as true
    println(stringMap.filterKeys {
        it.endsWith(
            "x",
            true
        )
    }) // prints  {1x=One, 2x=Two, 3x=Three, 4x=Four}

    // turning all the values to lowercase using mapValues()
    println(stringMap.mapValues { it.value.lowercase() }) // prints  {1x=one, 2x=two, 3x=three, 4x=four}

    // note - any all find  none -> used for applying predicate to whole collection which returns boolean

    //check if all the people are above age 18
    println(people.all { it.age > 18 }) // prints  true

    // check if any of the one person is above 45
    println(people.any { it.age > 45 }) // prints  true

    //note-> Remeber find return null if element not found

    //print the name of the first person whose age is more than 30
    println(people.find { it.age > 30 }?.name) // prints  Digvijay

    //print people whose names contains 'd' or 'D'  using stored predicate
    val pre = { p: Person -> p.name.contains('D', true) }
    println(people.filter(pre)) // prints  [Person(name=Digvijay , age=35), Person(name=Hardik, age=29)]

    //note - groupBy return map which contains predicate and list of values satisfying the predicate .

    // group by people name with count of a in their name
    println(people.groupBy {
        it.name.count {
            it.equals(
                'a', true
            )
        }
    }) // prints  {1=[Person(name=Atul, age=25), Person(name=Digvijay , age=35), Person(name=vishal, age=50), Person(name=shyam, age=24), Person(name=Hardik, age=29)], 2=[Person(name=Aayush, age=26), Person(name=Ajay, age=20)]}

    val atul = listOf("atul", "Khandekar")
    val vishal = listOf("vishal", "patel")
    val surat = listOf("awesome", "home")
    val ahmedabd = listOf("second home", "nice")
    val names = listOf(atul, vishal)
    val cities = listOf(surat, ahmedabd)
    val friends = listOf(names, cities)

    println(atul.flatMap { it.toList() }) // prints  [a, t, u, l, K, h, a, n, d, e, k, a, r]

    println(names.flatten()) // prints  [atul, Khandekar, vishal, patel]

    println(friends.flatMap { it.map { it.map { it.uppercase() } } }) // prints [[ATUL, KHANDEKAR], [VISHAL, PATEL], [AWESOME, HOME], [SECOND HOME, NICE]]

    //partition return pair of list s whose age is less than 40 and whose age is more than 40
    println(
        people.partition { it.age < 40 }.toList()
            .map { it.map { it.name } }) // prints [[Atul, Aayush, Digvijay , shyam, Hardik, Ajay], [vishal]]

    // filter out  people who are on odd index
    println(people.filterIndexed { index, person ->
        index % 2 == 0
    }) // prints  [Person(name=Atul, age=25), Person(name=Digvijay , age=35), Person(name=shyam, age=24), Person(name=Ajay, age=20)]

    val studentList = listOf(null, Person("harry", 30), Person("hermionee", 34))

    //filter out null from studentList
    println(studentList.filterNotNull()) // prints  [Person(name=harry, age=30), Person(name=hermionee, age=34)]

    val combineList = listOf(null, 1.0, "String first ", " String second", Person("ajay", 20))
    //print instances of string
    println(combineList.filterIsInstance<String>()) // prints [String first ,  String second]

    // print non null values from combineList
    println(combineList.mapNotNull { it }) // prints  [1.0, String first ,  String second, Person(name=ajay, age=20)]

    //joining list atul and vishal
    println(atul.zip(vishal)) // prints  [(atul, vishal), (Khandekar, patel)]

    //combining with custom operation
    println(atul.zip(vishal) { one, two -> "this is $one and $two" })  // prints  [this is atul and vishal, this is Khandekar and patel]

    val pairs = listOf(1 to "One", 2 to "Two", 3 to "Three")
    println(pairs.unzip()) // prints  ([1, 2, 3], [One, Two, Three])

    // note - associateWith which takes keys as elements and values as whatever we perform in the lambda

    val states = listOf("Gujarat", "Maharashtra", "Delhi", "Rajasthan", "Haryana", "Karnataka")
    //print states associated with their length of name
    println(states.associateWith { it.length }) // prints  {Gujarat=7, Maharashtra=11, Delhi=5, Rajasthan=9}

    //note - associate by which takes keys as the lambda we pass and values as name of element

    //taking ascii value  of first character as key
    println(states.associateBy { it.first().code }) // prints  {71=Gujarat, 77=Maharashtra, 68=Delhi, 82=Rajasthan}

    val employee = listOf(null, "Atuul", "Vishal", "Ajay", "Shyam", null, "Hardik")

    //note - if you want to perform operation on all the grop formed then you should use gropingbBy
    //note - we can Use fold reduce and eachCount on grouping by
    //note - reduce doesnt take initial value while fold does take initial value

    val marks = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    //print multiplication of all numbers in marks
    println(marks.fold(1) { first, second ->
        first * second
    }) // prints  362880

    // add 5 to sum of list
    println(marks.fold(5) { first, second ->
        first + second
    }) // prints  50

    //printing sum of all elements
    println(marks.reduce { first, second -> first + second }) // prints  45

    //take elements from range 0 to 2
    println(marks.slice(0..2)) // prints  [1, 2, 3]

    //take 2 element from start
    println(marks.take(2)) // prints  [1,2]

    //take elements of marks while  it is less than 6
    println(marks.takeWhile { it < 6 }) // prints [1, 2, 3, 4, 5]

    //perform sum of every two elements
    println(marks.chunked(2) { it.sum() }) // prints  [3, 7, 11, 15, 9]

    //print window of 3 elements
    println(marks.windowed(3))  // prints  [[1, 2, 3], [2, 3, 4], [3, 4, 5], [4, 5, 6], [5, 6, 7], [6, 7, 8], [7, 8, 9]]
}