package com.example.myapplication;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class FoChoActivity extends AppCompatActivity {

    FloatingActionButton FloClo, FloPlus;
    Toolbar toolbar;
    FoChoSearchFrag searchFrag;
    FoChoKoreaFrag koreaFrag;
    FoChoChinaFrag chinaFrag;
    FoChoUsaFrag usaFrag;
    FoChoDessertFrag dessertFrag;
    String[] eat = {"아침", "점심", "저녁","간식"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fo_cho);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //ActionBar actionBar = getSupportActionBar();
        //actionBar.setDisplayShowTitleEnabled(false);
        //actionBar.hide();

        searchFrag = new FoChoSearchFrag();
        koreaFrag = new FoChoKoreaFrag();
        chinaFrag = new FoChoChinaFrag();
        usaFrag = new FoChoUsaFrag();
        dessertFrag = new FoChoDessertFrag();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, koreaFrag).commit();

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("검색"));
        tabs.addTab(tabs.newTab().setText("한식"));
        tabs.addTab(tabs.newTab().setText("중식"));
        tabs.addTab(tabs.newTab().setText("양식"));
        tabs.addTab(tabs.newTab().setText("디저트"));

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int posotion = tab.getPosition();
                Fragment selected = null;
                if(posotion == 0){
                    selected = searchFrag;
                } else if (posotion == 1){
                    selected = koreaFrag;
                } else if (posotion == 2){
                    selected = chinaFrag;
                } else if (posotion == 3){
                    selected = usaFrag;
                } else if (posotion == 4){
                    selected = dessertFrag;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container,selected).commit();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

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
            Intent i = new Intent(FoChoActivity.this, pop_food.class);
            startActivity(i);
            }
        });



        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,eat);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
