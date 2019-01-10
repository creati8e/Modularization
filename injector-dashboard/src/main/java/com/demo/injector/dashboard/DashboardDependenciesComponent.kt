package com.demo.injector.dashboard

import com.demo.core.api.di.tools.AppTools
import com.demo.core.api.di.tools.NavigationTools
import com.demo.feature.purchase.api.di.PurchaseApi
import dagger.Component

/**
 * @author Sergey Chuprin
 */
@Component(dependencies = [PurchaseApi::class, AppTools::class, NavigationTools::class])
internal interface DashboardDependenciesComponent :
    DashboardDependencies