package demo.com.dashboard.impl.data

import demo.com.core.api.presentation.ResourcesManager
import demo.com.dashboard.R
import demo.com.dashboard.impl.domain.gateway.DashboardGateway
import demo.com.dashboard.impl.domain.model.DashboardEntryModel

/**
 * @author Sergey Chuprin
 */
class DashboardGatewayImpl(
    private val resourcesManager: ResourcesManager
) : DashboardGateway {

    override fun getEntries(): List<DashboardEntryModel> {
        return resourcesManager
            .getStringArray(R.array.dashboard_entries)
            .map(::DashboardEntryModel)
    }

}