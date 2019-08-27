package com.example.lastmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

public class HaberDetailsActivity extends AppCompatActivity {

    private ImageView haber_foto;
    private TextView haber_baslik,haber_aciklama,haber_tarih,tool_title;
    String baslik,aciklama,tarih;
    Toolbar toolbar;
    int foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haber_details);

        haber_foto = (ImageView)findViewById(R.id.haber_foto);
        haber_baslik = findViewById(R.id.haber_baslik);
        haber_aciklama = findViewById(R.id.haber_aciklama);
        haber_tarih = findViewById(R.id.haber_tarih);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        tool_title=(TextView)toolbar.findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        tool_title.setText("HABERLER");
        baslik = getIntent().getStringExtra("BASLIK");
        aciklama = getIntent().getStringExtra("ICERİK");
        tarih = getIntent().getStringExtra("TARIH");
        foto = getIntent().getIntExtra("FOTO",0);

        haber_tarih.setText(tarih);
        haber_aciklama.setText(aciklama);
        haber_baslik.setText(baslik);
        haber_foto.setImageResource(foto);
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        /* Tıklanan itemin geri tuşu olup olmadığını kontrol ediyoruz. Eğer tıklanan toolbar itemi geri tuşu ise koşulun içine giriyoruz. */
        if (item.getItemId() == android.R.id.home) {
            /* Geri tuşuna basınca açılacak olan sınıfı seçiyoruz. Birinci parametre bulunduğumuz sınıfı temsil ediyor. İkinci parametre ise açılacak sınıfı temsil ediyor. */
            Intent geriButonu = new Intent(getApplicationContext(), HaberActivity.class);
            // geriButonu intentini çalıştırıyoruz.
            NavUtils.navigateUpTo(this, geriButonu);
            return true;
        }
        return true;
    }
}
