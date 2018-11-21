package com.demo.dashboard.data

import com.demo.core.api.presentation.ResourcesManager
import com.demo.dashboard.R
import com.demo.dashboard.domain.gateway.DashboardGateway
import com.demo.dashboard.domain.model.DashboardEntryModel

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