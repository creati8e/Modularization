package com.demo.core.api.di.provider

import android.content.Context
import com.demo.core.api.presentation.ResourcesManager

/**
 * @author Sergey Chuprin
 */
interface AppUtilsProvider {

    val appContext: Context

    val resourcesManager: ResourcesManager

}