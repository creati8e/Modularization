package com.demo.modularization.navigation

import androidx.navigation.NavController
import com.demo.modularization.R
import demo.com.navigation.actions.NavigateFromAuthToDashboard

/**
 * @author Sergey Chuprin
 */
class NavigateFromAuthToDashboardImpl : NavigateFromAuthToDashboard {

    override fun navigate(navController: NavController) {
        navController.navigate(R.id.action_auth_to_dashboard)
    }

}