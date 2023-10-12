package com.example.sample999app.main

import com.example.sample999app.core.Core
import com.example.sample999app.core.Module

class MainModule(
    private val core: Core
): Module<MainRepresentative> {

    override fun representative(): MainRepresentative = MainRepresentative.Base(core.navigation())
}