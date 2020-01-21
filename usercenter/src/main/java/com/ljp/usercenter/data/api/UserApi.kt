package com.ljp.usercenter.data.api

import com.ljp.baselibrary.data.protocal.BaseResponse
import com.ljp.usercenter.data.protocal.RegisterRequest
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("userCenter/register")
    fun  register(@Body request:RegisterRequest): Observable<BaseResponse<String>>
}