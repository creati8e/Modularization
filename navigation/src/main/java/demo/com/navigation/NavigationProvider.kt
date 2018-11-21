package demo.com.navigation

import demo.com.navigation.actions.NavigateFromAuthToDashboard
import demo.com.navigation.actions.NavigateFromDashboardToSettings
import demo.com.navigation.actions.NavigateToAuth

/**
 * @author Sergey Chuprin
 */
interface NavigationProvider {

    val navigateToAuth: NavigateToAuth

    val navigateFromAuthToDashboard: NavigateFromAuthToDashboard

    val navigateFromDashboardToSettings: NavigateFromDashboardToSettings

}