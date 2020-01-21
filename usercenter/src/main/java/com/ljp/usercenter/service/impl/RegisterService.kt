package com.ljp.usercenter.service.impl

import com.ljp.baselibrary.rx.BaseFun
import com.ljp.baselibrary.rx.BaseFunBoolean
import com.ljp.usercenter.data.repository.UserRepository
import com.ljp.usercenter.service.IRegisterService
import io.reactivex.Observable
import javax.inject.Inject

class RegisterService @Inject constructor()  : IRegisterService {

    @Inject
    lateinit var userRepository: UserRepository


    override fun register(mobile: String, verify: String, pwd: String): Observable<Boolean> {
        return userRepository.register(mobile, verify, pwd)
            .flatMap(BaseFunBoolean())
    }
}