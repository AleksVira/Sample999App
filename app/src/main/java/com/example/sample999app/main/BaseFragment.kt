package com.example.sample999app.main

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.example.sample999app.core.ProvideRepresentative
import com.example.sample999app.core.Representative

abstract class BaseFragment<T : Representative<*>>(@LayoutRes layoutId: Int) : Fragment(layoutId) {

    protected lateinit var representative: T

    protected abstract val clasz: Class<T>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        representative = (requireActivity() as ProvideRepresentative).provideRepresentative(clasz)
    }

}