package com.als.ciceronesubnavigationinfragment.helpers

import androidx.fragment.app.FragmentTransaction
import com.als.ciceronesubnavigationinfragment.R
/**
 * Helper возвращающий fragmentTransaction с установленными кастомными анимациями(RU)
 * Helper returning fragmentTransaction installed custom animations(EN)
 *
 * @author ALS
 */
class AnimatorHelper {
    fun fromRight(fragmentTransaction: FragmentTransaction) : FragmentTransaction {
        fragmentTransaction!!
            .setCustomAnimations(
                R.animator.slide_in_right,
                R.animator.slide_out_left,
                R.animator.slide_in_left,
                R.animator.slide_out_right)
        return fragmentTransaction
    }

    fun fromLeft(fragmentTransaction: FragmentTransaction) : FragmentTransaction {
        fragmentTransaction
            .setCustomAnimations(
                R.animator.slide_in_left,
                R.animator.slide_out_right,
                R.animator.slide_in_right,
                R.animator.slide_out_left)
        return fragmentTransaction
    }

    fun fromBottom(fragmentTransaction: FragmentTransaction) : FragmentTransaction {
        fragmentTransaction
            .setCustomAnimations(
                R.animator.slide_in_bottom,
                R.animator.slide_out_top,
                R.animator.slide_in_top,
                R.animator.slide_out_bottom)
        return fragmentTransaction
    }


    fun fromTop(fragmentTransaction: FragmentTransaction) : FragmentTransaction {
        fragmentTransaction
            .setCustomAnimations(
                R.animator.slide_in_top,
                R.animator.slide_out_bottom,
                R.animator.slide_in_bottom,
                R.animator.slide_out_top)
        return fragmentTransaction
    }

    fun experiment(fragmentTransaction: FragmentTransaction) : FragmentTransaction {
        fragmentTransaction
            .setCustomAnimations(
                R.animator.flip_right_enter,
                R.animator.flip_right_exit,
                R.animator.flip_left_enter,
                R.animator.flip_left_exit)
        return fragmentTransaction
    }
}