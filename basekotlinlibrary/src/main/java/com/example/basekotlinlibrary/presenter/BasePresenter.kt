package com.example.basekotlinlibrary.presenter

import com.example.basekotlinlibrary.presenter.view.BaseView

open class BasePresenter<T:BaseView> {
    lateinit var mView:T
}