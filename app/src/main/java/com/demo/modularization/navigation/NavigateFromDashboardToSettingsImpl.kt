package com.demo.modularization.navigation

import androidx.navigation.NavController
import com.demo.modularization.R
import demo.com.navigation.actions.NavigateFromDashboardToSettings

/**
 * @author Sergey Chuprin
 */
class NavigateFromDashboardToSettingsImpl : NavigateFromDashboardToSettings {

    override fun navigate(navController: NavController) {
        navController.navigate(R.id.action_dashboard_to_settings)
    }

}