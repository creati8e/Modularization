package demo.com.core.impl.di

import android.content.Context
import dagger.Module
import dagger.Provides
import demo.com.core.api.App
import javax.inject.Singleton

/**
 * @author Sergey Chuprin
 */
@Module
class AppContextModule {

    @Provides
    @Singleton
    fun provideApplicationContext(app: App): Context {
        return app.applicationContext()
    }

}