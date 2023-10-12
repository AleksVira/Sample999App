package com.example.sample999app.main

import com.example.sample999app.core.Representative
import com.example.sample999app.core.UiObserver
import com.example.sample999app.dashboard.DashboardScreen

interface MainRepresentative : Representative<Screen> {

    fun showDashboard(firstTime: Boolean)

    class Base(
        private val navigation: Navigation.Mutable
    ) : MainRepresentative {

        override fun startGettingUpdates(callback: UiObserver<Screen>) {
            navigation.updateObserver(callback)
        }

        override fun stopGettingUpdates() = navigation.updateObserver()

        override fun showDashboard(firstTime: Boolean) {
            if (firstTime) {
                navigation.update(DashboardScreen)
            }
        }
    }

}
