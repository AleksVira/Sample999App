package com.example.sample999app.dashboard

import com.example.sample999app.core.UiObservable

interface PremiumDashboardObservable : UiObservable<PremiumDashboardUiState> {

    class Base : UiObservable.Single<PremiumDashboardUiState>(), PremiumDashboardObservable

}
