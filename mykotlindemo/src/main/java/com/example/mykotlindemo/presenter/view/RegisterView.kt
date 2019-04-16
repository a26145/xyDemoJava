package com.example.mykotlindemo.presenter.view

import com.example.basekotlinlibrary.presenter.view.BaseView

interface RegisterView: BaseView{
    fun onRegisterResult(isSuccess:Boolean)
}