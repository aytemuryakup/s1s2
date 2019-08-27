package com.example.lastmenu.MahalleApi;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.jaredrummler.materialspinner.MaterialSpinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONMahalleParser extends AsyncTask<Void,Void,Boolean> {

    Context c;
    String jsonData;
    Spinner sp;
    ProgressDialog pd;
    MaterialSpinner ms;

    public JSONMahalleParser(Context c, String jsonData, MaterialSpinner ms) {
        this.c = c;
        this.jsonData = jsonData;
        this.ms = ms;
    }

    ArrayList<String> users = new ArrayList<>();


    @Override
    protected void onPreExecute(){

        super.onPreExecute();
        pd = new ProgressDialog(c);
        pd.show();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        return this.parse();
    }

    @Override
    protected void onPostExecute(Boolean isParsed) {
        super.onPostExecute(isParsed);

        pd.dismiss();

        if(isParsed){


            ArrayAdapter<String> adapter = new ArrayAdapter<String>(c,android.R.layout.simple_expandable_list_item_1,users);
            ms.setAdapter(adapter);

            //es.setItemData((List<String>) adapter);

            ms.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
                @Override
                public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                    Toast.makeText(c, users.get(position), Toast.LENGTH_SHORT).show();
                }
            });


        }
        else {
            Toast.makeText(c, "Unable Parse,Check your log output", Toast.LENGTH_SHORT).show();
        }
    }

    private Boolean parse(){


        try {
            JSONArray ja = new JSONArray(jsonData);
            JSONObject jo;
            users.clear();

            for(int i = 0 ;i<ja.length();i++){

                jo =ja.getJSONObject(i);

                String name = jo.getString("AD");
                users.add(name);

            }

            return  true;

        } catch (JSONException e) {
            e.printStackTrace();

            return false;
        }
    }
}
