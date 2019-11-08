package com.als.ciceronesubnavigationinfragment

import android.app.Application
import com.als.ciceronesubnavigationinfragment.di.AppComponent
import com.als.ciceronesubnavigationinfragment.di.CiceroneModule
import com.als.ciceronesubnavigationinfragment.di.DaggerAppComponent
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

/**
 * Класс приложения
 *
 * @author ALS
 */

class App: Application() {

    companion object {
        lateinit var instance: App
        lateinit var appComponent: AppComponent
        lateinit var cicerone: Cicerone<Router>
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initDagger()
        cicerone = Cicerone.create()
    }

    fun initDagger() {
        appComponent = DaggerAppComponent.builder()
            .ciceroneModule(CiceroneModule())
            .build()
        appComponent.inject(this)
    }
}