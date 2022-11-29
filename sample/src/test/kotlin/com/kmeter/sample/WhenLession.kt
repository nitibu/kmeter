package com.kmeter.sample

import org.junit.jupiter.api.Test

fun cases(obj : Any) {
    when (obj) {
        1 -> println("One")
        "Hello" -> println("Greeting")
        is Long -> println("Long")
        !is String -> println("Not a string")
        else -> println("Unknow")
    }
}

fun whenAssign(obj: Any) {
    val result = when (obj) {
        1 -> "one"
        "Hello" -> 1
        is Long -> false
        else -> 42
    }
}

class WhenLession {

    @Test
    fun testWhen() {
        cases("Hello")
        cases(1)
        cases(0L)
        cases(WhenLession())
        cases("hello")
    }

    @Test
    fun testWhenAssign() {
        println(whenAssign("Hello"))
        println(whenAssign(3.4))
        println(whenAssign(1))
        println(whenAssign(WhenLession()))
    }
}