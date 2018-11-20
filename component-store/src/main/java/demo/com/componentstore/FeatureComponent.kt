package demo.com.componentstore

/**
 * @author Sergey Chuprin
 */
interface FeatureComponent<T> : Outlasting {

    fun inject(target: T)

}