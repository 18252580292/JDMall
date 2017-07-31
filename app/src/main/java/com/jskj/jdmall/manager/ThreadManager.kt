package com.jskj.jdmall.manager

import java.util.concurrent.Executors

/**
 * Created by cui on 17/7/29.
 */
class ThreadManager {
    companion object {
        private val executeService = Executors.newSingleThreadExecutor()
        /**
         * 用来执行子线程操作，为了防止多个线程同时运行，使用线程池
         */
        fun execute(runnable: Runnable) {
            executeService.execute(runnable)
        }
    }
}