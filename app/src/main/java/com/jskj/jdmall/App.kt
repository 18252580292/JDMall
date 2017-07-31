package com.jskj.jdmall

import android.app.Application
import com.jskj.jdmall.util.NotNullSingleValue
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

/**
 * 全局Application类
 */
class App : Application() {

    companion object {
        //使用代理模式来代理app,防止Application初重复创建
        var app: App by NotNullSingleValue.DelegatExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        Logger.addLogAdapter(AndroidLogAdapter())
    }
}