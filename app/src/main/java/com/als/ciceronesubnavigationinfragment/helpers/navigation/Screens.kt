package com.als.ciceronesubnavigationinfragment.helpers.navigation

import androidx.fragment.app.Fragment
import com.als.ciceronesubnavigationinfragment.helpers.ScreensKeys
import com.als.ciceronesubnavigationinfragment.ui.SplashFragment
import com.als.ciceronesubnavigationinfragment.ui.main.MainFrowFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens{
    class SplashScreen() : SupportAppScreen(){
        override fun getFragment(): Fragment {
            this.screenKey = ScreensKeys.SPLASH
            return SplashFragment()
        }
    }

    class MainCreen() : SupportAppScreen(){
        override fun getFragment(): Fragment {
            this.screenKey = ScreensKeys.MAIN_FLOW
            return MainFrowFragment()
        }
    }
}