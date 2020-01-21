package com.ljp.usercenter.presenter

import com.ljp.baselibrary.ext.execute
import com.ljp.baselibrary.presenter.BasePresenter
import com.ljp.baselibrary.rx.BaseObserver
import com.ljp.usercenter.presenter.view.RegisterView
import com.ljp.usercenter.service.impl.RegisterService
import javax.inject.Inject

class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {

    @Inject
    lateinit var mRegisterService: RegisterService

    fun register(mobile: String, verify: String, pwd: String) {

        mBaseView.showLoading()

        mRegisterService.register(mobile, verify, pwd).execute(object : BaseObserver<Boolean>(mBaseView) {
            override fun onNext(t: Boolean) {
                super.onNext(t)
                if (t)
                    mBaseView.onRegister("注册成功")
                else {
                    mBaseView.onRegister("注册失败")
                }
            }
        }, mLifecycleProvider)
    }
}