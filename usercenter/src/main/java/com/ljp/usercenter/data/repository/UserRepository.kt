package com.ljp.usercenter.data.repository

import com.ljp.baselibrary.data.net.RetrofitFactory
import com.ljp.baselibrary.data.protocal.BaseResponse
import com.ljp.usercenter.data.api.UserApi
import com.ljp.usercenter.data.protocal.RegisterRequest
import io.reactivex.Observable
import javax.inject.Inject

class UserRepository @Inject constructor() {

    fun register(mobile: String, verify: String, pwd: String): Observable<BaseResponse<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java)
            .register(RegisterRequest(mobile, verify, pwd))
    }
}