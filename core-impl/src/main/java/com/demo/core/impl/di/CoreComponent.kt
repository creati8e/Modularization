package com.demo.core.impl.di

import com.demo.core.api.di.provider.DataSourcesProvider
import dagger.Component
import javax.inject.Singleton

/**
 * @author Sergey Chuprin
 */
@Singleton
@Component(modules = [CoreModule::class])
interface CoreComponent : DataSourcesProvider