package com.demo.core.api.viewmodel

import androidx.lifecycle.ViewModel

/**
 * @author Sergey Chuprin
 *
 * ViewModel which holds Dagger's component and let it survive across configuration changes.
 */
class ComponentViewModel<C>(val component: C) : ViewModel()