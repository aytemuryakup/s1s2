package com.example.lastmenu;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

public class baskan extends AppCompatActivity {

    Toolbar toolbar;
    TextView title, icerik;
    Button ozgecmis,mesaj;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baskan);

        toolbar = findViewById(R.id.toolbar);
        title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        icerik = (TextView)findViewById(R.id.icerik);
        ozgecmis= (Button) findViewById(R.id.ozgecmis);
        mesaj = (Button) findViewById(R.id.mesaj);
        relativeLayout = (RelativeLayout)findViewById(R.id.layout_icerik);
        toolbar.setTitle("");
        // Toolbar üzerinde yazacak yazıyı belirliyorum.
        title.setText("BAŞKAN");
        // toolbarın actionBarı desteklemesini sağlıyoruz.
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ozgecmis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                title.setText("Özgeçmiş");
                icerik.setText("Osman GÜDER 1970 yılında Malatya’da doğdu. İlk ve Orta öğrenimi sonrası 1986 yılında Malatya İmam Hatip Lisesi’nden mezun oldu. Yüksek Lisansını 1992 yılında Fırat Üniversitesi Veterinerlik Fakültesinde tamamladı.\n" +
                        "\n" +
                        "2001 yılında AK Parti Malatya Teşkilatı’nın kuruluşunda yer aldı.\n" +
                        "\n" +
                        "2002 yılında AK Parti İl Yönetim Kurulu üyesi oldu.\n" +
                        "\n" +
                        "2007 yılında Tanıtım ve Medya’dan sorumlu İl Başkan Yardımcılığı görevine getirildi.\n" +
                        "\n" +
                        "2012 yılında AK Parti Malatya Merkez ilçe Başkanlığı görevinde bulundu.\n" +
                        "\n" +
                        "2013-2018 yılları arasında AK Parti Battalgazi Merkez İlçe Başkanlığı görevini yürüttü.\n" +
                        "\n" +
                        "11 Ocak 2019 tarihinde AK Parti Battalgazi Belediye Başkan Adayı gösterildi.\n" +
                        "\n" +
                        "31 Mart 2019 Yerel Seçimlerinde Battalgazi Belediye Başkanı seçildi. \n" +
                        "\n" +
                        "05.04.2019 tarihinde mazbatasını alarak göreve başladı.\n" +
                        "\n" +
                        "Osman Güder evli ve 5 çocuk babasıdır.");

                //elativeLayout.setMovementMethod(new ScrollingMovementMethod());
            }
        });

        mesaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                title.setText("Başkandan Mesaj");
                icerik.setText("Battalgazi Belediye Başkanı Osman Güder, Anneler Günü dolayısıyla bir mesaj yayınladı. Başkan Güder, başta şehit anneleri olmak üzere sevginin, şefkatin ve merhametin timsali tüm annelerin, Anneler Günü'nü kutladı.\n" +
                        "\n" +
                        "Battalgazi Belediye Başkanı Osman Güder, Anneler Günü dolayısıyla yayınladığı mesajında, “Bugün sevginin, şefkatin, merhametin ve sabrın timsali annelerimizin günü. Anne, sevgidir, merhamettir, şefkattir. Anne, en zor zamanlarda en fedakâr insan, bir öğretmen, çocuğu için hayatını adayan, yüreğinde sevgi ve sabrı taşıyan, dünyanın en kutsal varlığıdır. 'Cennet annelerin ayakları altındadır' hadisi şerifi ile inancımız, annelere verilen değeri ve kıymeti en güzel şekilde ortaya koymuştur. Onlara saygıyı, hürmeti, ilgiyi, sadece Anneler Günü’nde değil, her gün göstermeliyiz. İyi günümüzde, kötü günümüzde, zor anlarımızda her daim yanımızda olan annelerimizin sevgisi, karşılıksız olan tek sevgidir. " +
                        "Bu sevgiye layık evlat olabilmek temennisiyle başta şehit annelerimiz olmak üzere tüm annelerin Anneler Günü'nü tebrik ediyorum\" ifadelerine yer verdi");

                //icerik.setMovementMethod(new ScrollingMovementMethod());
            }
        });


    }


    @Override
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

