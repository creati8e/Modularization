package com.demo.app.navigation

import androidx.navigation.NavController
import com.demo.app.R
import com.demo.core.navigation.actions.NavigateToAuth

/**
 * @author Sergey Chuprin
 */
class NavigateToAuthImpl : NavigateToAuth {

    override fun navigate(navController: NavController) {
        navController.navigate(R.id.action_to_auth)
    }

}