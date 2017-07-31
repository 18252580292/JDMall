package com.jskj.jdmall.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.jskj.jdmall.ui.BaseActivity

/**
 * Created by cui on 17/7/25.
 */
class ActivityUtils {
    companion object {
        fun start(context: Context, t:Class<out BaseActivity>, isFinished:Boolean = false) {
            val activity = context as Activity
            val intent = Intent(context, t)
            activity.startActivity(intent)
            if(isFinished) {
                activity.finish()
            }
        }
    }
}