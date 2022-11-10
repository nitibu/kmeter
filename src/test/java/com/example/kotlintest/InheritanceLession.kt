package com.telenav.sdk_automation

import org.junit.Test

open class Tiger(val origin: String) {
    fun sayHello() {
        println("A tiger from $origin says: grrhhh!")
    }
}

class SiberianTiger : Tiger("Siberia")

open class Lion(val name: String, val origin: String) {
    fun sayHello() {
        println("$name, the lion from $origin say: graoh")
    }
}

class Asiatic(name: String) : Lion(name = name, origin = "India")


class SampleTest {
    @Test
    fun testSayHello() {
        val tiger: Tiger = SiberianTiger()
        tiger.sayHello()
    }

    @Test
    fun testAsiatic() {
        val lion: Lion = Asiatic("Rufo")
        lion.sayHello()
    }
}
