package com.als.ciceronesubnavigationinfragment.helpers.navigation

import com.als.ciceronesubnavigationinfragment.ui.Base.TabFragment
import ru.terrakok.cicerone.BaseRouter

class SwitchRouter : BaseRouter() {
    fun switchFragment(fr: TabFragment) {
        executeCommands(SwitchNavigator.SwitchFragment(fr))
    }
}
