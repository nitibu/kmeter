package com.kmeter.sample

import org.junit.jupiter.api.Test


class LoopsLession {
    val cakes = listOf<String>("carrot", "cheese", "chocolate")

    fun eatACake() = println("Eat a Cake")
    fun bakeCake() = println("Bake a Cake")

    @Test
    fun testListCakes() {
        for (cake in cakes) {
            println("Yummy, it's a $cake cake")
        }
    }

    @Test
    fun testWhileLoop() {
        var cakesEaten = 0
        var cakesBaked = 0

        while (cakesEaten < 5) {
            eatACake()
            cakesEaten ++
        }

        do {
            bakeCake()
            cakesBaked ++
        } while (cakesBaked < cakesEaten)
    }

    data class Animal(
        val name: String
    )

    class Zoo(val animals: List<Animal>) {
        operator fun iterator(): Iterator<Animal> {
            return  animals.iterator()
        }
    }

    @Test
    fun testIerator() {
        val zoo = listOf<Animal>(Animal("zebra"), Animal("lion"))
        for (animal in zoo) {
            println("Watch out, it's a ${animal.name}")
        }
    }

    @Test
    fun testPrintNewFormat() {
        val name = "Allen"
        val fullName = "Ni $name".also(::println)
        println(name)
        println(fullName.replaceFirstChar { it.lowercase() })

    }

}