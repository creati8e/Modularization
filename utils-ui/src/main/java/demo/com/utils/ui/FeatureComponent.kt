package demo.com.utils.ui

import demo.com.utils.store.Outlasting

/**
 * @author Sergey Chuprin
 */
interface FeatureComponent<T> : Outlasting {

    fun inject(target: T)

}