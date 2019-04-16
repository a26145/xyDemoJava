package com.example.mykotlindemo.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mykotlindemo.R
import com.example.usercenter.RegisterActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTest.setOnClickListener{
            startActivity(intentFor<RegisterActivity>("id" to 5))
            toast("进入注册界面${intent.getIntExtra("id",-1)}")
        }
        mTest1.setOnClickListener{
            startActivity<RegisterActivity>("id" to 10)
            toast("进入注册界面${intent.getIntExtra("id",-1)}")
        }
    }
}
