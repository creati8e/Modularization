package spark.ru.feature.impl

import android.util.Log
import spark.ru.feature.api.FeatureInteractor

/**
 * @author Sergey Chuprin
 */
class FeatureInteractorImpl : FeatureInteractor {

    override fun doSomething() {
        Log.w("FeatureInteractor", "doSomething method called")
    }

}