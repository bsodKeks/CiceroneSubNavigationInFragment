package com.als.ciceronesubnavigationinfragment.di

import com.als.ciceronesubnavigationinfragment.App
import com.als.ciceronesubnavigationinfragment.ui.MainActivity
import com.als.ciceronesubnavigationinfragment.ui.SplashFragment
import com.als.ciceronesubnavigationinfragment.ui.main.MainFlowFragment
import com.als.ciceronesubnavigationinfragment.ui.main.first.FirstBlueFragment
import com.als.ciceronesubnavigationinfragment.ui.main.first.FirstRedFragment
import com.als.ciceronesubnavigationinfragment.ui.main.first.FirstRootFragment
import com.als.ciceronesubnavigationinfragment.ui.main.first.FirstWhiteFragment
import com.als.ciceronesubnavigationinfragment.ui.main.second.SecondBlackFragment
import com.als.ciceronesubnavigationinfragment.ui.main.second.SecondRedFragment
import com.als.ciceronesubnavigationinfragment.ui.main.second.SecondRootFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(CiceroneModule::class, HelperModule::class)
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        fun ciceroneModule(ciceroneModule: CiceroneModule): Builder
        fun helperModule(helperModule: HelperModule): Builder
    }

    fun inject(app: App)
    fun inject(app: MainActivity)
    fun inject(splashFragment: SplashFragment)
    fun inject(mainFlowFragment: MainFlowFragment)
    fun inject(firstRedFragment: FirstRedFragment)
    fun inject(firstBlueFragment: FirstBlueFragment)
    fun inject(firstRootFragment: FirstRootFragment)
    fun inject(firstWhiteFragment: FirstWhiteFragment)
    fun inject(secondRootFragment: SecondRootFragment)
    fun inject(secondRedFragment: SecondRedFragment)
    fun inject(secondBlackFragment: SecondBlackFragment)
}