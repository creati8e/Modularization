package com.demo.app.di

import com.demo.core.navigation.NavigationProvider
import dagger.Component
import javax.inject.Singleton

/**
 * @author Sergey Chuprin
 */
@Singleton
@Component(modules = [NavigationModule::class])
interface NavigationComponent : NavigationProvider