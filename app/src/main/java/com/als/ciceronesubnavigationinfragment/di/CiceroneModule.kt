package com.als.ciceronesubnavigationinfragment.di

import com.als.ciceronesubnavigationinfragment.App
import com.als.ciceronesubnavigationinfragment.helpers.ScreensKeys
import com.als.ciceronesubnavigationinfragment.helpers.navigation.SwitchRouter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import javax.inject.Named
import javax.inject.Singleton

@Module
class CiceroneModule {

    @Provides
    @Singleton
    fun provideRouter(): Router {
        return App.cicerone.router
    }

    @Provides
    @Singleton
    @Named(ScreensKeys.FIRST)
    fun provideCiceroneFirst(): Cicerone<Router> {
        return Cicerone.create()
    }

    @Provides
    @Singleton
    @Named(ScreensKeys.SECOND)
    fun provideCiceroneSecond():  Cicerone<Router> {
        return Cicerone.create()
    }

    @Provides
    @Singleton
    fun provideCiceroneSwitch(): Cicerone<SwitchRouter> {
        return Cicerone.create(SwitchRouter())
    }
}