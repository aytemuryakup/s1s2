package com.example.lastmenu.IlceApi;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.jaredrummler.materialspinner.MaterialSpinner;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class JSONIlceDowloader extends AsyncTask<Void,Void,String> {

    Context c;
    String jsonURL;
    MaterialSpinner ms;
    ProgressDialog pd;

    public JSONIlceDowloader(Context c, String jsonURL, MaterialSpinner ms) {
        this.c = c;
        this.jsonURL = jsonURL;
        this.ms = ms;
    }

    @Override
    protected void onPreExecute(){

        super.onPreExecute();
        pd = new ProgressDialog(c);
        pd.show();
    }

    @Override
    protected String doInBackground(Void... voids) {
        return this.dowload();
    }

    @Override
    protected void onPostExecute(String jsonData) {
        super.onPostExecute(jsonData);

        pd.dismiss();

        if (jsonData.startsWith("Error")){
            Toast.makeText(c, jsonData, Toast.LENGTH_SHORT).show();
        }

        else {

            new JSONIlceParser(c,jsonData,ms).execute();

        }
    }

    private String dowload(){

        Object connection = Connector.connect(jsonURL);
        if(connection.toString().startsWith("Error")){

            return connection.toString();

        }

        try {
            HttpURLConnection con = (HttpURLConnection) connection;
            if(con.getResponseCode() == con.HTTP_OK){

                InputStream is = new BufferedInputStream(con.getInputStream());
                BufferedReader bf = new BufferedReader(new InputStreamReader(is));

                String line;
                StringBuffer jsonData = new StringBuffer();

                while ((line=bf.readLine()) != null){

                    jsonData.append(line);
                }

                bf.close();
                is.close();

                return jsonData.toString();

            }
            else{
                return "Error" +con.getResponseMessage();
            }
        } catch (IOException e) {

            e.printStackTrace();

            return "Error" +e.getMessage();

        }
    }
}
