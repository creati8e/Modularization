package com.demo.feature.auth.domain

/**
 * @author Sergey Chuprin
 */
interface AuthGateway {

    fun signIn(login: String, password: String)

}