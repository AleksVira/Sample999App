package com.example.sample999app.subscription

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.sample999app.R
import com.example.sample999app.main.BaseFragment

class SubscriptionFragment : BaseFragment<SubscriptionRepresentative>(R.layout.fragment_subscription) {

    override val clasz = SubscriptionRepresentative::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.subscribeButton)
        button.setOnClickListener {
            representative.subscribe()
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "SubscriptionFragment onResume:")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "SubscriptionFragment onPause:")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG", "SubscriptionFragment onStop:")

    }

    override fun onDestroyView() {
        Log.d("TAG", "SubscriptionFragment onDestroyView:")
        super.onDestroyView()

    }

    override fun onDestroy() {
        Log.d("TAG", "SubscriptionFragment onDestroy:")
        super.onDestroy()
    }
}
