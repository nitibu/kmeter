package com.kmeter.sample

import org.junit.jupiter.api.Test

class MutableStack<E> (vararg items: E) {
    private  val elements = items.toMutableList()

    fun push(element: E) = elements.add(element)

    fun peek(): E = elements.last()

    fun pop(): E = elements.removeAt(elements.size - 1)

    fun isEmpty() = elements.isEmpty()

    fun size() = elements.size

    override fun toString() = "MultableStack(${elements.joinToString()})"

}

fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)

class GenericLession {
    @Test
    fun testCreateIntMutableStack() {
        val stack = mutableStackOf(0.62, 2.14, 2.7)
        println(stack)
    }
}
