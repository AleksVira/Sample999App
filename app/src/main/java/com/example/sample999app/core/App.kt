package com.example.sample999app.core

import android.app.Application
import android.util.Log

class App : Application(), ProvideRepresentative, ClearRepresentative {

    private val representativeMap = mutableMapOf<Class<out Representative<*>>, Representative<*>>()

    private lateinit var core: Core
    private lateinit var factory: ProvideRepresentative.Factory

//    private val handleDeath = HandleDeath.Base()

    override fun onCreate() {
        super.onCreate()
        core = Core.Base(this)
        factory = ProvideRepresentative.Factory(core, this)
    }

    override fun <T : Representative<*>> provideRepresentative(clasz: Class<T>): T = if (representativeMap.containsKey(clasz)) {
        representativeMap[clasz] as T
    } else {
        factory.provideRepresentative(clasz).let {
            representativeMap[clasz] = it
            it
        }
    }

    override fun clear(clasz: Class<out Representative<*>>) {
        representativeMap.remove(clasz)
    }

    fun activityCreated(b: Boolean) {
        Log.d("TAG", "APP activityCreated")
    }
}