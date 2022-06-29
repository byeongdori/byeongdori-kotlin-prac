package org.kotlinlang.play

// 1. 클래스 선언, 사용
class Customer

class Contact(val id: Int, var email: String)
///

// 2. Generic 클래스 선언, 사용
class MutableStack<E> (vararg items: E) {

    private val elements = items.toMutableList()

    fun push(element: E) = elements.add(element)

    fun peek(): E = elements.last()

    fun pop(): E = elements.removeAt(elements.size - 1)

    fun isEmpty() = elements.isEmpty()

    fun size() = elements.size

    override fun toString() = "MutableStack(${elements.joinToString()})"
}

fun <E> mutableStackof(vararg elements: E) = MutableStack(*elements) // Generic 함수 또한 사용 가능
///

// 3. 상속
// open 키워드를 이용하면 이 클래스를 상속하는걸 허용함
open class Dog {
    open fun sayHello() {
        println("wow wow!")
    }
}

class Yorkshire : Dog() {
    override fun sayHello() {
        println("wif wif!")
    }
}

open class Tiger(val origin: String) {
    fun sayHello() {
        println("A tiger from $origin says: grrhhh!")
    }
}

// 부모클래스의 생성자와 함께 상속 받을 수 있음
class SiberianTiger : Tiger("Siberia")

open class Lion(val name: String, val origin: String) {
    fun sayHello() {
        println("$name, the lion from $origin says: graoh!")
    }
}

// 부모 클래스의 생성자에 매개변수 넘겨 줄 수 있음
class Asiatic(name: String) : Lion(name = name, origin = "India")

fun main() {

    // 1. 클래스 선언, 사용
    val customer = Customer()

    val contact = Contact(1, "test@gmail.com")

    println("${contact.id}, ${contact.email}")
    contact.email = "modify@gmail.com"

    println(contact.email)

    // 2. Generic Class 선언
    val stack = mutableStackof(0.62, 3.14, 2.7)
    val stack2 = MutableStack(1.23, 4.56, 7.89)
    println(stack)
    println(stack2)
    ///

    // 3. 상속
    val dog: Dog = Yorkshire()
    val small_dog = Dog()
    dog.sayHello()
    small_dog.sayHello()

    val tiger: Tiger = SiberianTiger()
    tiger.sayHello()

    val lion: Lion = Asiatic("Rufo")
    lion.sayHello()
}