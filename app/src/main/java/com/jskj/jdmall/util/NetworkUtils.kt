package com.jskj.jdmall.util

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by cui on 17/7/29.
 */
class NetworkUtils {
    companion object {
        fun doPost(url:String, params: Map<String, String>): String {
            var url = URL(url)
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "POST"
            conn.doOutput = true
            var requestData = ""
            params.entries.toHashSet().forEach {
                requestData += "&${it!!.key}=${it!!.value}"
            }


            requestData = requestData.substring(1)

            conn.outputStream.write(requestData.toByteArray())

            if(conn.responseCode == 200) {
                val inputStream = conn.inputStream
                val bufferedReader = BufferedReader(InputStreamReader(inputStream))
                return bufferedReader.readLine()
            }

            return ""
        }
    }
}