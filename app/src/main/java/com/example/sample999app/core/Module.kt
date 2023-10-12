package com.example.sample999app.core

interface Module<T : Representative<*>> {

    fun representative() : T
}