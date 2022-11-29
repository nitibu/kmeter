package com.kmeter.sample

import main.java.com.example.kmeter.HybridClientConfig
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testPropertyReference() {
        val strs = listOf<String>("a", "bc", "def")
        println(strs.map(String::length))
    }

    @Test
    fun testSequenceYield() {
        val oddNumbers = sequence { yield(1)
            yieldAll(listOf(3, 5))
            yieldAll(generateSequence(7) { it + 2 }) }
        println(oddNumbers.take(5).toList())
    }

    @Test fun testZipList() {
        val colors = listOf("red", "brown", "grey")
        val animals = listOf("fox", "bear", "wolf")
        println(colors zip animals)
        val twoAnimals = listOf("fox", "bear")
        println(colors.zip(twoAnimals))
    }

    @Test fun testAssociateWith() {
        val numbers = listOf("one", "two", "three", "four")
        println(numbers.associateWith { it.length })
    }

    @Test fun testAssociateBy() {
        val numbers = listOf("one", "two", "three", "four")
        println(numbers.associateBy { it.first().uppercaseChar() })
        println(numbers.associateBy(keySelector = { it.first().uppercaseChar() }, valueTransform = { it.length }))
    }

    @Test fun testAssociate() {
        data class FullName (val firstName: String, val lastName: String)
        fun parseFullName(fullName: String): FullName { val nameParts = fullName.split(" ")
            if (nameParts.size == 2) {
                return FullName(nameParts[0], nameParts[1]) } else throw Exception("Wrong name format")
        }

        val names = listOf("Alice Adams", "Brian Brown", "Clara Campbell")
        println(names.associate { name -> parseFullName(name).let { it.lastName to it.firstName } })
    }

    @Test fun testJoinApi() {
        val numbers = listOf("one", "two", "three", "four")
        println(numbers)
        println(numbers.joinToString())
        val listString = StringBuffer("The list of numbers: ")
        numbers.joinTo(listString)
        println(listString)
    }

    @Test fun testJoinLimit() {
        val numbers = (1..100).toList()
        println(numbers.joinToString(limit = 10, truncated = "<...>"))
    }

    @Test fun testPartition() {
        val numbers = listOf("one", "two", "three", "four")
        val (match, rest) = numbers.partition { it.length > 3 }
        println(match)
        println(rest)
    }

    @Test fun testMapValues() {
        val temp = mapOf(
            "a" to listOf("allen"),
            "b" to listOf("bao"),
            "c" to listOf("cherry")
        )
        println(temp)
        println(temp.values.sortedBy { it.first() })
    }

    @Test fun testFoldWithSelector() {
        val fruits = listOf("cherry", "blueberry", "citrus", "apple", "apricot", "banana", "coconut")

        val evenFruits = fruits.groupingBy { it.first() }
            .fold({ key, _ -> key to mutableListOf<String>() },
                { _, accumulator, element ->
                    println(accumulator)
                    accumulator.also { (_, list) ->
                        if (element.length % 2 == 0) list.add(element)
                    }
                })

        val sorted = evenFruits.values.sortedBy { it.first }
        println(sorted) // [(a, []), (b, [banana]), (c, [cherry, citrus])]
    }

    @Test fun testReduce() {
        val strings = listOf("a", "b", "c", "d")
        println(strings.reduce { acc, string ->
            println("$acc, $string")
            acc + string
        }) // abcd
        println(strings.reduceIndexed { index, acc, string ->
            println("$acc, $string, $index")
            acc + string + index }) // ab1c2d3

    }

    @Test fun testAggregated() {
        val numbers = listOf(3, 4, 5, 6, 7, 8, 9)

        val aggregated = numbers.groupingBy { it % 3 }.aggregate { key, accumulator: StringBuilder?, element, first ->
            if (first) // first element
                StringBuilder().append(key).append(":").append(element)
            else
                accumulator!!.append("-").append(element)
        }

        println(aggregated.values) // [0:3-6-9, 1:4-7, 2:5-8]
    }

    @Test fun testZipWithNext() {
        val numbers = listOf("one", "two", "three", "four", "five")
        println(numbers.zipWithNext())
        println(numbers.zipWithNext() { s1, s2 -> s1.length > s2.length})
    }

    @Test fun testLinkedAndSortedSet() {
        val numbers = linkedSetOf("one", "two", "three", "four", "five")
        println(numbers.elementAt(3))

        val numbersSortedSet = sortedSetOf("one", "two", "three", "four")
        println(numbersSortedSet)
        println(numbersSortedSet.elementAt(0))
    }

    @Test fun testDuplicateMethod() {
        HybridClientConfig.Builder().setTimeoutForShortRoute(1000L).setTimeoutForLongRoute(1000L);
    }

    @Test fun testIfNullThen() {
        var temp:String? = null
        val next = temp?: "aaa".also {
            "bbb"
        }
        println(next)
    }
}