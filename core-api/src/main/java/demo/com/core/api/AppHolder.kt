package demo.com.core.api

import android.content.Context
import demo.com.core.api.di.provider.ApplicationProvider

/**
 * @author Sergey Chuprin
 */
interface AppHolder {

    val appContext: Context

    val appProvider: ApplicationProvider

}