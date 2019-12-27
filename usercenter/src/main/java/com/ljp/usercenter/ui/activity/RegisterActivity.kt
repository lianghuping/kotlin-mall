package com.ljp.usercenter.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ljp.baselibrary.ui.activity.BaseMvpActivity
import com.ljp.usercenter.R
import com.ljp.usercenter.presenter.RegisterPresenter
import com.ljp.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {

    override fun onRegister() {
        toast("注册成功！")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mRegisterBtn.setOnClickListener {
            //toast("注册！")
            mBasePresenter.register("","","")
        }
        mBasePresenter = RegisterPresenter(this)
    }
}
