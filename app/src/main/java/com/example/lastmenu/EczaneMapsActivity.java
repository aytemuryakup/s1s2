package com.example.lastmenu;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.core.app.NavUtils;
import androidx.fragment.app.FragmentActivity;

import com.example.lastmenu.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class EczaneMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    Toolbar toolbar;
    TextView tool_title;
    String konum,adi,adres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eczane_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        konum = getIntent().getStringExtra("EczaneKonum");
        adi = getIntent().getStringExtra("EczaneAdi");
        adres = getIntent().getStringExtra("EczaneAdres");
        String[] ayirma = konum.split(",");

        // Add a marker in Sydney, Australia, and move the camera.
        LatLng eczanekonum = new LatLng(Double.parseDouble(ayirma[0]), Double.parseDouble(ayirma[1]));
        mMap.addMarker(new MarkerOptions().position(eczanekonum).title(adi).snippet(adres));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(eczanekonum,16));
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