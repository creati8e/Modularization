package demo.com.purchase.impl.di

import dagger.Component
import demo.com.core.api.di.provider.AppUtilsProvider
import demo.com.core.api.di.scope.PerFeature
import demo.com.purchase.api.di.PurchaseApi

/**
 * @author Sergey Chuprin
 */
@PerFeature
@Component(modules = [PurchaseModule::class], dependencies = [AppUtilsProvider::class])
interface PurchaseComponent : PurchaseApi