package com.demo.feature.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.demo.core.api.presentation.CanHandleBackPress
import com.demo.core.api.viewmodel.componentViewModel
import com.demo.feature.settings.common.di.SettingsComponent
import com.demo.feature.settings.common.di.SettingsTools
import com.demo.feature.settings.notifications.NotificationsFragment
import com.demo.feature.settings.user.UserInfoFragment

/**
 * @author Sergey Chuprin
 */
class SettingsFragment :
    Fragment(),
    SettingsFragmentNavigator,
    CanHandleBackPress,
    SettingsToolsHolder {

    override val settingsTools: SettingsTools get() = componentVm.component

    private val componentVm by componentViewModel { SettingsComponent.provide() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigate(SettingsMenuFragment())
    }

    override fun handleBackPress(): Boolean {
        val childFragments = childFragmentManager.fragments
        if (childFragments.singleOrNull() is SettingsMenuFragment) {
            childFragmentManager.popBackStackImmediate()
            return false
        }
        if (childFragments.isNotEmpty()) {
            childFragmentManager.popBackStackImmediate()
            return true
        }
        return false
    }

    override fun navigateToUserInfo() = navigate(UserInfoFragment())

    override fun navigateToNotifications() = navigate(NotificationsFragment())

    override fun navigateBack() {
        handleBackPress()
    }

    private fun navigate(fragment: Fragment) {
        childFragmentManager
            .beginTransaction()
            .replace(R.id.settingsFragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }

}