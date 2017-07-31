package com.jskj.jdmall.ui

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.Window

/**
 * Activity的基类，所有Activity需要继承此基类
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(loadView())
        initView()
        initData()
        initEvent()
    }

    /**
     * 初始化数据，具体由子类选择性实现
     */
    open fun initData() {

    }

    /**
     * 初始化事件，具体由子类选择性实现
     */
    open fun initEvent() {

    }

    /**
     * 初始化View ，具体由子类选择性实现
     */
    open fun initView() {

    }

    /**
     * 加载布局，子类必须实现
     */
    @LayoutRes
    abstract fun loadView(): Int
}