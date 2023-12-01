package com.marcin.network;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadJsonTask extends AsyncTask<String,Void,String> {
    private TextView textView;

    @Override
    protected String doInBackground(String... params) {
        String textUrl = params[0];

        InputStream in = null;
        BufferedReader br = null;
        try{
            URL url = new URL(textUrl);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setAllowUserInteraction(false);
            httpConn.setRequestMethod("GET");
            httpConn.connect();

            int resCode = httpConn.getResponseCode();
            if (resCode == HttpURLConnection.HTTP_OK){
                in = httpConn.getInputStream();
                br = new BufferedReader(new InputStreamReader(in));

                StringBuilder sb = new StringBuilder();
                String s = null;
                while ((s=br.readLine()) != null){
                    sb.append(s);
                    sb.append("\n");
                }
                return sb.toString();
            }else {
                return null;
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(br);
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if(result!=null){
            this.textView.setText(result);
        }else{
            Log.e("MyMessage","Błąd!");

        }
    }
}
