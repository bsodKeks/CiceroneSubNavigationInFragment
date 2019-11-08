package com.als.ciceronesubnavigationinfragment.helpers.navigation

import androidx.fragment.app.Fragment
import com.als.ciceronesubnavigationinfragment.helpers.ScreensKeys
import com.als.ciceronesubnavigationinfragment.ui.SplashFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens{
    /** Сплэш экран*/
    class SplashScreen() : SupportAppScreen(){
        override fun getFragment(): Fragment {
            this.screenKey = ScreensKeys.SPLASH
            return SplashFragment()
        }
    }
}