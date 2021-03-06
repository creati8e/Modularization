package com.demo.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.demo.core.api.presentation.CanHandleBackPress
import com.demo.core.ui.BaseFragment
import com.demo.settings.common.di.SettingsComponentHolder
import com.demo.settings.common.di.SettingsProvider
import com.demo.settings.notifications.NotificationsFragment
import com.demo.settings.user.UserInfoFragment

/**
 * @author Sergey Chuprin
 */
class SettingsFragment :
    BaseFragment<SettingsComponentHolder>(),
    SettingsFragmentNavigator,
    CanHandleBackPress,
    SettingsProviderHolder {

    override val settingsProvider: SettingsProvider get() = componentHolder.component

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

    override fun provideComponentHolder(arguments: Bundle?): SettingsComponentHolder {
        return SettingsComponentHolder(application)
    }

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