package com.demo.modularization.feature.impl.domain

/**
 * @author Sergey Chuprin
 */
interface AuthGateway {

    fun signIn(login: String, password: String)

}