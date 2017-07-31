package com.jskj.jdmall.bean

/**
 * Created by cui on 17/7/29.
 */
class LoginBean {
    var success: Boolean = true
    var errorMsg: String = ""
    var result: Result? = null

    class Result {
        var id: String = ""
        var useName: String = ""
        var userIcon: String = ""// 头像路径
        var waitPayCount: Int = 0//待付款数
        var waitReceiveCount: Int = 0 //待收货数
        var userLevel: Int = 0// 用户等级（1注册会员2铜牌会员3银牌会员4金牌会员5钻石会员）
    }
}
