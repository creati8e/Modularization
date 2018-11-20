package demo.com.core.impl.di

import dagger.BindsInstance
import dagger.Component
import demo.com.core.api.App
import demo.com.core.api.AppContextProvider
import javax.inject.Singleton

/**
 * @author Sergey Chuprin
 */
@Singleton
@Component(modules = [AppContextModule::class])
interface AppContextComponent : AppContextProvider {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun app(app: App): Builder

        fun build(): AppContextComponent
    }

}