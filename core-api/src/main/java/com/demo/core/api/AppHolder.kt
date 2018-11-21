package com.demo.core.api

import android.content.Context
import com.demo.core.api.di.provider.ApplicationProvider

/**
 * @author Sergey Chuprin
 */
interface AppHolder {

    val appContext: Context

    val appProvider: ApplicationProvider

}