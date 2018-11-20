package demo.com.core.impl.di

import android.content.Context
import dagger.Module
import dagger.Provides
import demo.com.core.api.App
import demo.com.core.api.presentation.ResourcesManager
import demo.com.core.impl.ResourcesManagerImpl
import javax.inject.Singleton

/**
 * @author Sergey Chuprin
 */
@Module
class AppUtilsModule {

    @Provides
    @Singleton
    fun provideApplicationContext(app: App): Context {
        return app.appContext
    }

    @Provides
    @Singleton
    fun provideResourcesManager(context: Context): ResourcesManager {
        return ResourcesManagerImpl(context)
    }

}