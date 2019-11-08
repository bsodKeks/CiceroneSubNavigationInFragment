package com.als.ciceronesubnavigationinfragment.ui.Base

import androidx.fragment.app.Fragment
import com.als.ciceronesubnavigationinfragment.R

abstract class TabFragment(val tagd: String) : Fragment(), BackButtonListener {

    override fun onBackPressed(): Boolean {
        return if (isAdded) {
            val childFragment = childFragmentManager.findFragmentById(R.id.container_root)
            childFragment != null && childFragment is BackButtonListener && childFragment.onBackPressed()
        } else false
    }
}