package com.marcin.jsonparse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String strJSON = "{ \"Android\":[{\"song_name\":\"piosenka 1\",\"song_id\":\"67\",\"artist_name\":\"artysta 1\"},{\"song_name\":\"piosenka 2\",\"song_id\":\"88\",\"artist_name\":\"artysta 2\"}]}";

        final TextView output = (TextView) findViewById(R.id.textView);
        final Button bparsejson = (Button) findViewById(R.id.button);

        String daneDoParsowania = "Kliknij na przycisk do parsowania danych JSON.\n\nDane w formacie JSON:\n" + strJSON;
        output.setText(daneDoParsowania);

        bparsejson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String OutputData = "";
                JSONObject jsonResponse;
                try{
                    jsonResponse = new JSONObject(strJSON);
                    JSONArray jsonMainNode = jsonResponse.optJSONArray("Android");
                    int lengthJSONArr = jsonMainNode.length();

                    for(int i=0;i<lengthJSONArr;i++){
                        JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
                        int song_id = Integer.parseInt(jsonChildNode.optString("song_id").toString());
                        String song_name = jsonChildNode.optString("song_name").toString();
                        String artist_name = jsonChildNode.optString("artist_name").toString();

                        OutputData += "Wiersz: \n\n" + song_id + "|" +song_name + "|" + artist_name + "|\n\n";
                    }
                    output.setText(OutputData);

                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
