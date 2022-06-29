package org.kotlinlang.play

// 1. 기본 함수 정의
fun printMessage(message: String): Unit {
    println(message)
}

fun printMessageWithPrefix(message: String, prefix: String = "Info") {
    println("[$prefix] $message")
}

fun sum(x: Int, y: Int): Int {
    return x+y
}

fun multiply(x: Int, y: Int) = x * y
///

// 4. varang 매개변수를 받는 함수
fun printAllWithPrefix(vararg messages: String, prefix: String = "Info ") {
    for (m in messages) println(prefix + m)
}

fun log(vararg entries: String) {
    // 런타임 중에는 vararg이 리스트이므로 * 연산자 붙여서 매개변수로 전달해야 함
    printAllWithPrefix(*entries)
}
///

fun main(args: Array<String>) {
    println("Hello World!")

    // 1. 기본 함수 작성법
    printMessage("Hello")
    printMessageWithPrefix("Hello")
    printMessageWithPrefix("Hello", "Log")
    printMessageWithPrefix(prefix = "This is", message = "Message body")
    println(sum(1, 2))
    println(multiply(2, 4))
    ///

    // 2. infix 함수 - 두개의 변수 가운데에 오는 함수
    infix fun Int.times(str: String) = str.repeat(this)
    println(2 times "Bye ")

    val pair = "Audi" to "A8"
    println(pair)

    infix fun String.onto(other: String) = Pair(this, other)
    val myPair = "Audi" onto "R8"
    println(myPair)

    val sophia = Person("Sophia")
    val james = Person("james")
    sophia likes james
    println(sophia.likedPeople[0].name)
    ///

    // 3. operator 함수
//    operator fun Int.times(str: String) = str.repeat(this)  // 위에 있는 infix fun Int.time랑 같은 동작, 중복해서 쓸 수 없음
//    println(2 * "Bye ")

    operator fun String.get(range: IntRange) = substring(range)
    val str = "I want Audi A8 so much."
    print(str[0..10])
    ///

    // 4. varang 매개변수를 받는 함수
    printAllWithPrefix("Hello", "안녕하세요", "곤니찌와", prefix = "Greeting : ")

    log("Hello", "안녕하세요", "곤니찌와")
    ///
}

class Person(val name: String) {
    // mutableListof -> 코틀린에서 읽기/쓰기 수정이 가능한 리스
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) {likedPeople.add(other)}
}

