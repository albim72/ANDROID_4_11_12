package com.marcin.animacja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void obracaj(View v)
    {
        Animation a = AnimationUtils.loadAnimation(this,R.anim.obrot);
        ImageView iv = (ImageView) findViewById(R.id.imageView);
        iv.startAnimation(a);
    }

    public void skaluj(View v)
    {
        Animation a = AnimationUtils.loadAnimation(this,R.anim.skalowanie);
        ImageView iv = (ImageView) findViewById(R.id.imageView);
        iv.startAnimation(a);
    }

    public void zanikaj(View v)
    {
        Animation a = AnimationUtils.loadAnimation(this,R.anim.zanik);
        ImageView iv = (ImageView) findViewById(R.id.imageView);
        iv.startAnimation(a);
    }

    public void przesuwaj(View v)
    {
        Animation a = AnimationUtils.loadAnimation(this,R.anim.przesow);
        ImageView iv = (ImageView) findViewById(R.id.imageView);
        iv.startAnimation(a);
    }

    public void stosuj_wszystko(View v)
    {
        Animation a = AnimationUtils.loadAnimation(this,R.anim.wszystko);
        ImageView iv = (ImageView) findViewById(R.id.imageView);
        iv.startAnimation(a);
    }
}
