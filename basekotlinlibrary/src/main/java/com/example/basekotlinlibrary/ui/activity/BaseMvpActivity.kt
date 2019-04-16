package com.example.basekotlinlibrary.ui.activity

import com.example.basekotlinlibrary.presenter.BasePresenter
import com.example.basekotlinlibrary.presenter.view.BaseView

open class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {
    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var mPresenter: T
}