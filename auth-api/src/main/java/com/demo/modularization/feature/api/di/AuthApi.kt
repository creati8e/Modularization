package com.demo.modularization.feature.api.di

import com.demo.modularization.feature.api.AuthInteractor

/**
 * @author Sergey Chuprin
 */
interface AuthApi {

    val authInteractor: AuthInteractor

}