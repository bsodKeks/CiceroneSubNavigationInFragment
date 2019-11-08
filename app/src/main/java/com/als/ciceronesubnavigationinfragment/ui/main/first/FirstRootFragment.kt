package com.als.ciceronesubnavigationinfragment.ui.main.first

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.als.ciceronesubnavigationinfragment.App
import com.als.ciceronesubnavigationinfragment.R
import com.als.ciceronesubnavigationinfragment.helpers.AnimatorHelper
import com.als.ciceronesubnavigationinfragment.helpers.ScreensKeys
import com.als.ciceronesubnavigationinfragment.helpers.navigation.Screens
import com.als.ciceronesubnavigationinfragment.ui.Base.TabFragment
import com.als.ciceronesubnavigationinfragment.ui.SplashFragment
import com.als.ciceronesubnavigationinfragment.ui.main.MainFlowFragment
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Back
import ru.terrakok.cicerone.commands.Command
import javax.inject.Inject
import javax.inject.Named

class FirstRootFragment: TabFragment(ScreensKeys.FIRST_ROOT) {
    @field:[Inject Named(ScreensKeys.FIRST_ROOT)]
    lateinit var cicerone: Cicerone<Router>

    @Inject
    lateinit var animator: AnimatorHelper

    var navigator: SupportAppNavigator? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_container, container, false)
        App.appComponent.inject(this)
        navigator = object : SupportAppNavigator(activity, childFragmentManager, R.id.container_root){
            override fun setupFragmentTransaction(
                command: Command?,
                currentFragment: Fragment?,
                nextFragment: Fragment?,
                fragmentTransaction: FragmentTransaction?
            ) {
                var resultTransaction = fragmentTransaction
                //обработчик кастомных анимаций перехода
                if (!(command is Back)){
                    if (currentFragment is FirstRedFragment && nextFragment is FirstBlueFragment){
                        resultTransaction = animator.fromBottom(resultTransaction!!)
                    }
                    if (currentFragment is FirstBlueFragment && nextFragment is FirstWhiteFragment){
                        resultTransaction = animator.fromTop(resultTransaction!!)
                    }

                }

                super.setupFragmentTransaction(
                    command,
                    currentFragment,
                    nextFragment,
                    resultTransaction
                )
            }
        }
        if (savedInstanceState == null) {
            cicerone.router.newRootScreen(Screens.FirstRedScreen())
        }
        return root
    }

    override fun onResume() {
        super.onResume()
        cicerone.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        cicerone.navigatorHolder.removeNavigator()
        super.onPause()
    }
}