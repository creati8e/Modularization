package com.demo.feature.dashboard.domain.gateway

import com.demo.feature.dashboard.domain.model.DashboardEntryModel

/**
 * @author Sergey Chuprin
 */
interface DashboardGateway {

    fun getEntries(): List<DashboardEntryModel>

}