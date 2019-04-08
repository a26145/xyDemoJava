package com.example.xydemo.constant;

import com.example.xydemo.views.MediaTestActivity;
import com.example.xydemo.views.MediaTestOneActivity;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    static String[] names = {"视频播放测试",
            "单个视频测试"};
    static Class[] classes = {MediaTestActivity.class,
            MediaTestOneActivity.class};











    public static class MainMenuModel {
        public List<String> nameList;
        public List<Object> objectsList;
        public int size;
        public MainMenuModel(){
            nameList = new ArrayList<>();
            objectsList = new ArrayList<>();
            for(int i = 0 ; i < names.length ; i++){
                addItem(names[i],classes[i]);
            }
            size = nameList.size();
        }
        public void addItem(String str,Object o) {
            nameList.add(str);
            objectsList.add(o);
        }
        public ItemModel get(int index){
            ItemModel itemModel = new ItemModel();
            itemModel.setName(nameList.get(index));
            itemModel.setClz((Class) objectsList.get(index));
            return itemModel;
        }
    }
    public static class ItemModel{
        String name;
        Class clz;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Class getClz() {
            return clz;
        }

        public void setClz(Class clz) {
            this.clz = clz;
        }
    }

}
