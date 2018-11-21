package demo.com.settings.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import demo.com.settings.R
import demo.com.settings.SettingsFragmentNavigator
import demo.com.settings.SettingsProviderHolder
import demo.com.settings.common.domain.gateway.SettingsGateway
import demo.com.settings.common.domain.model.UserSettingsModel
import kotlinx.android.synthetic.main.fragment_user_settings.*
import javax.inject.Inject

/**
 * @author Sergey Chuprin
 */
class UserInfoFragment : demo.com.utils.ui.BaseFragment<UserInfoComponentHolder>() {

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

    override fun provideComponent(arguments: Bundle?): UserInfoComponentHolder {
        val provider = (parentFragment as SettingsProviderHolder).settingsProvider
        return UserInfoComponentHolder(provider)
    }

}