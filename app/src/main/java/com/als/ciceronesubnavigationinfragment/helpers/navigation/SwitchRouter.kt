package com.als.ciceronesubnavigationinfragment.helpers.navigation

import com.als.ciceronesubnavigationinfragment.ui.Base.TabFragment
import ru.terrakok.cicerone.BaseRouter
/**
 * Кастомный роутер Cicerone, для переключения фрагментов BottomNavigationView(RU)
 * Custom Cicerone router, for switch fragments BottomNavigationView(EN)
 *
 * @author ALS
 */
class SwitchRouter : BaseRouter() {
    fun switchFragment(fr: TabFragment) {
        executeCommands(SwitchNavigator.SwitchFragment(fr))
    }
}
