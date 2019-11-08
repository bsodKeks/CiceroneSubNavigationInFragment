package com.als.ciceronesubnavigationinfragment.helpers.navigation

import androidx.fragment.app.Fragment
import com.als.ciceronesubnavigationinfragment.helpers.ScreensKeys
import com.als.ciceronesubnavigationinfragment.ui.SplashFragment
import com.als.ciceronesubnavigationinfragment.ui.main.MainFlowFragment
import com.als.ciceronesubnavigationinfragment.ui.main.first.FirstBlueFragment
import com.als.ciceronesubnavigationinfragment.ui.main.first.FirstRedFragment
import com.als.ciceronesubnavigationinfragment.ui.main.first.FirstRootFragment
import com.als.ciceronesubnavigationinfragment.ui.main.first.FirstWhiteFragment
import com.als.ciceronesubnavigationinfragment.ui.main.second.SecondBlackFragment
import com.als.ciceronesubnavigationinfragment.ui.main.second.SecondRedFragment
import com.als.ciceronesubnavigationinfragment.ui.main.second.SecondRootFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens{
    class SplashScreen() : SupportAppScreen(){
        override fun getFragment(): Fragment {
            this.screenKey = ScreensKeys.SPLASH
            return SplashFragment()
        }
    }

    class MainFlowScreen() : SupportAppScreen(){
        override fun getFragment(): Fragment {
            this.screenKey = ScreensKeys.MAIN_FLOW
            return MainFlowFragment()
        }
    }

    class FirstRootScreen() : SupportAppScreen(){
        override fun getFragment(): Fragment {
            this.screenKey = ScreensKeys.FIRST_ROOT
            return FirstRootFragment()
        }
    }

    class SecondRootScreen() : SupportAppScreen(){
        override fun getFragment(): Fragment {
            this.screenKey = ScreensKeys.SECOND_ROOT
            return SecondRootFragment()
        }
    }

    class FirstRedScreen() : SupportAppScreen(){
        override fun getFragment(): Fragment {
            this.screenKey = ScreensKeys.FIRST_RED
            return FirstRedFragment()
        }
    }

    class FirstBlueScreen() : SupportAppScreen(){
        override fun getFragment(): Fragment {
            this.screenKey = ScreensKeys.FIRST_BLUE
            return FirstBlueFragment()
        }
    }

    class FirstWhiteScreen() : SupportAppScreen(){
        override fun getFragment(): Fragment {
            this.screenKey = ScreensKeys.FIRST_WHITE
            return FirstWhiteFragment()
        }
    }

    class SecondRedScreen() : SupportAppScreen(){
        override fun getFragment(): Fragment {
            this.screenKey = ScreensKeys.SECOND_RED
            return SecondRedFragment()
        }
    }

    class SecondBlackScreen() : SupportAppScreen(){
        override fun getFragment(): Fragment {
            this.screenKey = ScreensKeys.SECOND_RED
            return SecondBlackFragment()
        }
    }
}