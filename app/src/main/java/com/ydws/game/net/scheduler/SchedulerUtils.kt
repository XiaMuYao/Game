package com.ydws.game.net.scheduler


object SchedulerUtils {

    fun <T> ioToMain(): IoMainScheduler<T> {
        return IoMainScheduler()
    }

    fun <T> mainToMain(): MainToMainScheduler<T> {
        return MainToMainScheduler()
    }
}
