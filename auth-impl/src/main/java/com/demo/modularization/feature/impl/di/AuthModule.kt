package com.demo.modularization.feature.impl.di

import com.demo.modularization.feature.impl.data.AuthGatewayImpl
import com.demo.modularization.feature.impl.domain.AuthGateway
import dagger.Module
import dagger.Provides
import demo.com.core.api.AuthDataSource

/**
 * @author Sergey Chuprin
 */
@Module
class AuthModule {

    @Provides
    fun provideAuthGatewayImpl(authDataSource: AuthDataSource): AuthGateway {
        return AuthGatewayImpl(authDataSource)
    }

}