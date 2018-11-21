package com.demo.auth.data

import com.demo.auth.domain.AuthGateway
import com.demo.core.api.data.AuthDataSource
import java.util.*

/**
 * @author Sergey Chuprin
 */
class AuthGatewayImpl(
    private val authDataSource: AuthDataSource
) : AuthGateway {

    @Suppress("UNUSED_PARAMETER")
    override fun signIn(login: String, password: String) {
        authDataSource.token = UUID.randomUUID().toString()
    }

}