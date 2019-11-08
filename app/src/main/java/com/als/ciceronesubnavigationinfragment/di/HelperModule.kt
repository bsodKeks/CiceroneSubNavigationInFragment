package com.als.ciceronesubnavigationinfragment.di

import com.als.ciceronesubnavigationinfragment.App
import com.als.ciceronesubnavigationinfragment.helpers.AnimatorHelper
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
class HelperModule {
    @Provides
    @Singleton
    fun provideAnimator(): AnimatorHelper {
        return AnimatorHelper()
    }
}