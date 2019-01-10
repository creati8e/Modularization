package com.demo.core.api.viewmodel

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

/**
 * @author Sergey Chuprin
 */
inline fun <reified T : ViewModel> Fragment.buildViewModel(noinline creator: (() -> T)): T {
    return ViewModelProviders.of(this, BaseViewModelFactory(creator)).get(T::class.java)
}

inline fun <reified T : ViewModel> Fragment.buildViewModelWithFactory(
    factory: BaseViewModelFactory<T>
): T {
    return ViewModelProviders.of(this, factory).get(T::class.java)
}