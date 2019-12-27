package com.ljp.usercenter.service.impl

import com.ljp.usercenter.service.IRegisterService
import io.reactivex.Observable

class RegisterService :IRegisterService{
    override fun register(mobile: String, verify: String, pwd: String): Observable<Boolean> {
        return Observable.just(true)
    }


}