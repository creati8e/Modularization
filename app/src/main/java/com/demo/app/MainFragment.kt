package com.demo.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.demo.core.navigation.actions.NavigateToAuth
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

/**
 * @author Sergey Chuprin
 */
class MainFragment : Fragment() {

    @Inject
    lateinit var navigateToAuth: NavigateToAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as ModularizationApplication).component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startFeatureBtn.setOnClickListener { navigateToAuth.navigate(view.findNavController()) }
    }

}