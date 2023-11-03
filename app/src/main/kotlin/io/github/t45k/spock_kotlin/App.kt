package io.github.t45k.spock_kotlin

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

fun main() {
}

suspend fun suspendFun() = "Hello from suspend"

suspend fun suspendFunWithArg(name: String) = "Hello $name"

suspend fun suspendFunCallingAnotherSuspendFun() = suspendFun()

suspend fun io() = withContext(Dispatchers.IO) {
    suspendFun()
}
