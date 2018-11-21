package com.demo.dashboard.presentation

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.core.navigation.actions.NavigateFromDashboardToSettings
import com.demo.core.ui.BaseFragment
import com.demo.dashboard.R
import com.demo.dashboard.di.DashboardComponentHolder
import com.demo.dashboard.domain.gateway.DashboardGateway
import com.demo.dashboard.presentation.adapter.DashboardEntryDiffCallback
import com.demo.dashboard.presentation.adapter.renderer.DashboardEntryRenderer
import com.demo.purchase.api.domain.interactor.PurchaseGateway
import kotlinx.android.synthetic.main.fragment_dashboard.*
import serg.chuprin.adapter.DiffMultiViewAdapter
import javax.inject.Inject

/**
 * @author Sergey Chuprin
 */
class DashboardFragment : BaseFragment<DashboardComponentHolder>() {

    @Inject lateinit var purchaseGateway: PurchaseGateway
    @Inject lateinit var dashboardGateway: DashboardGateway
    @Inject lateinit var navigateFromDashboardToSettings: NavigateFromDashboardToSettings

    private val entriesAdapter = DiffMultiViewAdapter(DashboardEntryDiffCallback()).apply {
        registerRenderer(DashboardEntryRenderer())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
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

    override fun provideComponent(arguments: Bundle?): DashboardComponentHolder {
        return DashboardComponentHolder(application)
    }

}