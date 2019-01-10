package com.demo.injector.settings

import com.demo.core.api.di.tools.AppTools
import dagger.Component

/**
 * @author Sergey Chuprin
 */
@Component(dependencies = [AppTools::class])
internal interface SettingDependenciesComponent : SettingsDependencies