package com.example.businessapplicationdevelopment.api.apitest;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("self")
    @Expose
    private com.example.businessapplicationdevelopment.api.apitest.Self self;

    public com.example.businessapplicationdevelopment.api.apitest.Self getSelf() {
        return self;
    }

    public void setSelf(com.example.businessapplicationdevelopment.api.apitest.Self self) {
        this.self = self;
    }

}
