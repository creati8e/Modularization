package com.demo.core.ui

import com.demo.core.ui.store.Outlasting

/**
 * @author Sergey Chuprin
 */
interface FeatureComponent<T> : Outlasting {

    fun inject(target: T)

}