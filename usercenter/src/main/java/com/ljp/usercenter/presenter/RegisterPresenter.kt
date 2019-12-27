package com.ljp.usercenter.presenter

import com.ljp.baselibrary.ext.execute
import com.ljp.baselibrary.presenter.BasePresenter
import com.ljp.baselibrary.rx.BaseObserver
import com.ljp.usercenter.presenter.view.RegisterView
import com.ljp.usercenter.service.impl.RegisterService

class RegisterPresenter(registerView: RegisterView) : BasePresenter<RegisterView>() {

    val mRegisterService: RegisterService

    val mRegisterView: RegisterView

    init {
        mRegisterView = registerView
        mRegisterService = RegisterService()
    }

    fun register(mobile: String, verify: String, pwd: String) {

        mRegisterService.register(mobile, verify, pwd).execute(object : BaseObserver<Boolean>() {
            override fun onNext(t: Boolean) {
                super.onNext(t)
                mRegisterView.onRegister()
            }
        })
    }
}