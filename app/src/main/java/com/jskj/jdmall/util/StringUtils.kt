package com.jskj.jdmall.util

/**
 * Created by cui on 17/7/23.
 */
class StringUtils {

    companion object {
        /**
         * 判断指定字符串是否为空
         *
         * @param str
         * @return
         */
        fun isEmpty(str: String?): Boolean {
            return str == "" || str == null
        }
    }
}