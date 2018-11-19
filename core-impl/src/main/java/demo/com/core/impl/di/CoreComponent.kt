package demo.com.core.impl.di

import dagger.Component
import demo.com.core.api.CoreApi

/**
 * @author Sergey Chuprin
 */
@Component(modules = [CoreModule::class])
abstract class CoreComponent : CoreApi {

    companion object {

        val instance: CoreComponent by lazy { DaggerCoreComponent.create() }

    }
}