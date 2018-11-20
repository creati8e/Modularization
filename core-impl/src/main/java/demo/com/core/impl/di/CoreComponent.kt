package demo.com.core.impl.di

import dagger.Component
import demo.com.core.api.DataSourcesProvider
import javax.inject.Singleton

/**
 * @author Sergey Chuprin
 */
@Singleton
@Component(modules = [CoreModule::class])
interface CoreComponent : DataSourcesProvider