package com.marcin.timestamp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView t1 = (TextView) findViewById(R.id.textView);
        final TextView t2 = (TextView) findViewById(R.id.textView2);
        final TextView t3 = (TextView) findViewById(R.id.textView3);
        final TextView t4 = (TextView) findViewById(R.id.textView4);
        final TextView t5 = (TextView) findViewById(R.id.textView5);
        final TextView t6 = (TextView) findViewById(R.id.textView6);
        final TextView t7 = (TextView) findViewById(R.id.textView7);
        final TextView t8 = (TextView) findViewById(R.id.textView8);
        final TextView t9 = (TextView) findViewById(R.id.textView9);
        final TextView t10 = (TextView) findViewById(R.id.textView10);

        Button btnData = (Button) findViewById(R.id.button);

        btnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calend = Calendar.getInstance();

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
                Date ndata = new Date();
                String mmd = dateFormat.format(ndata);

                t1.setText("Rok: " + calend.get(Calendar.YEAR));
                t2.setText("Miesiąc: " + calend.get(Calendar.MONTH));
                t3.setText("Dzień miesiąca: " + calend.get(Calendar.DAY_OF_MONTH));
                t4.setText("Dzień tygodnia: " + calend.get(Calendar.DAY_OF_WEEK));
                t5.setText("Tydzień roku: " + calend.get(Calendar.WEEK_OF_YEAR));
                t6.setText("Godzina: " + calend.get(Calendar.HOUR));
                t7.setText("Godzina dnia: " + calend.get(Calendar.HOUR_OF_DAY));
                t8.setText("Minuta: " + calend.get(Calendar.MINUTE));
                t9.setText("Sekunda: " + calend.get(Calendar.SECOND));
                t10.setText("Data: " + mmd);
            }
        });

    }
}
