package com.demo.modularization.di

import com.demo.modularization.ModularizationApplication
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * @author Sergey Chuprin
 */
@Component()
@Singleton
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: ModularizationApplication): Builder

        fun build(): AppComponent
    }

}