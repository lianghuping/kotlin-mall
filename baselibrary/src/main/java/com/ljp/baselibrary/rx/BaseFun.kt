package com.ljp.baselibrary.rx

import com.ljp.baselibrary.data.protocal.BaseResponse
import io.reactivex.Observable
import io.reactivex.functions.Function

class BaseFun<T> : Function<BaseResponse<T>,Observable<T>> {
    override fun apply(baseResponse: BaseResponse<T>): Observable<T> {
        if (baseResponse.status != "0") {
            //  Observable.error<Boolean>(BaseException(baseResponse.status,baseResponse.message))
            return  Observable.error(BaseException(baseResponse.status,baseResponse.message))
        }
        return Observable.just(baseResponse.data)
    }
}