package com.demo.core.impl.di

import com.demo.core.api.AppHolder
import com.demo.core.api.di.provider.AppUtilsProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * @author Sergey Chuprin
 */
@Singleton
@Component(modules = [AppUtilsModule::class])
interface AppUtilsComponent : AppUtilsProvider {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun app(appHolder: AppHolder): Builder

        fun build(): AppUtilsComponent
    }

}