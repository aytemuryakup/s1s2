package com.example.lastmenu.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Kategori {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("Isim")
    @Expose
    private String isim;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }
}
