package com.kmeter.sample

import java.lang.Exception

var neverNull: String = "This can't be null"
var nullable: String? = "you can keep a null here"
var inferredNonNull = "The compiler assumes non-null"

fun strLength(notNull: String): Int {
    return notNull.length
}

fun main() {
    try {
        nullable = null
        println(nullable)
        println(nullable?.let { strLength(it) })
        println(inferredNonNull?.let { strLength(it) })
    } catch(e: Exception) {
        println(e.message)
    }
}