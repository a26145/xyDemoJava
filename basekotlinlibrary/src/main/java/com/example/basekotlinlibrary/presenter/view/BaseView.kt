package com.example.basekotlinlibrary.presenter.view

interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onError()
}