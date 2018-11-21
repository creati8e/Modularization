package com.demo.core.impl.di

import com.demo.core.api.data.AuthDataSource
import com.demo.core.impl.AuthDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Sergey Chuprin
 */
@Module
class CoreModule {

    @Provides
    @Singleton
    fun provideAuthDataSource(): AuthDataSource {
        return AuthDataSourceImpl()
    }

}