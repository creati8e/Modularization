package com.demo.modularization.feature.impl.data

import com.demo.modularization.feature.impl.domain.AuthGateway
import demo.com.core.api.data.AuthDataSource
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