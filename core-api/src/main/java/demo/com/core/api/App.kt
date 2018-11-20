package demo.com.core.api

import android.content.Context

/**
 * @author Sergey Chuprin
 */
interface App {

    fun applicationContext(): Context

    val applicationProvider: ApplicationProvider

}