package com.marcin.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String PREFERENCES_NAME = "myPreferences";
    private static final String PREFERENCES_TEXT_FIELD = "textField";
    private EditText etSave;
    private Button btnSave;
    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences(PREFERENCES_NAME, Activity.MODE_PRIVATE);
        etSave = (EditText) findViewById(R.id.etSave);
        btnSave = (Button) findViewById(R.id.btnSave);
        initButtonOnClick();
        restoreData();
    }

    private void saveData(){
        SharedPreferences.Editor preferencesEditor = preferences.edit();
        String editTextData = etSave.getText().toString();
        preferencesEditor.putString(PREFERENCES_TEXT_FIELD, editTextData);
        preferencesEditor.commit();
    }

    private void restoreData(){
        String textFromPreferences = preferences.getString(PREFERENCES_TEXT_FIELD,"");
        etSave.setText(textFromPreferences);
    }

    private void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    private void initButtonOnClick(){
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
                showToast("Data save!!!");
            }
        });
    }
}
