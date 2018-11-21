package com.demo.purchase.impl.di

import com.demo.core.api.di.provider.AppUtilsProvider
import com.demo.core.api.di.scope.PerFeature
import com.demo.purchase.api.di.PurchaseApi
import dagger.Component

/**
 * @author Sergey Chuprin
 */
@PerFeature
@Component(modules = [PurchaseModule::class], dependencies = [AppUtilsProvider::class])
interface PurchaseComponent : PurchaseApi