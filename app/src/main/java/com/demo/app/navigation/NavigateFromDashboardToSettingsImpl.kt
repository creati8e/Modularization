package com.demo.app.navigation

import androidx.navigation.NavController
import com.demo.app.R
import com.demo.core.api.presentation.navigation.actions.NavigateFromDashboardToSettings

/**
 * @author Sergey Chuprin
 */
class NavigateFromDashboardToSettingsImpl : NavigateFromDashboardToSettings {

    override fun navigate(navController: NavController) {
        navController.navigate(R.id.action_dashboard_to_settings)
    }

}