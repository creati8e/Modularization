package com.demo.modularization.feature.impl.di

import com.demo.modularization.feature.api.AuthInteractor
import com.demo.modularization.feature.impl.AuthInteractorImpl
import dagger.Module
import dagger.Provides

/**
 * @author Sergey Chuprin
 */
@Module
class AuthModule {

    @Provides
    fun provideFeatureInteractor(): AuthInteractor {
        return AuthInteractorImpl()
    }

}