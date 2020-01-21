package com.ljp.baselibrary.application

import android.app.Application
import com.ljp.baselibrary.injection.component.AppComponent
import com.ljp.baselibrary.injection.component.DaggerAppComponent
import com.ljp.baselibrary.injection.module.AppModule

class BaseApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initInjection()
    }

    private fun initInjection(){
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}