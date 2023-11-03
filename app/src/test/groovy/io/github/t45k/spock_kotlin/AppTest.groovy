package io.github.t45k.spock_kotlin

import kotlin.coroutines.EmptyCoroutineContext
import kotlinx.coroutines.BuildersKt
import spock.lang.Specification

class AppTest extends Specification {

    def 'test suspend fun'() {
        expect:
        AppKt.suspendFun() == 'Hello from suspend'
    }

    def 'test suspend fun with arg'() {
        expect:
        // null can be passed
        AppKt.suspendFunWithArg('Task', null) == 'Hello Task'
    }

    def 'test suspend fun calling another suspend fun'() {
        expect:
        AppKt.suspendFunCallingAnotherSuspendFun() == 'Hello from suspend'
    }

    def 'test suspend fun of IO'() {
        expect:
        testBlocking { AppKt.io(it) } == 'Hello from suspend'
    }

    def testBlocking(closure) {
        BuildersKt.runBlocking(EmptyCoroutineContext.INSTANCE, (_, continuation) -> closure(continuation))
    }
}
