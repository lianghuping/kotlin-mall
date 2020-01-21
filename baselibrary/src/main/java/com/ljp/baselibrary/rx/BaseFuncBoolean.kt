package com.ljp.baselibrary.rx

import com.ljp.baselibrary.data.protocal.BaseResponse
import io.reactivex.Observable
import io.reactivex.functions.Function

class BaseFunBoolean<T> : Function<BaseResponse<T>, Observable<Boolean>> {
    override fun apply(baseResponse: BaseResponse<T>): Observable<Boolean> {
        if (baseResponse.status != "0") {
           //  Observable.error<Boolean>(BaseException(baseResponse.status,baseResponse.message))
          return  Observable.error(BaseException(baseResponse.status,baseResponse.message))
        }
        return Observable.just(true)
    }
}