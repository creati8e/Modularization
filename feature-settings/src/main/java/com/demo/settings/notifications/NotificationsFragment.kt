package com.demo.settings.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.demo.core.ui.BaseFragment
import com.demo.settings.R
import com.demo.settings.SettingsFragmentNavigator
import com.demo.settings.SettingsProviderHolder
import com.demo.settings.common.domain.gateway.SettingsGateway
import com.demo.settings.common.domain.model.NotificationSettingsModel
import kotlinx.android.synthetic.main.fragment_notification_settings.*
import javax.inject.Inject

/**
 * @author Sergey Chuprin
 */
class NotificationsFragment : BaseFragment<NotificationsComponentHolder>() {

    @Inject
    lateinit var settingsGateway: SettingsGateway

    private val navigator: SettingsFragmentNavigator
        get() = parentFragment as SettingsFragmentNavigator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_notification_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val notifications = settingsGateway.notificationSettings
        emailSwitch.isChecked = notifications.emailEnabled
        pushSwitch.isChecked = notifications.pushesEnabled

        saveButton.setOnClickListener {
            settingsGateway.notificationSettings = NotificationSettingsModel(
                pushesEnabled = pushSwitch.isChecked,
                emailEnabled = emailSwitch.isChecked
            )
            navigator.navigateBack()
        }
    }

    override fun provideComponent(arguments: Bundle?): NotificationsComponentHolder {
        val provider = (parentFragment as SettingsProviderHolder).settingsProvider
        return NotificationsComponentHolder(provider)
    }

}