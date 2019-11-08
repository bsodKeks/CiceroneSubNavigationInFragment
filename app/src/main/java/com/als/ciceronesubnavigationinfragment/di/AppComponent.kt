package com.als.ciceronesubnavigationinfragment.di

import com.als.ciceronesubnavigationinfragment.App
import com.als.ciceronesubnavigationinfragment.ui.MainActivity
import com.als.ciceronesubnavigationinfragment.ui.SplashFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(CiceroneModule::class)
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        fun ciceroneModule(ciceroneModule: CiceroneModule): Builder
    }

    fun inject(app: App)
    fun inject(app: MainActivity)
    fun inject(splashFragment: SplashFragment)
}