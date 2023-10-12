package com.example.sample999app.dashboard

import com.example.sample999app.core.Representative
import com.example.sample999app.core.UiObserver
import com.example.sample999app.main.Navigation
import com.example.sample999app.subscription.SubscriptionScreen

interface DashboardRepresentative : Representative<PremiumDashboardUiState> {

    fun play()

    class Base(
        private val navigation: Navigation.Update
    ) : DashboardRepresentative {
        override fun play() = navigation.update(SubscriptionScreen)
    }

    class Premium(
        private val observable: PremiumDashboardObservable
    ) : DashboardRepresentative {
        override fun play() = observable.update(PremiumDashboardUiState.Playing)

        override fun startGettingUpdates(callback: UiObserver<PremiumDashboardUiState>) = observable.updateObserver(callback)

        override fun stopGettingUpdates() = observable.updateObserver()

    }

}