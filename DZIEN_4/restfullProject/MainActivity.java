package com.marcin.restfullwb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.HttpClient;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client.DefaultHttpClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button GetServerData = (Button) findViewById(R.id.button);

        GetServerData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String serverURL = "http://androidexample.com/media/webservice/JsonReturn.php";
            }
        });
    }

    private class LongOperation extends AsyncTask<String,Void,Void>{

        private final HttpClient Client = new DefaultHttpClient();
        private String Content;
        private String Error = null;
        private ProgressDialog Dialog = new ProgressDialog(MainActivity.this);
        String data = "";
        TextView uiUpdate = (TextView) findViewById(R.id.output);
        TextView jsonParsed = (TextView) findViewById(R.id.jsonParsed);
        int sizeData = 0;
        EditText serverText = (EditText) findViewById(R.id.serverText);

        @Override
        protected Void doInBackground(String... strings) {
            return null;
        }
    }
}
