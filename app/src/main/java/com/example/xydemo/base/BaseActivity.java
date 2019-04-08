package com.example.xydemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settingDefaultWindow();
        setContentView(initContentView());
        ButterKnife.bind(this);
        initViews();
    }

    protected abstract void initViews();

    protected void settingDefaultWindow() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected abstract int initContentView();

    protected void showToast(String str){
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }

}
