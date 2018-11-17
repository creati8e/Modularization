package spark.ru.feature.impl.di

import dagger.Module
import dagger.Provides
import spark.ru.feature.api.FeatureInteractor
import spark.ru.feature.impl.FeatureInteractorImpl

/**
 * @author Sergey Chuprin
 */
@Module
class FeatureModule {

    @Provides
    fun provideFeatureInteractor(): FeatureInteractor {
        return FeatureInteractorImpl()
    }

}