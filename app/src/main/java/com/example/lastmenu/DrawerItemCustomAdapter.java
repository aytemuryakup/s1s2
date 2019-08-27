package com.example.lastmenu;



import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DrawerItemCustomAdapter extends ArrayAdapter<MenuItem> {

    Context mContext;
    int layoutResourceId;
    MenuItem menu[] = null;

    public DrawerItemCustomAdapter(Context mContext, int layoutResourceId, MenuItem[] menu) {

        super(mContext, layoutResourceId, menu);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.menu = menu;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItem = convertView;

        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        listItem = inflater.inflate(layoutResourceId, parent, false);


        TextView textViewName = (TextView) listItem.findViewById(R.id.text1);

        MenuItem folder = menu[position];



        textViewName.setText(folder.name);

        return listItem;
    }
}

