package com.demo.modularization.feature.impl.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.demo.feature_impl.R
import com.demo.modularization.feature.impl.di.AuthComponentHolder
import com.demo.modularization.feature.impl.domain.AuthGateway
import demo.com.componentstore.BaseFragment
import kotlinx.android.synthetic.main.fragment_auth.*
import javax.inject.Inject

/**
 * @author Sergey Chuprin
 */
class AuthFragment : BaseFragment<AuthComponentHolder>() {

    @Inject
    lateinit var authGateway: AuthGateway

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("AuthFragment", componentHolder.component.toString())
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
            val result = authGateway.signIn(
                loginEditText.text.toString(),
                passwordEditText.text.toString()
            )

            // TODO: Navigate to dashboard.
            val message = if (result) "You are signed in" else "Error occurred"
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun provideComponent(savedInstanceState: Bundle?): AuthComponentHolder {
        return AuthComponentHolder(requireActivity().application)
    }

}