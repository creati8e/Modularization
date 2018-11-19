package demo.com.core.impl.di

import dagger.Module
import dagger.Provides
import demo.com.core.api.AuthDataSource
import demo.com.core.impl.AuthDataSourceImpl

/**
 * @author Sergey Chuprin
 */
@Module
class CoreModule {

    @Provides
    fun provideAuthDataSource(): AuthDataSource {
        return AuthDataSourceImpl()
    }

}