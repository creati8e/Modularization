package com.demo.core.impl

import android.content.Context
import androidx.annotation.ArrayRes
import com.demo.core.api.presentation.ResourcesManager

/**
 * @author Sergey Chuprin
 */
class ResourcesManagerImpl(
    private val context: Context
) : ResourcesManager {

    override fun getStringArray(@ArrayRes stringRes: Int): Array<String> {
        return context.resources.getStringArray(stringRes)
    }

}