package com.ibhaka.catchthejerry;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity {

    TextView scoreText;
    TextView timeText;
    int score;
    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;

    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;

    Random random;
    int i;
    CountDownTimer myTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        timeText = (TextView) findViewById(R.id.timeText);
        scoreText = (TextView) findViewById(R.id.scoreText);
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);

        imageArray = new ImageView[]{imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9};

        hideImages();

        score = 0;

        myTimer = new CountDownTimer(10000, 1000) {

            @Override
            public void onTick(long l) {
                timeText.setText("Time : " + l / 1000);

            }

            @Override
            public void onFinish() {
                timeText.setText("Time off");

                handler.removeCallbacks(runnable);

                for (ImageView image : imageArray) {

                    image.setVisibility(View.INVISIBLE);

                }

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity3.this);
                alert.setTitle("Restart?");
                alert.setMessage("Are you sure to restart game?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //restart

                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity3.this, "Game Over!", Toast.LENGTH_SHORT).show();


                        //go to the Game Over Page
                        Intent intent3 = new Intent(MainActivity3.this , MainActivity6.class);
                        startActivity(intent3);
                    }
                });


                alert.show();
             /*   Intent intent = new Intent(MainActivity3.this , MainActivity6.class);
                startActivity(intent);*/
            }


        }.start();

    }
    public void increaseScore (View view){

        score++;
        scoreText.setText("Score : " + score);

        imageArray[i].setVisibility(View.INVISIBLE);




        if (score == 10) {

            Toast.makeText(MainActivity3.this, "level 2 completed", Toast.LENGTH_SHORT).show();

            myTimer.cancel();
            Intent intent2 = new Intent(getApplicationContext(), MainActivity4.class);
            startActivity(intent2);

        }


    }

    public void hideImages(){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for(ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }

                random = new Random();
                i = random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this, 500);

            }
        };

        handler.post(runnable);

    }

    @Override
    public void onBackPressed() {

        // myTimer.onFinish();
        myTimer.cancel();
        finishAffinity();
    }

}