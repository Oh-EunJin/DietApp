package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class foodMainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_main);

        ImageButton imgb1,imgb2,imgb3,imgb4;

        imgb1 = (ImageButton) findViewById(R.id.ibfc1);
        imgb2 = (ImageButton) findViewById(R.id.ibfc2);
        imgb3 = (ImageButton) findViewById(R.id.ibfc3);
        imgb4 = (ImageButton) findViewById(R.id.ibfc4);

        imgb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(foodMainActivity.this,FoChoActivity.class);
                startActivity(intent);
            }
        });
        imgb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(foodMainActivity.this,FoChoActivity.class);
                startActivity(intent);
            }
        });
        imgb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(foodMainActivity.this,FoChoActivity.class);
                startActivity(intent);
            }
        });
        imgb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(foodMainActivity.this,FoChoActivity.class);
                startActivity(intent);
            }
        });

    }

}
