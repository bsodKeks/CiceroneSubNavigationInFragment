package com.als.ciceronesubnavigationinfragment.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.als.ciceronesubnavigationinfragment.App
import com.als.ciceronesubnavigationinfragment.R
import com.als.ciceronesubnavigationinfragment.helpers.ScreensKeys
import com.als.ciceronesubnavigationinfragment.helpers.navigation.SwitchNavigator
import com.als.ciceronesubnavigationinfragment.helpers.navigation.SwitchRouter
import com.als.ciceronesubnavigationinfragment.ui.main.first.FirstRootFragment
import com.als.ciceronesubnavigationinfragment.ui.main.second.SecondRootFragment
import kotlinx.android.synthetic.main.fragment_main_flow.view.*
import ru.terrakok.cicerone.Cicerone
import javax.inject.Inject

/**
 * главный фрагмент приложения с bottomNavigationView(RU)
 * main application fragment with bottomNavigationView(EN)
 *
 * @author ALS
 */
class MainFlowFragment: Fragment() {
    private val firstRootFragment: FirstRootFragment by lazy{
        childFragmentManager!!.findFragmentByTag(ScreensKeys.FIRST_ROOT) as? FirstRootFragment ?: FirstRootFragment()
    }

    private val secondRootFragment: SecondRootFragment by lazy{
        childFragmentManager!!.findFragmentByTag(ScreensKeys.SECOND_ROOT) as? SecondRootFragment ?: SecondRootFragment()
    }

    @Inject
    lateinit var localCicerone : Cicerone<SwitchRouter>
    lateinit var router: SwitchRouter
    var navigator: SwitchNavigator? = null

    private var currentItem = -1
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_main_flow, container, false)
        App.appComponent.inject(this)
        router = localCicerone.router
        navigator = SwitchNavigator(activity!!, childFragmentManager!!, R.id.fr_container)
        if (savedInstanceState == null) {
            router.switchFragment(firstRootFragment)
        }
        initViews(view)

        return view
    }

    private fun initViews(view: View){
        view.nbMain.setOnNavigationItemSelectedListener{ item ->
            val id = item.itemId
            if (id == currentItem) {
                return@setOnNavigationItemSelectedListener false
            }
            currentItem = item.itemId
            when (item.itemId) {
                R.id.bnv_firt -> {
                    router.switchFragment(firstRootFragment)
                }
                R.id.bnv_sec -> {
                    router.switchFragment(secondRootFragment)
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    override fun onResume() {
        super.onResume()
        localCicerone.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        localCicerone.navigatorHolder.removeNavigator()
        super.onPause()
    }

}