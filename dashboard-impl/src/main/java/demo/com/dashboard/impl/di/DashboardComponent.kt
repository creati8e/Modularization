package demo.com.dashboard.impl.di

import dagger.Component
import demo.com.core.api.di.provider.AppUtilsProvider
import demo.com.core.api.di.scope.PerFeature
import demo.com.dashboard.impl.presentation.DashboardFragment
import demo.com.navigation.NavigationProvider

/**
 * @author Sergey Chuprin
 */
@PerFeature
@Component(
    modules = [DashboardModule::class],
    dependencies = [AppUtilsProvider::class, NavigationProvider::class]
)
interface DashboardComponent {

    fun inject(fragment: DashboardFragment)

}