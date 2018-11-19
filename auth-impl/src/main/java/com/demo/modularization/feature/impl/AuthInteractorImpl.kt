package com.demo.modularization.feature.impl

import android.util.Log
import com.demo.modularization.feature.api.AuthInteractor

/**
 * @author Sergey Chuprin
 */
class AuthInteractorImpl : AuthInteractor {

    override fun doSomething() {
        Log.w("AuthInteractor", "doSomething method called")
    }

}