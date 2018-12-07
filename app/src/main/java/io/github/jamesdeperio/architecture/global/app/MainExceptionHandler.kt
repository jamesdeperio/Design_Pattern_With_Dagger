/**
 * @author github.com/jamesdeperio
 * @version codepocket template builder v1.0
 */
package io.github.jamesdeperio.architecture.global.app
/*
* ANR ERROR CATCHER
 */
class MainExceptionHandler : Thread.UncaughtExceptionHandler {
    override fun uncaughtException(t: Thread?, e: Throwable?) {
        /*
            Handles ANR error.
         */
        System.exit(3)
    }
}
