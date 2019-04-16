package com.example.xydemo.views;

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.example.xydemo.adapter.XRecyclerViewPageAdapter
import com.example.xydemo.base.BaseActivity;
import com.example.xydemo.views.fragment.XRecyclerViewTest1Fragment
import com.example.xydemojava.R;
import java.util.*

class XRecyclerViewTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xrecyclerview_test)

        var vp = findViewById<ViewPager>(R.id.gank_view_pager)
        var fragments = ArrayList<Fragment>()
        var fragment = XRecyclerViewTest1Fragment()
        fragments.add(fragment)



    }

}
