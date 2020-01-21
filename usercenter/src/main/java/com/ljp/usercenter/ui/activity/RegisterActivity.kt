package com.ljp.usercenter.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ljp.baselibrary.common.AppManager
import com.ljp.baselibrary.presenter.view.BaseView
import com.ljp.baselibrary.ui.activity.BaseMvpActivity
import com.ljp.usercenter.R
import com.ljp.usercenter.injection.component.DaggerUserComponent
import com.ljp.usercenter.injection.module.UserModule
import com.ljp.usercenter.presenter.RegisterPresenter
import com.ljp.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {

    override fun injectComponent() {
        DaggerUserComponent.builder().userModule(UserModule()).activityComponent(activityComponent)
            .build().inject(this)
        mBasePresenter.mBaseView = this
    }

    override fun onRegister(result: String) {
        toast(result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mRegisterBtn.setOnClickListener {
            //toast("注册！")
            mBasePresenter.register("", "", "")
        }
    }

    private var current:Long = 0
    override fun onBackPressed() {
    //    super.onBackPressed()
        var pressTime = System.currentTimeMillis()
        if(pressTime - current > 1000){
            toast("再点击一次退出程序")
            current = pressTime
        }else{
            AppManager.instance.exitApp(this)
        }
    }
}
