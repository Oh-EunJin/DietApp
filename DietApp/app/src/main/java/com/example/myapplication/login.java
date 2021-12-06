package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class login extends AppCompatActivity {
    EditText etID, etPWD;
    AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void buttonjoin(View view){
        startActivity(new Intent(getApplicationContext(),join.class));
    }

    public void buttonmain(View view){
        etID = (EditText) findViewById(R.id.idText);
        etPWD = (EditText) findViewById(R.id.pwText);

        String ID = etID.getText().toString();
        String Pwd = etPWD.getText().toString();

        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{

                    JSONObject jsonResponse = new JSONObject(response);

                    boolean success = jsonResponse.getBoolean("success");


                    if(success){

                        AlertDialog.Builder builder = new AlertDialog.Builder(login.this);

                        dialog = builder.setMessage("로그인에 성공했습니다")

                                .setPositiveButton("확인", null)

                                .create();

                        dialog.show();

                        Intent intent = new Intent(login.this, MainActivity.class);

                        login.this.startActivity(intent);

                        finish();

                    }else {

                        AlertDialog.Builder builder = new AlertDialog.Builder(login.this);

                        dialog = builder.setMessage("계정을 다시 확인하세요")

                                .setNegativeButton("다시시도", null)

                                .create();

                        dialog.show();

                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        LoginRequest loginRequest = new LoginRequest(ID, Pwd, listener);

        RequestQueue queue = Volley.newRequestQueue(login.this);

        queue.add(loginRequest);
    }
}
