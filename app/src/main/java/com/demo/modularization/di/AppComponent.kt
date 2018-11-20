package com.demo.modularization.di

import dagger.Component
import demo.com.core.api.AppContextProvider
import demo.com.core.api.ApplicationProvider
import demo.com.core.api.DataSourcesProvider
import javax.inject.Singleton

/**
 * @author Sergey Chuprin
 */
@Singleton
@Component(dependencies = [DataSourcesProvider::class, AppContextProvider::class])
interface AppComponent : ApplicationProvider