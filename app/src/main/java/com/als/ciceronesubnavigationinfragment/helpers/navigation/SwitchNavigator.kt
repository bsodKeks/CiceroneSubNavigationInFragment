package com.als.ciceronesubnavigationinfragment.helpers.navigation

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.als.ciceronesubnavigationinfragment.ui.Base.TabFragment
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.commands.Back
import ru.terrakok.cicerone.commands.Command
/**
 * Кастомный навигатор Cicerone, для переключения фрагментов BottomNavigationView(RU)
 * Custom Cicerone navigator, for switch fragments BottomNavigationView(EN)
 *
 * @author ALS
 */
class SwitchNavigator(
    private val activity: FragmentActivity,
    private val fragmentManager: FragmentManager,
    private val containerId: Int
) : Navigator {
    override fun applyCommands(commands: Array<out Command>) {
        for (command in commands) applyCommand(command)
    }

    private fun applyCommand(command: Command) {
        when (command) {
            is Back -> activity.finish()
            is SwitchFragment -> changeTab(command.fr)
        }
    }

    //we could also use attach() and detach() instead of show() and hide().
    private fun changeTab(targetFragment: TabFragment) {
        with(fragmentManager.beginTransaction()) {
            fragmentManager.fragments.filter{ it != targetFragment }.forEach {
                hide(it)
            }

            targetFragment.let {

                if (it.isAdded) {
                    show(it)
                } else {
                    add(containerId, it, it.tagd)
                }
            }
            commit()
        }
    }

    class SwitchFragment(val fr: TabFragment) : Command
}