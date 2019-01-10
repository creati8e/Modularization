package com.demo.feature.settings.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.demo.core.api.viewmodel.componentViewModel
import com.demo.feature.settings.R
import com.demo.feature.settings.SettingsFragmentNavigator
import com.demo.feature.settings.SettingsToolsHolder
import com.demo.feature.settings.common.domain.gateway.SettingsGateway
import com.demo.feature.settings.common.domain.model.UserSettingsModel
import kotlinx.android.synthetic.main.fragment_user_settings.*
import javax.inject.Inject

/**
 * @author Sergey Chuprin
 */
class UserInfoFragment : Fragment() {

    @Inject lateinit var settingsGateway: SettingsGateway

    private val componentViewModel by componentViewModel {
        val settingsTools = (parentFragment as SettingsToolsHolder).settingsTools
        UserInfoComponent.provide(settingsTools)
    }

    private val navigator: SettingsFragmentNavigator
        get() = parentFragment as SettingsFragmentNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        componentViewModel.component.inject(this)
    }

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

}