package com.als.ciceronesubnavigationinfragment.ui

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.als.ciceronesubnavigationinfragment.App
import com.als.ciceronesubnavigationinfragment.R
import com.als.ciceronesubnavigationinfragment.helpers.navigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class SplashFragment: Fragment() {
    @Inject
    lateinit var router: Router

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_splash, container, false)
        App.appComponent.inject(this)
        if (savedInstanceState == null) {
        }
        return view
    }

    private fun showMain(){
        Handler().postDelayed(Runnable {
            router.newRootScreen(Screens.MainCreen())
        }, 3 * 1000)

    }
}