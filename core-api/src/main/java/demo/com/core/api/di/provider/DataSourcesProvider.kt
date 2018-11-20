package demo.com.core.api.di.provider

import demo.com.core.api.data.AuthDataSource

/**
 * @author Sergey Chuprin
 */
interface DataSourcesProvider {

    val authDataSource: AuthDataSource

}