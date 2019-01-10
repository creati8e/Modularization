package com.demo.feature.purchase.impl.di

import com.demo.core.api.di.scope.PerFeature
import com.demo.core.api.di.tools.AppTools
import com.demo.feature.purchase.api.di.PurchaseApi
import dagger.Component

/**
 * @author Sergey Chuprin
 */
@PerFeature
@Component(modules = [PurchaseModule::class], dependencies = [AppTools::class])
interface PurchaseComponent : PurchaseApi