package com.als.ciceronesubnavigationinfragment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.als.ciceronesubnavigationinfragment.App
import com.als.ciceronesubnavigationinfragment.R
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Back
import ru.terrakok.cicerone.commands.Command
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var router: Router

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
    }
}
