package com.example.mykotlindemo.presenter.service.impl

import com.example.mykotlindemo.presenter.service.UserService
import rx.Observable

class UserServiceImpl :UserService {
    override fun register(mobile: String, veryfyCode: String, pwd: String): Observable<Boolean> {
        return Observable.just(true)
    }
}