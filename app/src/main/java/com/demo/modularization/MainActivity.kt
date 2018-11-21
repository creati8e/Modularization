package com.demo.modularization

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import demo.com.core.api.presentation.CanHandleBackPress
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        if (handleBackInFragment().not()) {
            super.onBackPressed()
        }
    }

    private fun handleBackInFragment(): Boolean {
        return (navHostFragment
            ?.childFragmentManager
            ?.fragments
            ?.getOrNull(0) as? CanHandleBackPress)
            ?.handleBackPress()
            ?: false
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.navHostFragment).navigateUp()
    }

}
