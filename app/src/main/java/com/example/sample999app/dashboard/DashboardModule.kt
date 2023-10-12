package com.example.sample999app.dashboard

import com.example.sample999app.core.Core
import com.example.sample999app.core.Module
import com.example.sample999app.main.UserPremiumCache

class DashboardModule(
    private val core: Core
) : Module<DashboardRepresentative> {

    override fun representative(): DashboardRepresentative {
        val cache = UserPremiumCache.Base(core.sharedPreferences())

        return if (cache.isUserPremium()) {
            DashboardRepresentative.Premium(PremiumDashboardObservable.Base())
        } else {
            DashboardRepresentative.Base(core.navigation())
        }

    }

}
