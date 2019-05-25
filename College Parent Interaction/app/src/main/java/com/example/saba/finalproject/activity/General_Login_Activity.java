package com.example.saba.finalproject.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.saba.finalproject.R;
import com.example.saba.finalproject.aap.AppController;

import org.json.JSONException;
import org.json.JSONObject;

public class General_Login_Activity extends AppCompatActivity {
Button btn_login;
EditText name,passward;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        name=findViewById(R.id.userName);
        passward=findViewById(R.id.passward);
        btn_login=findViewById(R.id.g_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_1 = name.getText().toString();
                String str_2 = passward.getText().toString();
                        if (str_1.equals("")) {
                            name.setError("please enter valid name!!");
                        } else if (str_2.equals("")) {
                            passward.setError("please enter a valid passward!");
                        }
                        String url = "http://192.168.43.46/FinalYearProject/login_g_api.php?action=login&name="+str_1+"&passward="+str_2+"";
                        final StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonObject=new JSONObject(response);
                                    boolean check=jsonObject.getBoolean("error");
                                    if (!check){
                                        String success_msg=jsonObject.getString("success_msg");
                                        Toast.makeText(getApplicationContext(),success_msg,Toast.LENGTH_LONG).show();
                                        Intent intent=new Intent(General_Login_Activity.this,Admission_Activity.class);
                                        startActivity(intent);
                                    }
                                    else{
                                        String error_msg=jsonObject.getString("error_msg");
                                        Toast.makeText(getApplicationContext(),error_msg,Toast.LENGTH_LONG).show();

                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), "login failed", Toast.LENGTH_LONG).show();

                            }


                        });
                        AppController.getInstance().addToRequestQueue(request);

            }
        });
    }
}
