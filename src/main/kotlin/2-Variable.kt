package org.kotlinlang.play

fun main() {
    // 1. 변수 선언
    // var - 가변, val - 불변
    var a: String = "initial"
    val b: Int = 1
    val c = 3

    println("$a $b $c")
    ///

    // 2. Null Safety
    // null이 허용되지 않는 변수
    var neverNull: String = "This can't be null"
//    neverNull = null // null 값이 허용되지 않는 변수이기 때문에 -> 에러 발생!!

    // null이 허용되는 변수
    var nullable: String? = "You can keep a null here"
    nullable = null

    // 타입을 명시하지 않는 경우, null 값이 허용되지 않음
    var inferredNonNull = "The compiler assumes non-null"
//    inferredNonNull = null // 타입을 명시하지 않은 객체이기 때문에 -> 에러 발생!!

    // 매개변수로 non-nullable 한 String 사용
    fun strLength(notNull : String): Int {
        return notNull.length
    }

    strLength(neverNull)
//    strLength(nullable) // nullable 객체가 nullable형이기 때문에, 오류 발생

    // 매개변수로 nullable한 String 사용
    fun describeString(maybeString: String?): String {
        if (maybeString != null && maybeString.length > 0) {
            return "String of length ${maybeString.length}"
        } else {
            return "Empty or null string"
        }
    }

    println(describeString(null))
    println(describeString("Test String"))
    ///
}