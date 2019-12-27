package com.ljp.baselibrary.ui.activity

import com.ljp.baselibrary.presenter.BasePresenter
import com.ljp.baselibrary.presenter.view.BaseView

open class BaseMvpActivity<T:BasePresenter<*>> : BaseActivity(),BaseView{

    lateinit var mBasePresenter: T

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}