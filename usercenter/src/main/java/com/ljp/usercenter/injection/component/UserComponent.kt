package com.ljp.usercenter.injection.component

import com.ljp.baselibrary.injection.PerComponentScope
import com.ljp.baselibrary.injection.component.ActivityComponent
import com.ljp.usercenter.injection.module.UserModule
import com.ljp.usercenter.ui.activity.RegisterActivity
import dagger.Component

@PerComponentScope
@Component(modules = [UserModule::class],dependencies = [ActivityComponent::class])
interface UserComponent {

    fun inject(activity: RegisterActivity)
}