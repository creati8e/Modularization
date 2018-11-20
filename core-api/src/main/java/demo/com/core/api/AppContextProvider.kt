package demo.com.core.api

import android.content.Context

/**
 * @author Sergey Chuprin
 */
interface AppContextProvider {

    fun applicationContext(): Context

}