package com.demo.core.navigation

import com.demo.core.navigation.actions.NavigateFromAuthToDashboard
import com.demo.core.navigation.actions.NavigateFromDashboardToSettings
import com.demo.core.navigation.actions.NavigateToAuth

/**
 * @author Sergey Chuprin
 */
interface NavigationProvider {

    val navigateToAuth: NavigateToAuth

    val navigateFromAuthToDashboard: NavigateFromAuthToDashboard

    val navigateFromDashboardToSettings: NavigateFromDashboardToSettings

}