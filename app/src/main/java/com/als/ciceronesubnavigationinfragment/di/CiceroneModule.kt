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
/**
 * модуль предоставления объектов Cicerone(RU)
 * module provides Cicerone objects(EN)
 *
 * @author ALS
 */
@Module
class CiceroneModule {

    /**
     * Предоставляет объект Cicerone для навигации внутри MainActiviry(RU)
     * Provides Cicerone object to navigation in MainActiviry(EN)
     */
    @Provides
    @Singleton
    fun provideRouter(): Router {
        return App.cicerone.router
    }

    /**
     * Предоставляет объект Cicerone для навигации внутри первой вкладки BottomNavigationView(в MainFlowFragment)(RU)
     * Provides Cicerone object to navigation in first tab BottomNavigationView(on MainFlowFragment)(EN)
     */
    @Provides
    @Singleton
    @Named(ScreensKeys.FIRST_ROOT)
    fun provideCiceroneFirst(): Cicerone<Router> {
        return Cicerone.create()
    }

    /**
     * Предоставляет объект Cicerone для навигации внутри второй вкладки BottomNavigationView(в MainFlowFragment)(RU)
     * Provides Cicerone object to navigation in second tab BottomNavigationView(on MainFlowFragment)(EN)
     */
    @Provides
    @Singleton
    @Named(ScreensKeys.SECOND_ROOT)
    fun provideCiceroneSecond():  Cicerone<Router> {
        return Cicerone.create()
    }

    /**
     * Предоставляет объект Cicerone для навигации смены вкладок BottomNavigationView(RU)
     * Provides Cicerone object to navigation changes tab BottomNavigationView(EN)
     */
    @Provides
    @Singleton
    fun provideCiceroneSwitch(): Cicerone<SwitchRouter> {
        return Cicerone.create(SwitchRouter())
    }
}