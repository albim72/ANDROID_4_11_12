package com.marcin.kalkulatorbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.btnBMI);
        final EditText masa = (EditText) findViewById(R.id.etMasa);
        final EditText wzrost = (EditText) findViewById(R.id.etWzrost);
        final TextView wyn = (TextView) findViewById(R.id.wynik);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double m = new Double(masa.getText().toString());
                double w = new Double(wzrost.getText().toString());
                double bmi;

                WynikBMI obmi = new WynikBMI(m,w);
                bmi = obmi.obliczBMI(m,w);
                wyn.setText("Twoje BMI wynosi: " + bmi);
            }
        });
    }
}
