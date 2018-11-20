package com.demo.modularization.di

import dagger.Component
import demo.com.navigation.NavigationProvider
import javax.inject.Singleton

/**
 * @author Sergey Chuprin
 */
@Singleton
@Component(modules = [NavigationModule::class])
interface NavigationComponent : NavigationProvider