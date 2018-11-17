package spark.ru.modularization

import android.app.Application
import spark.ru.modularization.di.AppComponent
import spark.ru.modularization.di.DaggerAppComponent

/**
 * @author Sergey Chuprin
 */
class ModularizationApplication : Application() {

    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().application(this).build()
    }

}