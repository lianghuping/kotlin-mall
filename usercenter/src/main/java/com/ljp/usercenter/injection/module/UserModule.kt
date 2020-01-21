package com.ljp.usercenter.injection.module

import com.ljp.usercenter.service.IRegisterService
import com.ljp.usercenter.service.impl.RegisterService
import dagger.Module
import dagger.Provides

@Module
class UserModule {

    @Provides
    fun provideRegiseterSerivce(service: RegisterService): IRegisterService {
        return service
    }
}