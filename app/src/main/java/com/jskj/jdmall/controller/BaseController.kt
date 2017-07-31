package com.jskj.jdmall.controller

import com.jskj.jdmall.callback.ModeChangedListener
import com.jskj.jdmall.manager.ThreadManager

/**
 * Created by cui on 17/7/28.
 */
abstract class BaseController {
    protected lateinit var listener: ModeChangedListener
    /**
     *  请求网络
     */
    open fun requestAsync(action: Int, vararg values: Any) {
        ThreadManager.execute(Runnable {
            requestDataFromServer(action, values)
        })
    }

    open fun setOnModeChangedListener(listener: ModeChangedListener) {
        this.listener = listener
    }
    /**
     * 向服务器请求数据，具体由子类实现
     */
    abstract fun requestDataFromServer(action: Int, values: Array<out Any>)
}