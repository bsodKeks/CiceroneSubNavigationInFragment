package com.als.ciceronesubnavigationinfragment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.als.ciceronesubnavigationinfragment.App
import com.als.ciceronesubnavigationinfragment.R
import com.als.ciceronesubnavigationinfragment.helpers.AnimatorHelper
import com.als.ciceronesubnavigationinfragment.helpers.navigation.Screens
import com.als.ciceronesubnavigationinfragment.ui.Base.BackButtonListener
import com.als.ciceronesubnavigationinfragment.ui.main.MainFlowFragment
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Back
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Replace
import javax.inject.Inject

/**
 * Главная активити приложения(RU)
 * Main activity application(EN)
 *
 * @author ALS
 */
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var animator: AnimatorHelper

    var navigator: Navigator = object : SupportAppNavigator(this, R.id.container){
        override fun setupFragmentTransaction(
            command: Command?,
            currentFragment: Fragment?,
            nextFragment: Fragment?,
            fragmentTransaction: FragmentTransaction?
        ) {
            var resultTransaction = fragmentTransaction
            //обработчик кастомных анимаций перехода
            if (!(command is Back)){
                if (currentFragment is SplashFragment && nextFragment is MainFlowFragment){
                    resultTransaction = animator.fromLeft(resultTransaction!!)
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.appComponent.inject(this)
        if (savedInstanceState == null)
            navigator.applyCommands(arrayOf<Command>(Replace(Screens.SplashScreen())))
    }

    override fun onResume() {
        super.onResume()
        App.cicerone.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.cicerone.navigatorHolder.removeNavigator()
    }

    /**
     * Переопределяем метод, для перехвата нажатия на backButton(RU)
     * override method for interception backButton press(EN)
     *
     */
    override fun onBackPressed() {
        supportFragmentManager.fragments.filter{ it.isVisible }.forEach {
            //Смотрим, если в текущем фрагменте переопределен BackButtonListener, то выполняем его
            if (it.childFragmentManager.fragments.isNotEmpty()){
                for (fragment in it.childFragmentManager.fragments){
                    if (fragment.isVisible){
                        if (fragment is BackButtonListener)
                            (fragment as BackButtonListener).onBackPressed()
                        else
                            super.onBackPressed()
                    }
                }
            }
            else{
                super.onBackPressed()
            }

        }
    }
}
