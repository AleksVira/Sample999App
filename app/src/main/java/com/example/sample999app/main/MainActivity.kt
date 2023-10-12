package com.example.sample999app.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sample999app.R
import com.example.sample999app.core.ProvideRepresentative
import com.example.sample999app.core.Representative
import com.example.sample999app.core.UiObserver

class MainActivity : AppCompatActivity(), ProvideRepresentative {

    private lateinit var representative: MainRepresentative

    private lateinit var activityCallback: ActivityCallback


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        (application as App).activityCreated(savedInstanceState == null)

        representative = provideRepresentative(MainRepresentative::class.java)

        activityCallback = object : ActivityCallback {
            override fun update(data: Screen) = runOnUiThread {
                data.show(supportFragmentManager, R.id.container)
            }
        }

        representative.showDashboard(savedInstanceState == null)
    }

    override fun onResume() {
        super.onResume()
        representative.startGettingUpdates(activityCallback)
    }

    override fun onPause() {
        super.onPause()
        representative.stopGettingUpdates()
    }

    override fun <T : Representative<*>> provideRepresentative(clasz: Class<T>): T =
        (application as ProvideRepresentative).provideRepresentative(clasz)
}

interface ActivityCallback : UiObserver<Screen>