package com.demo.injector.auth

import com.demo.core.api.di.tools.DataSourcesTools
import com.demo.core.api.di.tools.NavigationTools
import dagger.Component

/**
 * @author Sergey Chuprin
 */
@Component(dependencies = [DataSourcesTools::class, NavigationTools::class])
internal interface AuthDependenciesComponent : AuthDependencies