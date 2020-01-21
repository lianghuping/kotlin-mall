package com.ljp.baselibrary.injection.module

import com.ljp.baselibrary.injection.ActivityScope
import com.ljp.baselibrary.injection.PerComponentScope
import com.trello.rxlifecycle3.LifecycleProvider
import dagger.Module
import dagger.Provides

@Module
class LifeCycleModule(private val lifecycleProvider: LifecycleProvider<*>) {

    @ActivityScope
    @Provides
    fun providesLifecycleProvider(): LifecycleProvider<*> {
        return lifecycleProvider
    }

}