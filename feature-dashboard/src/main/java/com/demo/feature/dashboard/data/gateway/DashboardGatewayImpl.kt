package com.demo.feature.dashboard.data.gateway

import com.demo.core.api.presentation.ResourcesManager
import com.demo.feature.dashboard.R
import com.demo.feature.dashboard.domain.gateway.DashboardGateway
import com.demo.feature.dashboard.domain.model.DashboardEntryModel

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