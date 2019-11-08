package com.als.ciceronesubnavigationinfragment.ui.main.first

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.als.ciceronesubnavigationinfragment.R
import com.als.ciceronesubnavigationinfragment.helpers.ScreensKeys
import com.als.ciceronesubnavigationinfragment.ui.Base.TabFragment
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class FirstRootFragment: TabFragment(ScreensKeys.FIRST_ROOT) {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_container, container, false)
        root.setBackgroundColor(Color.GREEN)
        return root
    }
}