package demo.com.dashboard.impl.di

import dagger.Component
import demo.com.core.api.di.provider.AppUtilsProvider
import demo.com.dashboard.impl.presentation.DashboardFragment

/**
 * @author Sergey Chuprin
 */
@Component(
    modules = [DashboardModule::class],
    dependencies = [AppUtilsProvider::class]
)
interface DashboardComponent {

    fun inject(fragment: DashboardFragment)

}