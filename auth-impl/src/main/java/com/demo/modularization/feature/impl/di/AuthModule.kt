package com.demo.modularization.feature.impl.di

import com.demo.modularization.feature.impl.data.AuthGatewayImpl
import com.demo.modularization.feature.impl.domain.AuthGateway
import dagger.Module
import dagger.Provides
import demo.com.core.api.data.AuthDataSource
import demo.com.core.api.di.scope.PerFeature

/**
 * @author Sergey Chuprin
 */
@Module
class AuthModule {

    @Provides
    @PerFeature
    fun provideAuthGatewayImpl(authDataSource: AuthDataSource): AuthGateway {
        return AuthGatewayImpl(authDataSource)
    }

}