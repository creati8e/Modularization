package com.demo.core.api.viewmodel

import androidx.fragment.app.Fragment
import kotlin.reflect.KProperty

/**
 * @author Sergey Chuprin
 */
fun <T> componentViewModel(creator: () -> T) = ComponentViewModelDelegate(creator)

class ComponentViewModelDelegate<T>(private val creator: () -> T) {

    private val factory = BaseViewModelFactory { ComponentViewModel(creator()) }

    @Suppress("UNCHECKED_CAST")
    operator fun getValue(thisRef: Fragment, property: KProperty<*>): ComponentViewModel<T> {
        return thisRef.buildViewModelWithFactory(factory)
    }

}