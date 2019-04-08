package com.example.xydemo.base;

import android.app.Activity;
import android.app.Application;

import java.util.LinkedList;

public class BaseApplication extends Application {
    static BaseApplication application;
    static LinkedList<Activity> activityList;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        initActivityGroup();
    }
    private void initActivityGroup() {
        activityList = new LinkedList<>();
    }
    public BaseApplication getAppContext(){
        return application;
    }

    public void addActivity(BaseActivity activity){
        activityList.add(activity);
        activity.finish();
    }

    public void removeLastActivity(){
        Activity first = activityList.getFirst();
        first.finish();
        activityList.removeLast();
    }

    public void removeFirstActivity(){
        Activity first = activityList.getFirst();
        activityList.removeFirst();
        first.finish();
    }
    public void removeAll(){
        for(Activity activity:activityList){
            activity.finish();
            activityList.remove(activity);
        }
    }
    public void exit(){
        try {
            removeAll();
        }catch (Exception e){
            System.exit(0);
        }
    }
}
