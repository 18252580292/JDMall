package com.jskj.jdmall.util

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.jskj.jdmall.App

/**
 * Created by cui on 17/7/26.
 */


fun AppCompatActivity.toast(msg: String, time: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(App.app, msg, time).show()
}

fun Fragment.toast(msg: String, time: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(App.app, msg, time).show()
}
