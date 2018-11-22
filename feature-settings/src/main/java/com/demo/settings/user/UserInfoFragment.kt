package com.demo.settings.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.demo.core.ui.BaseFragment
import com.demo.settings.R
import com.demo.settings.SettingsFragmentNavigator
import com.demo.settings.SettingsProviderHolder
import com.demo.settings.common.domain.gateway.SettingsGateway
import com.demo.settings.common.domain.model.UserSettingsModel
import kotlinx.android.synthetic.main.fragment_user_settings.*
import javax.inject.Inject

/**
 * @author Sergey Chuprin
 */
class UserInfoFragment : BaseFragment<UserInfoComponentHolder>() {

    @Inject lateinit var settingsGateway: SettingsGateway

    private val navigator: SettingsFragmentNavigator
        get() = parentFragment as SettingsFragmentNavigator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_user_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            val userModel = settingsGateway.userSettings
            emailEditText.setText(userModel.email)
            usernameEditText.setText(userModel.username)
        }
        saveButton.setOnClickListener {
            settingsGateway.userSettings = UserSettingsModel(
                emailEditText.text.toString(),
                usernameEditText.text.toString()
            )
            navigator.navigateBack()
        }
    }

    override fun provideComponentHolder(arguments: Bundle?): UserInfoComponentHolder {
        val provider = (parentFragment as SettingsProviderHolder).settingsProvider
        return UserInfoComponentHolder(provider)
    }

}