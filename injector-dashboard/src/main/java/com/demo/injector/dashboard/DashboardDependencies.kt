package com.demo.injector.dashboard

import com.demo.core.api.di.tools.AppTools
import com.demo.core.api.di.tools.NavigationTools
import com.demo.feature.purchase.api.di.PurchaseApi

/**
 * @author Sergey Chuprin
 */
interface DashboardDependencies : PurchaseApi, AppTools, NavigationTools