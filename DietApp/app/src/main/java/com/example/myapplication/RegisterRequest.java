package com.example.myapplication;

import android.util.Log;

import java.lang.reflect.Method;
import java.net.ResponseCache;
import java.util.HashMap;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;


import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kch on 2018. 5. 14..
 */

public class RegisterRequest extends StringRequest {

    final static private String URL = "http://team0816.dothome.co.kr/join.php/";
    private Map<String, String> parameters;

    public RegisterRequest(String userID, String userPwd, String userName, String userNick, String userArea, String userAge , String userPhone,  String userGen,  String userAgree, Response.Listener<String> listener)
    {
        super(Method.POST, URL, listener, null);//해당 URL에 POST방식으로 파마미터들을 전송함
        parameters = new HashMap<>();
        parameters.put("uId", userID);
        parameters.put("uPwd", userPwd);
        parameters.put("uName", userName);
        parameters.put("uNick", userNick);
        parameters.put("uArea", userArea);
        parameters.put("uAge", userAge);
        parameters.put("uPhone", userPhone);
        parameters.put("uGender", userGen);
        parameters.put("uAgree", userAgree);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return parameters;
    }
}
