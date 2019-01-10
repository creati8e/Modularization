package com.demo.feature.auth.di

import com.demo.core.api.data.AuthDataSource
import com.demo.core.api.di.scope.PerFeature
import com.demo.feature.auth.data.AuthGatewayImpl
import com.demo.feature.auth.domain.AuthGateway
import dagger.Module
import dagger.Provides

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