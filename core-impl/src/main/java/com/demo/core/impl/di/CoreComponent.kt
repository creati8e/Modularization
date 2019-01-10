package com.demo.core.impl.di

import android.content.Context
import com.demo.core.api.di.tools.AppTools
import com.demo.core.api.di.tools.DataSourcesTools
import com.demo.core.api.di.tools.NavigationTools
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * @author Sergey Chuprin
 */
@Singleton
@Component(
    modules = [
        CoreModule::class,
        AppUtilsModule::class
    ],
    dependencies = [NavigationTools::class]
)
interface CoreComponent : DataSourcesTools, NavigationTools, AppTools {

    companion object {

        private lateinit var component: CoreComponent

        fun get(): CoreComponent = component

        fun init(context: Context, navigationTools: NavigationTools) {
            component = DaggerCoreComponent
                .builder()
                .context(context)
                .navigation(navigationTools)
                .build()
        }

    }

    @Component.Builder
    interface Builder {

        @BindsInstance
        @Singleton
        fun context(context: Context): Builder

        fun navigation(navigationTools: NavigationTools): Builder

        fun build(): CoreComponent

    }

}