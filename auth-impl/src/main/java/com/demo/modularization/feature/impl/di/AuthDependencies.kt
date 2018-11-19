package com.demo.modularization.feature.impl.di

import demo.com.core.api.AuthDataSource

/**
 * @author Sergey Chuprin
 */
interface AuthDependencies {

    val authDataSource: AuthDataSource

}