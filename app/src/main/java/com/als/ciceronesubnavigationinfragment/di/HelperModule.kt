package com.als.ciceronesubnavigationinfragment.di

import com.als.ciceronesubnavigationinfragment.helpers.AnimatorHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * модуль предоставления Helper-ов(RU)
 * module provides Helpers (EN)
 *
 * @author ALS
 */
@Module
class HelperModule {
    @Provides
    @Singleton
    fun provideAnimator(): AnimatorHelper {
        return AnimatorHelper()
    }
}