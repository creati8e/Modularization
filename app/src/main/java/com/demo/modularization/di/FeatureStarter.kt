package com.demo.modularization.di

import com.demo.modularization.feature.impl.di.AuthComponent
import com.demo.modularization.feature.impl.di.DaggerAuthComponent_AuthDependenciesComponent
import demo.com.core.impl.di.CoreComponent

/**
 * @author Sergey Chuprin
 */
object FeatureStarter {

    fun startAuth() {
        val authDependencies = DaggerAuthComponent_AuthDependenciesComponent
            .builder()
            .coreApi(CoreComponent.instance)
            .build()

        AuthComponent.initAndGet(authDependencies)
    }

}