package com.demo.app.di

import com.demo.app.MainFragment
import com.demo.core.api.di.tools.AppTools
import com.demo.core.api.di.tools.NavigationTools
import dagger.Component
import javax.inject.Singleton

/**
 * @author Sergey Chuprin
 */
@Singleton
@Component(
    dependencies = [
        AppTools::class,
        NavigationTools::class
    ]
)
interface AppComponent {

    fun inject(mainFragment: MainFragment)

}