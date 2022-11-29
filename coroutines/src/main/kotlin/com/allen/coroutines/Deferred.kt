package com.allen.coroutines

interface Deferred<T>: Job {
    suspend fun await(): T
}