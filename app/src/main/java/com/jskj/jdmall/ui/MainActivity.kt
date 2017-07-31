package com.jskj.jdmall.ui

import android.os.Handler
import android.os.Message
import android.support.annotation.LayoutRes
import android.support.design.widget.TextInputEditText
import android.view.View
import android.widget.Button
import com.jskj.jdmall.R
import com.jskj.jdmall.bean.LoginBean
import com.jskj.jdmall.callback.ModeChangedListener
import com.jskj.jdmall.constant.MessageAction
import com.jskj.jdmall.controller.BaseController
import com.jskj.jdmall.controller.LoginController
import com.jskj.jdmall.util.StringUtils
import com.jskj.jdmall.util.toast
import com.orhanobut.logger.Logger
import java.lang.ref.WeakReference

class MainActivity : BaseActivity(), View.OnClickListener, ModeChangedListener {
    lateinit var mHandler:LoginHandler
    lateinit var tvUsername: TextInputEditText
    lateinit var tvPassword: TextInputEditText
    lateinit var btnLogin: Button
    lateinit var baseController: BaseController
    @LayoutRes
    override fun loadView(): Int {
        mHandler = LoginHandler(this)
        return R.layout.activity_main
    }

    override fun initView() {
        baseController = LoginController()
        baseController.setOnModeChangedListener(this)
        tvUsername = findViewById(R.id.tv_username) as TextInputEditText
        tvPassword = findViewById(R.id.tv_password) as TextInputEditText
        btnLogin = findViewById(R.id.btn_login) as Button
    }

    override fun initData() {
    }

    override fun initEvent() {
        btnLogin.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        when (view?.id) {
            R.id.btn_login -> {
                if (StringUtils.isEmpty(tvUsername.text.toString())) {
                    tvUsername.error = "用户名不能为空"
                }
                if (StringUtils.isEmpty(tvPassword.text.toString())) {
                    tvPassword.error = "密码不能为空"
                }
            }
        }

        //如果用户名和密码都不为空，则去请求网络验证用户名和密码的正确性
        baseController.requestAsync(MessageAction.ACTION_LOGIN, tvUsername.text.toString(),
                tvPassword.text.toString())

    }

    override fun <T> onSuccess(t: T) {
        var loginBean = t as LoginBean
        val msg = Message.obtain()
        msg.what = MessageAction.MSG_LOGIN_SUCCESS
        msg.obj = loginBean
        mHandler.sendMessage(msg)
    }

    override fun onError() {
        mHandler.sendEmptyMessage(MessageAction.MSG_LOGIN_ERROR)
    }

    class LoginHandler: Handler {
        private var wtf:WeakReference<BaseActivity>
        constructor(activity: BaseActivity) {
            wtf = WeakReference(activity)
        }

        override fun handleMessage(msg: Message?) {
            when(msg?.what) {
                MessageAction.MSG_LOGIN_SUCCESS -> {
                    val loginBean = msg.obj as LoginBean
                    val loginActivity = wtf.get() as MainActivity
                    if(loginBean.success) {
                        loginActivity.toast("success")
                        Logger.d(loginBean.errorMsg)
                    } else {
                        loginActivity.toast(loginBean.errorMsg)
                        Logger.d(loginBean.errorMsg)
//                        loginActivity.toast(loginBean.errorMsg)
                    }
                }
                MessageAction.MSG_LOGIN_ERROR -> {
                    val loginActivity = wtf.get() as MainActivity
                    loginActivity.toast("未知的错误")
                }
            }
        }
    }
}