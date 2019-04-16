package com.example.mykotlindemo.presenter.service

import rx.Observable


interface UserService {
    fun register(mobile:String,veryfyCode:String,pwd:String): Observable<Boolean>
}