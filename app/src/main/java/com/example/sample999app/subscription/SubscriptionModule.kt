package com.example.sample999app.subscription

import com.example.sample999app.core.ClearRepresentative
import com.example.sample999app.core.Core
import com.example.sample999app.core.Module
import com.example.sample999app.main.UserPremiumCache
import com.example.sample999app.subscription.SubscriptionRepresentative.Base

class SubscriptionModule(
    private val core: Core,
    private val clear: ClearRepresentative
) : Module<SubscriptionRepresentative> {

    override fun representative() = Base(
        clear,
        UserPremiumCache.Base(core.sharedPreferences()),
        core.navigation()
    )
}