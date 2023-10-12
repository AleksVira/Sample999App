package com.example.sample999app.core

interface Representative<T: Any> {

    fun startGettingUpdates(callback: UiObserver<T>) = Unit

    fun stopGettingUpdates() = Unit

}