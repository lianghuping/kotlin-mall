package com.ljp.baselibrary.rx

import com.ljp.baselibrary.presenter.view.BaseView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

open class BaseObserver<T>(val mLoadingView:BaseView) : Observer<T> {
    override fun onComplete() {
        mLoadingView.hideLoading()
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(t: T) {
    }

    override fun onError(e: Throwable) {
        mLoadingView.hideLoading()
    }

}