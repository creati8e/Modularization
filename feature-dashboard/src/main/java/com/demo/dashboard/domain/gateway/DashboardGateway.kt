package com.demo.dashboard.domain.gateway

import com.demo.dashboard.domain.model.DashboardEntryModel

/**
 * @author Sergey Chuprin
 */
interface DashboardGateway {

    fun getEntries(): List<DashboardEntryModel>

}