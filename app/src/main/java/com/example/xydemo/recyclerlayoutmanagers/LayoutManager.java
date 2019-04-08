package com.example.xydemo.recyclerlayoutmanagers;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

/**
 * todo
 */
public class LayoutManager {

    public static LinearLayoutManager buildLinearManager(Context context){
        return new LinearLayoutManager(context);
    }
}
