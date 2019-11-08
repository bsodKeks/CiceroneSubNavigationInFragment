package com.als.ciceronesubnavigationinfragment.ui.main.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.als.ciceronesubnavigationinfragment.App
import com.als.ciceronesubnavigationinfragment.R
import com.als.ciceronesubnavigationinfragment.helpers.ScreensKeys
import com.als.ciceronesubnavigationinfragment.helpers.navigation.Screens
import com.als.ciceronesubnavigationinfragment.ui.Base.BackButtonListener
import kotlinx.android.synthetic.main.fragment_first_red.view.*
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import javax.inject.Inject
import javax.inject.Named

class SecondBlackFragment: Fragment(), BackButtonListener {
    @field:[Inject Named(ScreensKeys.SECOND_ROOT)]
    lateinit var cicerone: Cicerone<Router>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_second_black, container, false)
        App.appComponent.inject(this)

        return view
    }

    override fun onBackPressed(): Boolean {
        cicerone.router.exit()
        return true
    }
}