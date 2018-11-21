package com.demo.auth.di

import com.demo.auth.data.AuthGatewayImpl
import com.demo.auth.domain.AuthGateway
import com.demo.core.api.data.AuthDataSource
import com.demo.core.api.di.scope.PerFeature
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