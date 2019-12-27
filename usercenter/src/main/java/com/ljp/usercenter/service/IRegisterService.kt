package com.ljp.usercenter.service

import io.reactivex.Observable

interface IRegisterService {

    fun register(mobile:String,verify:String,pwd:String):Observable<Boolean>
}