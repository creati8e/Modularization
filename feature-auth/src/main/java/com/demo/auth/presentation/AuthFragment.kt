package com.demo.auth.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.demo.auth.R
import com.demo.auth.di.AuthComponentHolder
import com.demo.auth.domain.AuthGateway
import com.demo.core.navigation.actions.NavigateFromAuthToDashboard
import com.demo.core.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_auth.*
import javax.inject.Inject

/**
 * @author Sergey Chuprin
 */
class AuthFragment : BaseFragment<AuthComponentHolder>() {

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

    override fun provideComponentHolder(arguments: Bundle?): AuthComponentHolder {
        return AuthComponentHolder(application)
    }

}