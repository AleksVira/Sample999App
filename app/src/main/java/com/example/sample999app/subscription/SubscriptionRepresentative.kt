package com.example.sample999app.subscription

import com.example.sample999app.core.ClearRepresentative
import com.example.sample999app.core.Representative
import com.example.sample999app.dashboard.DashboardRepresentative
import com.example.sample999app.dashboard.DashboardScreen
import com.example.sample999app.main.Navigation
import com.example.sample999app.main.UserPremiumCache

interface SubscriptionRepresentative : Representative<Unit> {

    fun subscribe()

    class Base(
        private val clear: ClearRepresentative,
        private val userPremiumCache: UserPremiumCache.Save,
        private val navigation: Navigation.Update
    ) : SubscriptionRepresentative {

        override fun subscribe() {
            userPremiumCache.saveUserPremium()
            clear.clear(DashboardRepresentative::class.java)
            clear.clear(SubscriptionRepresentative::class.java)
            navigation.update(DashboardScreen)
        }
    }
}