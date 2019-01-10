package com.demo.feature.settings.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.demo.core.api.ui.BaseFragment
import com.demo.feature.settings.R
import com.demo.feature.settings.SettingsFragmentNavigator
import com.demo.feature.settings.SettingsToolsHolder
import com.demo.feature.settings.common.domain.gateway.SettingsGateway
import com.demo.feature.settings.common.domain.model.NotificationSettingsModel
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

    override fun provideComponentHolder(arguments: Bundle?): NotificationsComponentHolder {
        val provider = (parentFragment as SettingsToolsHolder).settingsTools
        return NotificationsComponentHolder(provider)
    }

}