package com.example.lastmenu;

import com.example.lastmenu.model.Eczane;
import com.example.lastmenu.model.Haberler;
import com.example.lastmenu.model.Ilceler;
import com.example.lastmenu.model.Kategori;
import com.example.lastmenu.model.Mahalleler;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface JSONInterface {

    @GET("getHaberler")
    Call<List<Haberler>> getHabersJson();

    @GET("getEczane")
    Call<List<Eczane>> getEczaneJson();

    @GET("getCGKategori")
    Call<List<Kategori>> getKategoriJson();

    @GET("getIlceler")
    Call<List<Ilceler>> getIlceJson();

    @GET("getMahalleler")
    Call<List<Mahalleler>> getMahalleJson();


}

