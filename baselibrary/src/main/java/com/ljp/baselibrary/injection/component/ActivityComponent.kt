package com.ljp.baselibrary.injection.component

import android.app.Activity
import com.ljp.baselibrary.injection.ActivityScope
import com.ljp.baselibrary.injection.module.ActivityModule
import com.ljp.baselibrary.injection.module.LifeCycleModule
import com.trello.rxlifecycle3.LifecycleProvider
import dagger.Component

@ActivityScope
@Component(modules = [ActivityModule::class,LifeCycleModule::class],dependencies = [AppComponent::class])
interface ActivityComponent {

    fun activity():Activity

    fun lifecycleProvider():LifecycleProvider<*>
}