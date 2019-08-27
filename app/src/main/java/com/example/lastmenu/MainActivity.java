package com.example.lastmenu;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{



    SliderLayout sliderLayout;
    HashMap<String,String> Hash_file_maps ;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ArrayAdapter mStringAdaptor;
    private String[] mStringOfPlanets;
    private Button menubutton;
    private String[] mNavigationDrawerItemTitles;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        sliderLayout = (SliderLayout)findViewById(R.id.slider);
        menubutton = (Button) findViewById(R.id.menubutton);
        mNavigationDrawerItemTitles = getResources().getStringArray(R.array.planets_array);

        menubutton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {

                mDrawerLayout.openDrawer(Gravity.START);
            }
        });

        Hash_file_maps = new HashMap<String, String>();

        Hash_file_maps.put("Malatya Battalgazi Beledeyesi", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHtZ4oDj7clx8TqoRulw7AL9j2Nrieymircn2Cp2L_qcwpkxxg");
        Hash_file_maps.put("Battalgazi Beledeyesi", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKZvIOCn-3ZeHo2_xEm27YK5IpH5HOzbU0lSuO2Of39ePFhjGl");
        Hash_file_maps.put("Türkiye Başkanı", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRFLjq_zWLql3U5xH-i7_ZwAbucNmOnlbmMcUtuWNuyj5EMrxnI");
        Hash_file_maps.put("Başkan ziyaretler", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQebKJfZ_hGCUbX8Y8EGgM_UxCos36uTd23tNTQ9bjNyN4TiiP8");

        for(String name : Hash_file_maps.keySet()){

            TextSliderView textSliderView = new TextSliderView(MainActivity.this);
            textSliderView
                    .description(name)
                    .image(Hash_file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);
            sliderLayout.addSlider(textSliderView);
        }

        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(5000);
        sliderLayout.addOnPageChangeListener(this);







        mStringOfPlanets = getResources().getStringArray(R.array.planets_array);

        MenuItem[] menuItem = new MenuItem[4];
        menuItem[0] = new MenuItem("BAŞKAN");
        menuItem[1] = new MenuItem("HABERLER");
        menuItem[2] = new MenuItem("NÖBETÇİ ECZANE");
        menuItem[3] = new MenuItem("ÇEK/GÖNDER");


        //Başkanın Fotoğrafını menu başına ekleme
        View listHeaderView = getLayoutInflater().inflate(R.layout.nav_header, null, false);
        mDrawerList.addHeaderView(listHeaderView);


        DrawerItemCustomAdapter draweradapter = new DrawerItemCustomAdapter(this, R.layout.drawer_list_item, menuItem);
        mDrawerList.setAdapter(draweradapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                // Sol menudeki elemanlara tıklandığında pozisyonlarını değiştirmek için bunu kullanacağız.
                if(position == 1){
                    Intent intent = new Intent(MainActivity.this, baskan.class);
                    startActivity(intent);
                }

               else if(position == 2){
                    Intent intent = new Intent(MainActivity.this, HaberActivity.class);
                    startActivity(intent);
                }

                if(position == 3){
                    Intent intent = new Intent(MainActivity.this, EczaneActivity.class);
                    startActivity(intent);
                }

                if(position == 4){
                    Intent intent = new Intent(MainActivity.this, CekGonderActivity.class);
                    startActivity(intent);
                }
            }
        });
    }



    @Override
    protected void onStop() {

        sliderLayout.stopAutoCycle();

        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {

        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}

    public void onDialButton(View v ){

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:04223284444"));

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) !=
                PackageManager.PERMISSION_GRANTED) {


            return;

        }
        startActivity(intent);

    }
}
