package com.ibhaka.catchthejerry;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.textView);

    }

    public void goLevel2(View view){


        Intent intent = new Intent(MainActivity2.this , MainActivity3.class);

        startActivity(intent);

    }

    @Override
    public void onBackPressed() {

        finishAffinity();
    }
}