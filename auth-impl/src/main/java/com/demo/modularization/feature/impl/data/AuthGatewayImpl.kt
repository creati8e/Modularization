package com.demo.modularization.feature.impl.data

import com.demo.modularization.feature.impl.domain.AuthGateway
import demo.com.core.api.AuthDataSource
import java.util.*
import java.util.concurrent.ThreadLocalRandom

/**
 * @author Sergey Chuprin
 */
class AuthGatewayImpl(
    private val authDataSource: AuthDataSource
) : AuthGateway {

    @Suppress("UNUSED_PARAMETER")
    override fun signIn(login: String, password: String): Boolean {
        if (ThreadLocalRandom.current().nextInt() % 2 == 0) {
            authDataSource.token = UUID.randomUUID().toString()
            return true
        }
        return false
    }

}