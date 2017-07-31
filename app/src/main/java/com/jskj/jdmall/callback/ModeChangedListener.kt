package com.jskj.jdmall.callback

/**
 * Created by cui on 17/7/29.
 */
interface ModeChangedListener {
    fun <T> onSuccess(t: T)
    fun onError()
}