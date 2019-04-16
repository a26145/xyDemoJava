package com.example.mykotlindemo.presenter

import com.example.basekotlinlibrary.presenter.BasePresenter
import com.example.basekotlinlibrary.rx.BaseSubscriber
import com.example.mykotlindemo.common.execute
import com.example.mykotlindemo.presenter.service.impl.UserServiceImpl
import com.example.mykotlindemo.presenter.view.RegisterView


class RegisterPresenter : BasePresenter<RegisterView>() {

    fun register(mobile: String, verifyCode: String, pwd: String) {
        /**
         * 注册的业务
         */
        var userService = UserServiceImpl()
        userService.register(mobile, verifyCode, pwd)
                .execute(object : BaseSubscriber<Boolean>() {
                    override fun onNext(t: Boolean) {
                        mView.onRegisterResult(t)
                    }
                })
    }

}