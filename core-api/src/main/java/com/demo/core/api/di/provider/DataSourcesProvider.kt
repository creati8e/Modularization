package com.demo.core.api.di.provider

import com.demo.core.api.data.AuthDataSource

/**
 * @author Sergey Chuprin
 */
interface DataSourcesProvider {

    val authDataSource: AuthDataSource

}