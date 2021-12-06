package com.example.myapplication;

import android.graphics.Paint;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.net.IDN;


public class join extends AppCompatActivity {
    private EditText editTextId;
    private EditText editTextPw;
    private EditText editTextName;
    private EditText editTextNick;
    private EditText editTextPhone;
    private Spinner SpinAge;
    private Spinner SpinArea;
    private RadioGroup RGGender;
    private RadioGroup RGAgree;

    private String Id;
    private String Pw;
    private String Name;
    private String Nick;
    private String Age;
    private String Area;
    private String Gender;
    private String Agree;
    private String Phone;
    private AlertDialog dialog;
    boolean validate = false;
    Button check, submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        editTextId = (EditText) findViewById(R.id.editText_id);
        editTextPw = (EditText) findViewById(R.id.editText_pwd);
        editTextName = (EditText) findViewById(R.id.editText_Name);
        editTextNick = (EditText) findViewById(R.id.editText_NICK);
        editTextPhone = (EditText) findViewById(R.id.editText_Phone);
        SpinAge = (Spinner) findViewById(R.id.spinner_age);
        SpinArea = (Spinner) findViewById(R.id.spinner_area);
        RGGender = (RadioGroup) findViewById(R.id.radioGroup_Gender);
        RGAgree = (RadioGroup) findViewById(R.id.radioGroup_agree);
        submit = (Button) findViewById(R.id.button_sub);
        check = (Button) findViewById(R.id.button_chk);



        RGGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int i) {
                RadioButton genderButton = (RadioButton) findViewById(i);
                if(genderButton.getText().toString() == "남자") {
                    Gender = "M";
                }
                else{
                    Gender = "W";
                }

            }
        });


        RGAgree.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int i) {
                RadioButton AgreeButton = (RadioButton) findViewById(i);
                if(AgreeButton.getText().toString() == "예")
                {
                    Agree = "O";
                }
                else
                {
                    Agree =  "X";
                }
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = editTextId.getText().toString();

                if (userID.equals("")) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(join.this);
                        dialog = builder.setMessage("ID is empty")
                                .setPositiveButton("OK", null)
                                .create();
                        dialog.show();
                        return;
                }
                //검증시작


                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {

                        try{
                            Toast.makeText(join.this, response, Toast.LENGTH_LONG).show();

                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){//사용할 수 있는 아이디라면
                                AlertDialog.Builder builder = new AlertDialog.Builder(join.this);
                                dialog = builder.setMessage("you can use ID")
                                        .setPositiveButton("OK", null)
                                        .create();
                                dialog.show();
                                editTextId.setEnabled(false);//아이디값을 바꿀 수 없도록 함
                                validate = true;//검증완료
                            }else{//사용할 수 없는 아이디라면
                                AlertDialog.Builder builder = new AlertDialog.Builder(join.this);
                                dialog = builder.setMessage("alreay used ID")
                                        .setNegativeButton("OK", null)
                                        .create();
                                dialog.show();
                            }

                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                };



                //Volley 라이브러리를 이용해서 실제 서버와 통신을 구현하는 부분
                ValidateRequest validateRequest = new ValidateRequest(userID, responseListener);
                RequestQueue queue = Volley.newRequestQueue(join.this);
                queue.add(validateRequest);
                }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = editTextId.getText().toString();
                String userPw = editTextPw.getText().toString();
                String userName = editTextName.getText().toString();
                String userNick = editTextNick.getText().toString();
                String userAge = SpinAge.getSelectedItem().toString();
                String userArea = SpinArea.getSelectedItem().toString();
                String userPhone = editTextPhone.getText().toString();
                String userGen = Gender;
                String userAgree = Agree;
                if(!validate){
                    AlertDialog.Builder builder = new AlertDialog.Builder(join.this);
                    dialog = builder.setMessage("First Check ID plz")
                            .setNegativeButton("OK", null)
                            .create();
                    dialog.show();
                    return;
                }


                if (userPhone.equals("")|| userId.equals("") || userPw.equals("") || userName.equals("") || userNick.equals("") || userAge.equals("") || userArea.equals("") || Gender.equals("") || Agree.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(join.this);
                    dialog = builder.setMessage("Empty text exist")
                            .setNegativeButton("OK", null)
                            .create();
                    dialog.show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    public void onResponse(String response) {
                        try {
                            Toast.makeText(join.this, response, Toast.LENGTH_LONG).show();
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {//사용할 수 있는 아이디라면
                                AlertDialog.Builder builder = new AlertDialog.Builder(join.this);
                                dialog = builder.setMessage("Register Your ID")
                                        .setPositiveButton("OK", null)
                                        .create();
                                dialog.show();
                                finish();//액티비티를 종료시킴(회원등록 창을 닫음)
                            } else {//사용할 수 없는 아이디라면
                                AlertDialog.Builder builder = new AlertDialog.Builder(join.this);
                                dialog = builder.setMessage("Register fail")
                                        .setNegativeButton("OK", null)
                                        .create();
                                dialog.show();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };//Response.Listener 완료


                RegisterRequest registerRequest = new RegisterRequest(userId, userPw, userName, userNick, userArea, userAge, userPhone, userGen, userAgree, responseListener);
                RequestQueue queue = Volley.newRequestQueue(join.this);
                queue.add(registerRequest);
                finish();
            }

        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }
}




