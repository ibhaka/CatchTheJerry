package com.ibhaka.catchthejerry;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        textView = findViewById(R.id.textView);

    }
    public void goLevel3(View view){

        Intent intent = new Intent(MainActivity4.this , MainActivity5.class);

        startActivity(intent);

    }
    @Override
    public void onBackPressed() {

        finishAffinity();
    }
}