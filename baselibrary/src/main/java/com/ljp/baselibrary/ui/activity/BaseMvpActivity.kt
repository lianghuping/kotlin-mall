package com.ljp.baselibrary.ui.activity

import android.os.Bundle
import com.ljp.baselibrary.application.BaseApplication
import com.ljp.baselibrary.common.AppManager
import com.ljp.baselibrary.injection.component.ActivityComponent
import com.ljp.baselibrary.injection.component.DaggerActivityComponent
import com.ljp.baselibrary.injection.module.ActivityModule
import com.ljp.baselibrary.injection.module.LifeCycleModule
import com.ljp.baselibrary.presenter.BasePresenter
import com.ljp.baselibrary.presenter.view.BaseView
import com.ljp.baselibrary.widget.ProgressLoading
import javax.inject.Inject

open abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

    @Inject
    lateinit var mBasePresenter: T

    lateinit var mDialogLoading: ProgressLoading
    override fun showLoading() {
        mDialogLoading.showLoading()
    }

    override fun hideLoading() {
        mDialogLoading.hideLoading()
    }

    override fun onError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initInjection()
        injectComponent()
        AppManager.instance.addActivity(this)
        mDialogLoading = ProgressLoading.create(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.removeActivity(this)
    }

    lateinit var activityComponent: ActivityComponent
    private fun initInjection() {
        activityComponent = DaggerActivityComponent.builder()
            .appComponent((application as BaseApplication).appComponent)
            .activityModule(ActivityModule(this))
            .lifeCycleModule(LifeCycleModule(this))
            .build()
    }

    abstract fun injectComponent()
}