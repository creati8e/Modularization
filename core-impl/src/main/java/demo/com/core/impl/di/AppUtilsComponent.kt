package demo.com.core.impl.di

import dagger.BindsInstance
import dagger.Component
import demo.com.core.api.AppHolder
import demo.com.core.api.di.provider.AppUtilsProvider
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