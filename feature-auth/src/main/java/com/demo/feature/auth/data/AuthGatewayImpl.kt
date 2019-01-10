package com.demo.feature.auth.data

import com.demo.core.api.data.AuthDataSource
import com.demo.feature.auth.domain.AuthGateway
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