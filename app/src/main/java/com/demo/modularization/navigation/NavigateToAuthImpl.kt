package com.demo.modularization.navigation

import androidx.navigation.NavController
import com.demo.modularization.R
import demo.com.navigation.actions.NavigateToAuth

/**
 * @author Sergey Chuprin
 */
class NavigateToAuthImpl : NavigateToAuth {

    override fun navigate(navController: NavController) {
        navController.navigate(R.id.action_to_auth)
    }

}