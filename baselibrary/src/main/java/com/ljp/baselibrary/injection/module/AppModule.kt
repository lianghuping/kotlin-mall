package com.ljp.baselibrary.injection.module

import android.content.Context
import com.ljp.baselibrary.application.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context:BaseApplication){


    @Singleton
    @Provides
    fun providesBaseApplication():Context{
        return context
    }
}