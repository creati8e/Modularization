package spark.ru.feature.impl.di

import dagger.Component
import spark.ru.feature.api.di.FeatureApi
import spark.ru.feature.impl.FeatureFragment

/**
 * @author Sergey Chuprin
 */
@Component(modules = [FeatureModule::class])
interface FeatureComponent : FeatureApi {

    fun inject(fragment: FeatureFragment)

    companion object {

        private var component: FeatureComponent? = null

        @Synchronized
        fun initAndGet(): FeatureComponent {
            if (component != null) return component!!
            component = DaggerFeatureComponent.create()
            return component!!
        }

        fun reset() {
            component = null
        }

    }

}