package demo.com.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import demo.com.core.api.presentation.CanHandleBackPress
import demo.com.settings.common.di.SettingsComponentHolder
import demo.com.settings.common.di.SettingsProvider
import demo.com.settings.notifications.NotificationsFragment
import demo.com.settings.user.UserInfoFragment

/**
 * @author Sergey Chuprin
 */
class SettingsFragment :
    demo.com.utils.ui.BaseFragment<SettingsComponentHolder>(),
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

    override fun provideComponent(arguments: Bundle?): SettingsComponentHolder {
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