package com.marcin.kalkulatorodleglosci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton milaM, milaL, jard, stopa, cal;
    private Button button;
    private TextView textView;
    private EditText dist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.rgroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rbMilaM){
                    Toast.makeText(getApplicationContext(),"wybrano: Mile morskie", Toast.LENGTH_SHORT).show();
                }
                else if (i == R.id.rbMilaL){
                    Toast.makeText(getApplicationContext(),"wybrano: Mile lądowe", Toast.LENGTH_SHORT).show();
                }
                else if (i == R.id.rbJard){
                    Toast.makeText(getApplicationContext(),"wybrano: jardy", Toast.LENGTH_SHORT).show();
                }
                else if (i == R.id.rbStopa){
                    Toast.makeText(getApplicationContext(),"wybrano: stopy", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"wybrano: cale", Toast.LENGTH_SHORT).show();
                }
            }
        });

        milaM = (RadioButton)findViewById(R.id.rbMilaM);
        milaL = (RadioButton)findViewById(R.id.rbMilaL);
        jard = (RadioButton)findViewById(R.id.rbJard);
        stopa = (RadioButton)findViewById(R.id.rbStopa);
        cal = (RadioButton)findViewById(R.id.rbCal);
        textView = (TextView) findViewById(R.id.wynik);

        button = (Button) findViewById(R.id.btnPrzelicz);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                dist = (EditText) findViewById(R.id.etMetry);
                final double ds = new Double(dist.getText().toString());

                java.text.DecimalFormat df = new java.text.DecimalFormat();
                df.setMaximumFractionDigits(2);
                df.setMinimumFractionDigits(2);

                if(selectedId == milaM.getId()) {
                    Anglo ml = new Anglo(ds,IPrzeliczniki.milaPP);
                    textView.setText("odległość w milach morskich: " + df.format(ml.policzOdl()));

                }

            }
        });
    }
}
