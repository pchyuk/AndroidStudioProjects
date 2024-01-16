package com.example.diceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imageView2;
    ImageView imageView3;
    Button button;

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        button = findViewById(R.id.button);

        Button buttonToMarket = (Button) findViewById(R.id.marketButton);

        buttonToMarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MarketActivity.class);
                startActivity(intent);
            }
        });

        mp = MediaPlayer.create(MainActivity.this,R.raw.dice_sound);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mp.start();
                Random random = new Random();
                int num1 = random.nextInt(5 + 1);
                int num2 = random.nextInt(5 + 1);

                if(num1 == 0) {
                    imageView2.setImageResource(R.drawable.dice1);
                } else if (num1 == 1) {
                    imageView2.setImageResource(R.drawable.dice2);
                } else if (num1 == 2) {
                    imageView2.setImageResource(R.drawable.dice3);
                } else if (num1 == 3) {
                    imageView2.setImageResource(R.drawable.dice4);
                } else if (num1 == 4) {
                    imageView2.setImageResource(R.drawable.dice5);
                } else  {
                    imageView2.setImageResource(R.drawable.dice6);
                }

                if(num2 == 0) {
                    imageView3.setImageResource(R.drawable.dice1);
                } else if (num2 == 1) {
                    imageView3.setImageResource(R.drawable.dice2);
                } else if (num2 == 2) {
                    imageView3.setImageResource(R.drawable.dice3);
                } else if (num2 == 3) {
                    imageView3.setImageResource(R.drawable.dice4);
                } else if (num2 == 4) {
                    imageView3.setImageResource(R.drawable.dice5);
                } else {
                    imageView3.setImageResource(R.drawable.dice6);
                }

                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(imageView2);
                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(imageView3);

            }
        });
    }
}