package com.example.usercenter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.basekotlinlibrary.ui.activity.BaseMvpActivity
import com.example.mykotlindemo.R
import com.example.mykotlindemo.presenter.RegisterPresenter
import com.example.mykotlindemo.presenter.view.RegisterView
import org.jetbrains.anko.toast

class RegisterActivity :BaseMvpActivity<RegisterPresenter>(),RegisterView {

    override fun onRegisterResult(isSuccess: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        if(isSuccess){
//            toast("注册成功")
//        }else{
//            toast("注册失败")
//        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_user_center)
        initPresenter()
        mPresenter.register("","","")
    }
    private fun initPresenter() {
        mPresenter = RegisterPresenter()
        mPresenter.mView = this

    }
}