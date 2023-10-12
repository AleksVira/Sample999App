package com.example.sample999app.dashboard

import com.example.sample999app.core.HideAndShow

interface PremiumDashboardUiState {

    fun show(button: HideAndShow, text: HideAndShow)

    object Playing : PremiumDashboardUiState {
        override fun show(button: HideAndShow, text: HideAndShow) {
            button.hide()
            text.show()
        }
    }
}
