package com.demo.modularization.feature.impl.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.demo.feature_impl.R
import com.demo.modularization.feature.impl.di.AuthComponentHolder
import com.demo.modularization.feature.impl.domain.AuthGateway
import demo.com.navigation.actions.NavigateFromAuthToDashboard
import kotlinx.android.synthetic.main.fragment_auth.*
import javax.inject.Inject

/**
 * @author Sergey Chuprin
 */
class AuthFragment : demo.com.utils.ui.BaseFragment<AuthComponentHolder>() {

    @Inject lateinit var authGateway: AuthGateway
    @Inject lateinit var navigateFromAuthToDashboard: NavigateFromAuthToDashboard

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_auth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        signInButton.setOnClickListener {
            authGateway.signIn(loginEditText.text.toString(), passwordEditText.text.toString())

            Toast.makeText(requireContext(), "You are signed in", Toast.LENGTH_SHORT).show()
            navigateFromAuthToDashboard.navigate(view.findNavController())
        }
    }

    override fun provideComponent(arguments: Bundle?): AuthComponentHolder {
        return AuthComponentHolder(application)
    }

}