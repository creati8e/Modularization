package com.demo.feature.auth.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.demo.core.api.presentation.navigation.actions.NavigateFromAuthToDashboard
import com.demo.core.api.viewmodel.componentViewModel
import com.demo.feature.auth.R
import com.demo.feature.auth.di.AuthComponent
import com.demo.feature.auth.domain.AuthGateway
import kotlinx.android.synthetic.main.fragment_auth.*
import javax.inject.Inject

/**
 * @author Sergey Chuprin
 */
class AuthFragment : Fragment() {

    @Inject lateinit var authGateway: AuthGateway
    @Inject lateinit var navigateFromAuthToDashboard: NavigateFromAuthToDashboard

    private val componentVm by componentViewModel { AuthComponent.provide() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        componentVm.component.inject(this)
    }

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

}