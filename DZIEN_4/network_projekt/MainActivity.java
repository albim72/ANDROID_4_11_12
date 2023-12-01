package com.marcin.network;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.imageView = (ImageView)this.findViewById(R.id.imageView);
        this.textView = (TextView) this.findViewById(R.id.textView);
    }

    private boolean checkInternetConnection(){
        ConnectivityManager connManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();
        if(networkInfo == null){
            Toast.makeText(this, "Aktualnie brak dostępnej sieci!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!networkInfo.isConnected()){
            Toast.makeText(this, "brak połączenia z siecią!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!networkInfo.isAvailable()){
            Toast.makeText(this, "sieć nie jest dostępna", Toast.LENGTH_SHORT).show();
            return false;
        }
        Toast.makeText(this, "sieć OK!", Toast.LENGTH_SHORT).show();
        return true;
    }

    public void downloadAndShowImage(View view){
        boolean networkOK = this.checkInternetConnection();
        if(!networkOK){return;}
        String imageUrl = "https://github.com/albim72/myandroiddata/blob/main/kostki.png";

        DownloadImageTask task = new DownloadImageTask(this.imageView);
        task.execute(imageUrl);
    }

    public void downloadAndShowJson(View view){
        boolean networkOK = this.checkInternetConnection();
        if(!networkOK){return;}
        String jsonUrl = "https://github.com/albim72/myandroiddata/blob/main/pracownik.json";

        DownloadJsonTask task = new DownloadJsonTask(this.textView);
        task.execute(jsonUrl);
    }
}
