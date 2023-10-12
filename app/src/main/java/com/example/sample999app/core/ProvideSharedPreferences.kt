package com.example.sample999app.core

import android.content.Context
import android.content.SharedPreferences
import com.example.sample999app.main.Navigation

interface ProvideSharedPreferences {

    fun sharedPreferences(): SharedPreferences




//    class Base(private val context: Context) : ProvideSharedPreferences {
//        override fun sharedPreferences(): SharedPreferences {
//            return context.getSharedPreferences("sample999", Context.MODE_PRIVATE)
//        }
//    }
}


interface ProvideNavigation {
    fun navigation(): Navigation.Mutable
}

interface Core : ProvideNavigation, ProvideSharedPreferences {

    class Base(private val context: Context) : Core {

        private val navigation = Navigation.Base()

        override fun navigation(): Navigation.Mutable = navigation

        override fun sharedPreferences(): SharedPreferences {
            return context.getSharedPreferences("sample999", Context.MODE_PRIVATE)
        }
    }

}