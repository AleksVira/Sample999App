package com.example.sample999app.dashboard

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.sample999app.R
import com.example.sample999app.core.CustomButton
import com.example.sample999app.core.CustomTextView
import com.example.sample999app.core.UiObserver
import com.example.sample999app.main.BaseFragment

class DashboardFragment: BaseFragment<DashboardRepresentative>(R.layout.fragment_dashboard) {

    override val clasz = DashboardRepresentative::class.java

    private lateinit var callBack: UiObserver<PremiumDashboardUiState>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view.findViewById<CustomTextView>(R.id.showPlayingTextView)
        val button = view.findViewById<CustomButton>(R.id.playButton)
        button?.setOnClickListener {
            representative.play()
        }

        callBack = object : UiObserver<PremiumDashboardUiState> {
            override fun update(data: PremiumDashboardUiState) = data.show(button, textView)
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "DashboardFragment_onResume():")
        representative.startGettingUpdates(callBack)
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "DashboardFragment_onPause():")
        representative.stopGettingUpdates()
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG", "DashboardFragment_onStop():")
    }

    override fun onDestroyView() {
        Log.d("TAG", "DashboardFragment_onDestroyView():")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d("TAG", "DashboardFragment_onDestroy():")
        super.onDestroy()
    }

}
