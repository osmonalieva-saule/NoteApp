package com.example.noteapp.ui.utils

import android.content.Context
import android.content.SharedPreferences

 object PreferenceHelper {

    private lateinit var sharedPreferences: SharedPreferences
    fun unit(context: Context) {
        sharedPreferences = context.getSharedPreferences("shared", Context.MODE_PRIVATE)
    }

    var text: String?
        get() = sharedPreferences.getString("text", "")
        set(value) = sharedPreferences.edit().putString("text", value)!!.apply()

    var onBoard: Boolean
        get() = sharedPreferences.getBoolean("onBoard", false)
        set(value) = sharedPreferences.edit().putBoolean("onBoard", value).apply()

}