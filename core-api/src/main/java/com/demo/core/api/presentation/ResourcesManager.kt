package com.demo.core.api.presentation

import androidx.annotation.ArrayRes

/**
 * @author Sergey Chuprin
 */
interface ResourcesManager {

    fun getStringArray(@ArrayRes stringRes: Int): Array<String>

}