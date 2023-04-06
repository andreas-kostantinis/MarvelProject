package com.example.myapplication.utils

import java.math.BigInteger
import java.security.MessageDigest
import java.security.Timestamp
import java.util.*

class Constants {

    companion object{

        const val  PUBLIC_API_KEY = "79f9e28837b8c63f0b1df9f6aceb8ad9"
        const val  PRIVATE_API_KEY = "bea15874b6173a2d849d8dc032d057bbc6c19213"
        const val URL = "http://gateway.marvel.com/v1/public/"
        const val RESULT_SIZE= "10"
        const val BASE_URL= "http://gateway.marvel.com/"

        val ts : String = Date().time.toString()



        fun hashMd5() : String {

            val input = "$PRIVATE_API_KEY$ts$PUBLIC_API_KEY"
            val md = MessageDigest.getInstance("MD5")

            return BigInteger(1,md.digest(input.toByteArray())).toString(16).padStart(32,
                0.toChar()
            )

        }



    }

}