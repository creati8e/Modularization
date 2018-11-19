package com.demo.modularization.feature.impl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.demo.feature_impl.R
import com.demo.modularization.feature.api.AuthInteractor
import com.demo.modularization.feature.impl.di.AuthComponent
import javax.inject.Inject

/**
 * @author Sergey Chuprin
 */
class AuthFragment : Fragment() {

    @Inject
    lateinit var interactor: AuthInteractor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AuthComponent.initAndGet().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_auth, container, false)
    }

    override fun onStart() {
        super.onStart()
        interactor.doSomething()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (activity?.isFinishing == true) {
            AuthComponent.reset()
        }
    }

}