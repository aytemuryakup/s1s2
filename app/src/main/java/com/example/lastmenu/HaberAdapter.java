package com.example.lastmenu;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastmenu.model.Haberler;


import com.squareup.picasso.Picasso;


import java.io.File;

import java.util.ArrayList;

public class HaberAdapter extends RecyclerView.Adapter<HaberAdapter.ViewHolder> {

    private ArrayList<Haberler> haberModels = new ArrayList<>();
    private Context context;



    public HaberAdapter(Context context, ArrayList<Haberler> haberModels){
        this.haberModels = haberModels;
        this.context = context;


    }

    @NonNull
    @Override
    public HaberAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.haber_list_item, parent,false);
        return new HaberAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final HaberAdapter.ViewHolder holder, int position) {

        final Haberler haber = haberModels.get(position);
        Picasso.with(context)
                .load(haberModels.get(position).getFOTO())
                .noFade()
                .fit()
                .into(holder.haber_image);

        holder.haber_name.setText(haberModels.get(position).getBASLIK());
        holder.haber_desc.setText(haberModels.get(position).getICERK());
        holder.haber_tarih.setText(Utils.DateFormat(haber.getTARIH()));

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,HaberDetailsActivity.class);
                intent.putExtra("BASLIK",haber.getBASLIK());
                intent.putExtra("ICERİK",haber.getICERK());
                intent.putExtra("FOTO",haber.getFOTO());
                intent.putExtra("TARIH",haber.getTARIH());
                context.startActivity(intent);
            }
        });

        /*String deneme = "http://malatyahaber.com/wp-content/themes/tema/lib/timthumb.php?src=http://malatyahaber.com/wp-content/uploads/2018/05/ye%C5%9Filyurtbelediyesi.jpg&w=630&h=315";


       ImageLoader imageLoader = AppController.getInstance().getImageLoader();
        // resim indirilirken ve hata olması durumunda gösterilecek resimleri ayarladık.
        imageLoader.get(deneme, ImageLoader.getImageListener(holder.haber_image, R.drawable.yukleniyor, R.drawable.hata));
        // resim alınıyor
        imageLoader.get(deneme, new ImageLoader.ImageListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
               // hata olursa dialog kapansın ve hata mesajı loga basılsın
                Log.d("hata",error.toString());
            }

            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean arg1) {
                if (response.getBitmap() != null) {
                    holder.haber_image.setImageBitmap(response.getBitmap()); // bitmap'e çevirip set ettik
                }

            }
        });
*/

    }

    @Override
    public int getItemCount() {
        return haberModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView haber_image;
        private TextView haber_name,haber_desc,haber_tarih;
        private ProgressBar progressBar;
        private RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            haber_image = (ImageView)itemView.findViewById(R.id.haber_img);
            haber_name = (TextView) itemView.findViewById(R.id.haber_name);
            haber_desc = (TextView) itemView.findViewById(R.id.haber_desc);
            haber_tarih = (TextView) itemView.findViewById(R.id.publishAt);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relative_layout);

        }
    }






}
