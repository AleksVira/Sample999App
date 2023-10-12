package com.example.sample999app.core

interface HandleDeath {

    fun firstOpening()

    fun wasDeathHappened(): Boolean

    fun deathHandled()

    class Base : HandleDeath {
        private var deathHappened = true

        override fun firstOpening() {
            deathHappened = false
        }

        override fun wasDeathHappened(): Boolean = deathHappened

        override fun deathHandled() {
            deathHappened = false
        }
    }
}