package com.demo.feature.dashboard.presentation

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.core.api.presentation.navigation.actions.NavigateFromDashboardToSettings
import com.demo.core.api.viewmodel.componentViewModel
import com.demo.feature.dashboard.R
import com.demo.feature.dashboard.di.DashboardComponent
import com.demo.feature.dashboard.domain.gateway.DashboardGateway
import com.demo.feature.dashboard.presentation.adapter.DashboardEntryDiffCallback
import com.demo.feature.dashboard.presentation.adapter.renderer.DashboardEntryRenderer
import com.demo.feature.purchase.api.domain.gateway.PurchaseGateway
import kotlinx.android.synthetic.main.fragment_dashboard.*
import serg.chuprin.adapter.DiffMultiViewAdapter
import javax.inject.Inject

/**
 * @author Sergey Chuprin
 */
class DashboardFragment : Fragment() {

    @Inject lateinit var purchaseGateway: PurchaseGateway
    @Inject lateinit var dashboardGateway: DashboardGateway
    @Inject lateinit var navigateFromDashboardToSettings: NavigateFromDashboardToSettings

    private val componentViewModel by componentViewModel { DashboardComponent.provide() }

    private val entriesAdapter = DiffMultiViewAdapter(DashboardEntryDiffCallback()).apply {
        registerRenderer(DashboardEntryRenderer())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        componentViewModel.component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.adapter = entriesAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        entriesAdapter.setItems(dashboardGateway.getEntries())

        entriesAdapter.clickListener = { _, _, _ ->
            navigateFromDashboardToSettings.navigate(view.findNavController())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_dashboard, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_action_purchase) {
            if (purchaseGateway.purchase("premium")) {
                Toast.makeText(requireContext(), "Purchased", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}