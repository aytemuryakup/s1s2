package com.example.lastmenu;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lastmenu.model.Eczane;
import com.example.lastmenu.model.Haberler;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class EczaneActivity extends AppCompatActivity {

    RecyclerView eczane_recyclerView;
    ArrayList<Eczane> eczaneModels = new ArrayList<>();

    EczaneAdapter eczaneAdapter;
    Toolbar toolbar;
    TextView tool_title;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eczane);

        toolbar = findViewById(R.id.toolbar);
        tool_title = (TextView)toolbar.findViewById(R.id.toolbar_title);
        toolbar.setTitle("");
        tool_title.setText("ECZANE");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        eczane_recyclerView = findViewById(R.id.recyclerview);
        eczane_recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getEczaneResponse();


    }

    private void getEczaneResponse() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.239/api/uygulama/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JSONInterface requestInterface = retrofit.create(JSONInterface.class);

        Call<List<Eczane>> call = requestInterface.getEczaneJson();

        call.enqueue(new Callback<List<Eczane>>() {
            @Override
            public void onResponse(Call<List<Eczane>> call, Response<List<Eczane>> response) {
                eczaneModels = new ArrayList<>(response.body());
                eczaneAdapter = new EczaneAdapter(EczaneActivity.this,eczaneModels);
                eczane_recyclerView.setAdapter(eczaneAdapter);
            }

            @Override
            public void onFailure(Call<List<Eczane>> call, Throwable t) {


            }
        });


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        /* Tıklanan itemin geri tuşu olup olmadığını kontrol ediyoruz. Eğer tıklanan toolbar itemi geri tuşu ise koşulun içine giriyoruz. */
        if (item.getItemId() == android.R.id.home) {
            /* Geri tuşuna basınca açılacak olan sınıfı seçiyoruz. Birinci parametre bulunduğumuz sınıfı temsil ediyor. İkinci parametre ise açılacak sınıfı temsil ediyor. */
            Intent geriButonu = new Intent(getApplicationContext(), MainActivity.class);
            // geriButonu intentini çalıştırıyoruz.
            NavUtils.navigateUpTo(this, geriButonu);
            return true;
        }
        return true;
    }


}
