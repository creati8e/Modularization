package com.demo.feature.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_settings_menu.*

/**
 * @author Sergey Chuprin
 */
class SettingsMenuFragment : Fragment() {

    private val navigator: SettingsFragmentNavigator
        get() = parentFragment as SettingsFragmentNavigator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_settings_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userInfoButton.setOnClickListener { navigator.navigateToUserInfo() }
        notificationsButton.setOnClickListener { navigator.navigateToNotifications() }
    }

}