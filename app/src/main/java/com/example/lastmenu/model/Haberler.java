package com.example.lastmenu.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Haberler {

    @SerializedName("ICERİK")
    @Expose
    private String iCERK;
    @SerializedName("FOTO")
    @Expose
    private String fOTO;
    @SerializedName("BASLIK")
    @Expose
    private String bASLIK;
    @SerializedName("TARIH")
    @Expose
    private String tARIH;





    public String getICERK() {
        return iCERK;
    }

    public void setICERK(String iCERK) {
        this.iCERK = iCERK;
    }

    public String getFOTO() {
        return fOTO;
    }

    public void setFOTO(String fOTO) {
        this.fOTO = fOTO;
    }

    public String getBASLIK() {
        return bASLIK;
    }

    public void setBASLIK(String bASLIK) {
        this.bASLIK = bASLIK;
    }

    public String getTARIH() {
        return tARIH;
    }

    public void setTARIH(String tARIH) {
        this.tARIH = tARIH;
    }


}
