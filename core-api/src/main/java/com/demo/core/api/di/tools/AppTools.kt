package com.demo.core.api.di.tools

import android.content.Context
import com.demo.core.api.presentation.ResourcesManager

/**
 * @author Sergey Chuprin
 */
interface AppTools {

    val appContext: Context

    val resourcesManager: ResourcesManager

}