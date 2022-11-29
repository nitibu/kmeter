package com.allen.coroutines

import kotlin.coroutines.CoroutineContext

class CoroutineName(val name: String): CoroutineContext.Element {
    companion object KEY: CoroutineContext.Key<CoroutineName>

    override val key: CoroutineContext.Key<*>
        get() = KEY

    override fun toString(): String {
        return name
    }
}