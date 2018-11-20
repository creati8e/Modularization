package demo.com.core.api.di.provider

import android.content.Context
import demo.com.core.api.presentation.ResourcesManager

/**
 * @author Sergey Chuprin
 */
interface AppUtilsProvider {

    val appContext: Context

    val resourcesManager: ResourcesManager

}