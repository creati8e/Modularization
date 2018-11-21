package demo.com.dashboard.impl.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import demo.com.dashboard.R
import demo.com.dashboard.impl.di.DashboardComponentHolder
import demo.com.dashboard.impl.domain.gateway.DashboardGateway
import demo.com.dashboard.impl.presentation.adapter.DashboardEntryDiffCallback
import demo.com.dashboard.impl.presentation.adapter.renderer.DashboardEntryRenderer
import demo.com.navigation.actions.NavigateFromDashboardToSettings
import kotlinx.android.synthetic.main.fragment_dashboard.*
import serg.chuprin.adapter.DiffMultiViewAdapter
import javax.inject.Inject

/**
 * @author Sergey Chuprin
 */
class DashboardFragment : demo.com.utils.ui.BaseFragment<DashboardComponentHolder>() {

    @Inject lateinit var dashboardGateway: DashboardGateway
    @Inject lateinit var navigateFromDashboardToSettings: NavigateFromDashboardToSettings

    private val entriesAdapter = DiffMultiViewAdapter(DashboardEntryDiffCallback()).apply {
        registerRenderer(DashboardEntryRenderer())
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

    override fun provideComponent(arguments: Bundle?): DashboardComponentHolder {
        return DashboardComponentHolder(application)
    }

}