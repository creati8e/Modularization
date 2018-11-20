package demo.com.dashboard.impl.domain.gateway

import demo.com.dashboard.impl.domain.model.DashboardEntryModel

/**
 * @author Sergey Chuprin
 */
interface DashboardGateway {

    fun getEntries(): List<DashboardEntryModel>

}