package com.demo.core.impl.di

import android.content.Context
import com.demo.core.api.AppHolder
import com.demo.core.api.presentation.ResourcesManager
import com.demo.core.impl.ResourcesManagerImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Sergey Chuprin
 */
@Module
class AppUtilsModule {

    @Provides
    @Singleton
    fun provideApplicationContext(appHolder: AppHolder): Context {
        return appHolder.appContext
    }

    @Provides
    @Singleton
    fun provideResourcesManager(context: Context): ResourcesManager {
        return ResourcesManagerImpl(context)
    }

}