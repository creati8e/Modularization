package com.demo.core.api.di.tools

import com.demo.core.api.presentation.navigation.actions.NavigateFromAuthToDashboard
import com.demo.core.api.presentation.navigation.actions.NavigateFromDashboardToSettings
import com.demo.core.api.presentation.navigation.actions.NavigateToAuth

/**
 * @author Sergey Chuprin
 */
interface NavigationTools {

    val navigateToAuth: NavigateToAuth

    val navigateFromAuthToDashboard: NavigateFromAuthToDashboard

    val navigateFromDashboardToSettings: NavigateFromDashboardToSettings

}