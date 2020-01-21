package com.ljp.baselibrary.injection.module

import android.app.Activity
import com.ljp.baselibrary.injection.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity:Activity) {

    @Provides
    @ActivityScope
    fun providesActivity():Activity{
        return activity
    }

}