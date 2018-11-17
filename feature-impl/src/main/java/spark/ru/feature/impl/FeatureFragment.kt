package spark.ru.feature.impl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import spark.ru.feature.api.FeatureInteractor
import spark.ru.feature.impl.di.FeatureComponent
import spark.ru.feature_impl.R
import javax.inject.Inject

/**
 * @author Sergey Chuprin
 */
class FeatureFragment : Fragment() {

    @Inject
    lateinit var interactor: FeatureInteractor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FeatureComponent.initAndGet().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_feature, container, false)
    }

    override fun onStart() {
        super.onStart()
        interactor.doSomething()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (activity?.isFinishing == true) {
            FeatureComponent.reset()
        }
    }

}