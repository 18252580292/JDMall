package com.jskj.jdmall.util

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by cui on 17/7/23.
 */
class NotNullSingleValue<T> : ReadWriteProperty<Any?, T> {
    var value: T? = null
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalArgumentException()
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        if (this.value == null) {
            this.value = value
        } else {
            throw IllegalArgumentException()
        }
    }

    object DelegatExt {
        fun <T> notNullSingleValue(): NotNullSingleValue<T> = NotNullSingleValue()
    }
}