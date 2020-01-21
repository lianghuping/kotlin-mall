package com.ljp.baselibrary.injection.component

import android.content.Context
import com.ljp.baselibrary.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun context():Context

}