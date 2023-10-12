package com.example.sample999app.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

interface Screen {

    fun show(fragmentManager: FragmentManager, containerId: Int)

    abstract class Add(private val fragmentClass: Class<out Fragment>) : Screen {

        override fun show(fragmentManager: FragmentManager, containerId: Int) {
            fragmentManager.beginTransaction()
//                .replace(containerId, fragmentClass.newInstance())
                .replace(containerId, fragmentClass, null)
                .addToBackStack(fragmentClass.name)
                .commit()
        }
    }

    abstract class Replace(private val fragmentClass: Class<out Fragment>) : Screen {

        override fun show(fragmentManager: FragmentManager, containerId: Int) {
            fragmentManager.beginTransaction()
//                .replace(containerId, fragmentClass.newInstance())
                .replace(containerId, fragmentClass, null)
                .commit()
        }
    }

}