package com.example.sample999app.main

import com.example.sample999app.core.UiObservable
import com.example.sample999app.core.UiUpdate
import com.example.sample999app.core.UpdateObserver

interface Navigation {
    interface Update : UiUpdate<Screen>
    interface Observe : UpdateObserver<Screen>
    interface Mutable : Update, Observe

    class Base : UiObservable.Single<Screen>(), Mutable
}