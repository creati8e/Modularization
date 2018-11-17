package spark.ru.modularization.di

import dagger.BindsInstance
import dagger.Component
import spark.ru.modularization.ModularizationApplication
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