package com.example.xydemo.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class LordMoreResponseEntity implements Serializable {

        @SerializedName("results")
        private List<LordMoreEntity> mResults;

        public List<LordMoreEntity> getResults() {
            return mResults;
        }
    }

