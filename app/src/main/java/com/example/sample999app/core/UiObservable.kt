package com.example.sample999app.core

import androidx.annotation.MainThread

interface UiObservable<T: Any>: UiUpdate<T>, UpdateObserver<T> {

/*
    class Base<T : Any> : UiObservable<T> {

        private var cache: T? = null
        private var observer: UiObserver<T> = UiObserver.Empty()


        override fun updateObserver(uiObserver: UiObserver<T>) {
            observer = uiObserver
            if (!observer.isEmpty()) {
                cache?.let {
                    observer.update(it)
                }
            }
        }

        override fun update(data: T) {
            if (observer.isEmpty()) {
                cache = data
            } else {
                cache = data
                observer.update(data)
            }
        }
    }
*/

    abstract class Single<T : Any> : UiObservable<T> {

        @Volatile
        private var cache: T? = null

        @Volatile
        private var observer: UiObserver<T> = UiObserver.Empty()

        @MainThread
        override fun updateObserver(uiObserver: UiObserver<T>) = synchronized(lock) {
            observer = uiObserver
            if (!observer.isEmpty()) {
                cache?.let {
                    observer.update(it)
                    cache = null
                }
            }
        }

        override fun update(data: T) = synchronized(lock){
            if (observer.isEmpty()) {
                cache = data
            } else {
                cache = null
                observer.update(data)
            }
        }
    }

    companion object {
        private val lock = Object()
    }
}


interface UiUpdate<T : Any>{
    fun update(data: T)
}

interface UpdateObserver<T : Any> {
    fun updateObserver(uiObserver: UiObserver<T> = UiObserver.Empty())
}


interface UiObserver<T : Any> : UiUpdate<T> {

    fun isEmpty(): Boolean = false

    class Empty<T: Any> : UiObserver<T> {
        override fun isEmpty() = true
        override fun update(data: T) = Unit
    }
}
