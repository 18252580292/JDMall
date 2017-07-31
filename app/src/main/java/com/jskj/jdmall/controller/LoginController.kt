package com.jskj.jdmall.controller

import com.alibaba.fastjson.JSON
import com.jskj.jdmall.bean.LoginBean
import com.jskj.jdmall.constant.MessageAction
import com.jskj.jdmall.constant.NetworkConstants
import com.jskj.jdmall.util.NetworkUtils
import com.jskj.jdmall.util.StringUtils

/**
 * Created by cui on 17/7/29.
 */
class LoginController : BaseController() {

    override fun requestDataFromServer(action: Int, values: Array<out Any>) {
        when (action) {
            MessageAction.ACTION_LOGIN -> {
                processLoginAction(values[0] as String, values[1] as String)
            }

            MessageAction.ACTION_REGISTER_USER -> {
                processRegisterUserAction(values)
            }

            MessageAction.ACTION_RESET_PASSWORD -> {
                processResetPasswordAction(values)
            }

            else -> throw IllegalArgumentException("don't support action!!!")
        }
    }

    /**
     * 处理登录请求
     */
    fun processLoginAction(username: String, password: String) {
        val map = HashMap<String, String>()
        map.put("username", username)
        map.put("password", password)

        val resultJson = NetworkUtils.doPost(NetworkConstants.LOGIN_URL, map)
        if(StringUtils.isEmpty(resultJson)) {
            this.listener.onError()
        } else {
            val loginBean = JSON.parseObject(resultJson, LoginBean::class.java)
            this.listener.onSuccess(loginBean)
        }
    }

    fun processRegisterUserAction(values: Array<out Any>) {

    }

    fun processResetPasswordAction(values: Array<out Any>) {

    }

}