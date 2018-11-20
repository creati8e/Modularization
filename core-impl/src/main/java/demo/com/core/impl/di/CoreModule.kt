package demo.com.core.impl.di

import dagger.Module
import dagger.Provides
import demo.com.core.api.data.AuthDataSource
import demo.com.core.impl.AuthDataSourceImpl
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