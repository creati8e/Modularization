package demo.com.core.api

/**
 * @author Sergey Chuprin
 */
interface DataSourcesProvider {

    fun getAuthDataSource(): AuthDataSource

}