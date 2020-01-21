package com.ljp.baselibrary.presenter

import com.ljp.baselibrary.presenter.view.BaseView
import com.trello.rxlifecycle3.LifecycleProvider
import javax.inject.Inject

open class BasePresenter<T : BaseView> {
    lateinit var  mBaseView: T

    @Inject
    lateinit var mLifecycleProvider: LifecycleProvider<*>
}