package com.demo.modularization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.demo.modularization.di.FeatureStarter
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * @author Sergey Chuprin
 */
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startFeatureBtn.setOnClickListener {
            FeatureStarter.startAuth()
            view.findNavController().navigate(R.id.action_main_to_feature)
        }
    }

}