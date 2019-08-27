package com.example.lastmenu;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastmenu.model.Haberler;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HaberActivity extends AppCompatActivity {

    ArrayList<Haberler> haberModels = new ArrayList<>();



    private HaberAdapter haberAdapter;
    private RecyclerView haber_recyclerView;
    Toolbar toolbar;
    TextView tool_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haber);

        toolbar = findViewById(R.id.toolbar);
        tool_title = (TextView)toolbar.findViewById(R.id.toolbar_title);
        toolbar.setTitle("");
        tool_title.setText("HABERLER");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        haber_recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        haber_recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getCarsResponse();
    }

    private void getCarsResponse() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.239/api/uygulama/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JSONInterface requestInterface = retrofit.create(JSONInterface.class);

        Call<List<Haberler>> call = requestInterface.getHabersJson();

        call.enqueue(new Callback<List<Haberler>>() {
            @Override
            public void onResponse(Call<List<Haberler>> call, Response<List<Haberler>> response) {
                haberModels = new ArrayList<>(response.body());
                haberAdapter = new HaberAdapter(HaberActivity.this,haberModels);
                haber_recyclerView.setAdapter(haberAdapter);
            }

            @Override
            public void onFailure(Call<List<Haberler>> call, Throwable t) {

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