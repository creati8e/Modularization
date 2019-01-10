package com.demo.feature.dashboard.di

import com.demo.core.api.di.scope.PerFeature
import com.demo.core.api.presentation.ResourcesManager
import com.demo.feature.dashboard.data.gateway.DashboardGatewayImpl
import com.demo.feature.dashboard.domain.gateway.DashboardGateway
import dagger.Module
import dagger.Provides

/**
 * @author Sergey Chuprin
 */
@Module
class DashboardModule {

    @Provides
    @PerFeature
    fun provideDashboardGateway(resourcesManager: ResourcesManager): DashboardGateway {
        return DashboardGatewayImpl(resourcesManager)
    }

}