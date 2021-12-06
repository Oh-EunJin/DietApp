package com.example.myapplication;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ExChoActivity extends AppCompatActivity {

    FloatingActionButton FloClo, FloPlus;
    ExChoFrag exchoFrag;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_cho);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        exchoFrag = new ExChoFrag();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, exchoFrag).commit();
        FloClo = (FloatingActionButton)findViewById(R.id.floatingActionButton);
        FloClo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        FloPlus = (FloatingActionButton)findViewById(R.id.floatingActionButton2);
        FloPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ExChoActivity.this, pop_exercise.class);
                startActivity(i);
            }
        });
    }
}