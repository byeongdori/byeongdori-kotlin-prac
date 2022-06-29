package org.kotlinlang.play

fun main() {
    // 1. when statement
    cases("Hello")
    ///

    // 2. Loop statement - for, while, do-while
    var cakesEaten = 0
    var cakesBaked = 0

    while (cakesEaten < 5) {
        eatACake()
        cakesEaten++
    }

    do {
        bakeACake()
        cakesBaked++
    } while (cakesBaked < cakesEaten)
    ///

    // 3. Iterators
    val zoo = Zoo(listOf(Animal("zebra"), Animal("lion")))

    for (animal in zoo) {
        println("Watch out, it's a ${animal.name}")
    }
    ///

    // 4. Ranges
    for (i in 0..3) {
        print(i)
    }
    print(" ")

    for (i in 0 until 3) {
        print(i)
    }
    print(" ")

    for (i in 2..8 step 2) {
        print(i)
    }
    print(" ")

    for (i in 3 downTo 0) {
        print(i)
    }
    print(" ")

    for (c in 'a'..'d') {
        print(c)
    }
    print(" ")

    for (c in 'z' downTo 's' step 2) {
        print(c)
    }
    print(" ")
}

// 1. when statement
fun cases(obj: Any) {
    // when -> switch 문과 동일한 기능
    val result = when (obj) {
        1 -> println("One")
        "Hello" -> println("Greeting")
        is Long -> println("Long")
        !is String -> println("Not a String")
        else -> println("Unknown")
    }

    return result
}
///

// 2. Loop statement
fun eatACake() = println("Eat a Cake")
fun bakeACake() = println("Bake a Cake")
///

// 3. Iterators
class Animal(val name: String)

class Zoo(val animals: List<Animal>) {

    operator fun iterator(): Iterator<Animal> {
        // custom iterator 만들기 가
        return animals.iterator()
    }
}
///