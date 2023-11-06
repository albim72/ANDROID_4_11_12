package com.marcin.figury;

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

        Button btnProst = (Button) findViewById(R.id.btnProst);
        Button btnTroj = (Button) findViewById(R.id.btnTroj);
        Button btnKolo = (Button) findViewById(R.id.btnKl);

        final EditText bokA = (EditText) findViewById(R.id.etBokA);
        final EditText bokB = (EditText) findViewById(R.id.etBokB);
        final EditText podst = (EditText) findViewById(R.id.etPodstawa);
        final EditText wys = (EditText) findViewById(R.id.etWys);

        final TextView wynikP = (TextView) findViewById(R.id.wynikProst);
        final TextView wynikT = (TextView) findViewById(R.id.wynikTroj);
        final TextView wynikK = (TextView) findViewById(R.id.wynikK);

        btnTroj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double pod = Double.parseDouble(podst.getText().toString());
                double wysk = Double.parseDouble(wys.getText().toString());

                Trojkat troj = new Trojkat(pod,wysk);
                wynikT.setText(String.valueOf(troj.policzPole()));
            }
        });


        btnProst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double bok_a = Double.parseDouble(bokA.getText().toString());
                double bok_b = Double.parseDouble(bokB.getText().toString());

                Prostokat prost = new Prostokat(bok_a,bok_b);
                wynikP.setText(String.valueOf(prost.policzPole()));
            }
        });

        btnKolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double prom = Double.parseDouble(podst.getText().toString());

                Kolo kl = new Kolo(prom);
                wynikK.setText(String.valueOf(kl.policzPole()));
            }
        });

    }
}
