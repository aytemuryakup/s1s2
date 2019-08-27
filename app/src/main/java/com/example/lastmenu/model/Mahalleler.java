package com.example.lastmenu.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mahalleler {


    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("AD")
    @Expose
    private String aD;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAD() {
        return aD;
    }

    public void setAD(String aD) {
        this.aD = aD;
    }
}
