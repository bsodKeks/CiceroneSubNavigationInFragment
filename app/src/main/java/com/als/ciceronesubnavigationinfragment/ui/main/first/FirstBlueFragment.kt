package com.als.ciceronesubnavigationinfragment.ui.main.first

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

/**
 * Простой фрагмент из первой цепочки экранов(RU)
 * simple fragment from first screen chain(EN)
 *
 * @author ALS
 */
class FirstBlueFragment: Fragment(), BackButtonListener {
    @field:[Inject Named(ScreensKeys.FIRST_ROOT)]
    lateinit var cicerone: Cicerone<Router>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_first_blue, container, false)
        App.appComponent.inject(this)
        initView(view)

        return view
    }
    /**
     * по нажатию на кнопку переходим на следующий экран(RU)
     * on button press go to next screen(EN)
     */
    private fun initView(view: View){
        view.buttonNext.setOnClickListener(View.OnClickListener {
            cicerone.router.navigateTo(Screens.FirstWhiteScreen())
        })
    }

    override fun onBackPressed(): Boolean {
        cicerone.router.exit()
        return true
    }
}