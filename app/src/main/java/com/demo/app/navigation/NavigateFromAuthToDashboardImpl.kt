package com.demo.app.navigation

import androidx.navigation.NavController
import com.demo.app.R
import com.demo.core.navigation.actions.NavigateFromAuthToDashboard

/**
 * @author Sergey Chuprin
 */
class NavigateFromAuthToDashboardImpl : NavigateFromAuthToDashboard {

    override fun navigate(navController: NavController) {
        navController.navigate(R.id.action_auth_to_dashboard)
    }

}