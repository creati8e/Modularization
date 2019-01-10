package com.demo.core.api.ui

import com.demo.core.api.ui.store.Outlasting

/**
 * @author Sergey Chuprin
 */
interface FeatureComponent<T> : Outlasting {

    fun inject(target: T)

}