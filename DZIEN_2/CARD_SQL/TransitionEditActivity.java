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

import androidx.appcompat.app.AppCompatActivity;

public class TransitionEditActivity extends AppCompatActivity {
    private EditText nameEditText;
    private TextView initialTextView;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_edit);

        nameEditText = (EditText) findViewById(R.id.name_change);
        initialTextView = (TextView) findViewById(R.id.initialedit);
        Button update_button = (Button) findViewById(R.id.update_button);
        Button delete_button = (Button) findViewById(R.id.delete_button);

        intent = getIntent();
        String nameExtra = intent.getStringExtra(MainActivity.EXTRA_NAME);
        String initialExtra = intent.getStringExtra(MainActivity.EXTRA_INITIAL);
        int colorExtra = intent.getIntExtra(MainActivity.EXTRA_COLOR, 0);

        nameEditText.setText(nameExtra);
        nameEditText.setSelection(nameEditText.getText().length());
        initialTextView.setText(initialExtra);
        initialTextView.setBackgroundColor(colorExtra);

        nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    // Aktualizujemy kontrolkę initialTextView.
                    initialTextView.setText("");
                } else if (s.length() >= 1) {
                    // W kontrolce initialTextView zapisujemy pierwszą literę z kontrolki nameEditText i aktualizujemy
                    // informacje dodatkowe w intencji.
                    initialTextView.setText(String.valueOf(s.charAt(0)));
                    intent.putExtra(MainActivity.EXTRA_UPDATE, true);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Musi być różne od zera, w przeciwnym razie nie kończymy aktywności i wyświetlamy komunikat Toast.
                String text = initialTextView.getText().toString().trim();
                if (TextUtils.isEmpty(text)) {
                    Toast.makeText(getApplicationContext(), "Podaj prawidłowe imię", Toast.LENGTH_SHORT).show();
                } else {
                    intent.putExtra(MainActivity.EXTRA_UPDATE, true);
                    intent.putExtra(MainActivity.EXTRA_NAME, String.valueOf(nameEditText.getText()));
                    intent.putExtra(MainActivity.EXTRA_INITIAL, String.valueOf(nameEditText.getText().charAt(0)));

                    setResult(RESULT_OK, intent);
                    supportFinishAfterTransition();
                }
            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(MainActivity.EXTRA_DELETE, true);

                setResult(RESULT_OK, intent);
                supportFinishAfterTransition();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            super.onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
