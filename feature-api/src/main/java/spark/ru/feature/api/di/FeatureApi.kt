package spark.ru.feature.api.di

import spark.ru.feature.api.FeatureInteractor

/**
 * @author Sergey Chuprin
 */
interface FeatureApi {

    val featureInteractor: FeatureInteractor

}