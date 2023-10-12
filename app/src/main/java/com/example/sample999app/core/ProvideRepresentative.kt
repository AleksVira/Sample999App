package com.example.sample999app.core

import com.example.sample999app.dashboard.DashboardModule
import com.example.sample999app.dashboard.DashboardRepresentative
import com.example.sample999app.main.MainModule
import com.example.sample999app.main.MainRepresentative
import com.example.sample999app.subscription.SubscriptionModule
import com.example.sample999app.subscription.SubscriptionRepresentative

interface ProvideRepresentative {

    fun <T : Representative<*>> provideRepresentative(clasz: Class<T>) : T

    class Factory(
        private val core: Core,
        private val clear: ClearRepresentative
    ) : ProvideRepresentative {
        override fun <T : Representative<*>> provideRepresentative(clasz: Class<T>): T = when (clasz) {
            MainRepresentative::class.java -> MainModule(core).representative()
            DashboardRepresentative::class.java -> DashboardModule(core).representative()
            SubscriptionRepresentative::class.java -> SubscriptionModule(core, clear).representative()
            else -> throw IllegalStateException("unknown class $clasz")
        } as T
    }

}