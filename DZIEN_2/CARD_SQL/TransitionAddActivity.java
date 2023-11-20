package com.marcin.cardssql;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class TransitionAddActivity extends AppCompatActivity {
    private EditText nameEditText;
    private TextView initialTextView;
    private int color;
    private Intent intent;
    private Random randomGenerator = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_add);

        nameEditText = (EditText) findViewById(R.id.name);
        initialTextView = (TextView) findViewById(R.id.initial);
        Button add_button = (Button) findViewById(R.id.button);

        intent = getIntent();
        int[] colors = getResources().getIntArray(R.array.initial_colors);
        color = colors[randomGenerator.nextInt(50)];

        initialTextView.setText("");
        initialTextView.setBackgroundColor(color);

        nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 0) {
                    initialTextView.setText("");
                }
                else if (count == 1){
                    initialTextView.setText(String.valueOf(s.charAt(0)));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = initialTextView.getText().toString().trim();
                if (TextUtils.isEmpty(text)){
                    Toast.makeText(getApplicationContext(),"Podaj prawidłowe imię",Toast.LENGTH_SHORT).show();
                }
                else {
                    intent.putExtra(MainActivity.EXTRA_NAME,String.valueOf(nameEditText.getText()));
                    intent.putExtra(MainActivity.EXTRA_INITIAL,String.valueOf(nameEditText.getText().charAt(0)));
                    intent.putExtra(MainActivity.EXTRA_COLOR,color);
                    setResult(RESULT_OK,intent);
                    supportFinishAfterTransition();
                    
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home) {
            super.onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
