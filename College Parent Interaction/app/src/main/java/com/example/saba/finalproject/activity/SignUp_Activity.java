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

public class SignUp_Activity extends AppCompatActivity {
Button btn_signup,btn_login;
EditText name,email,phone,pasward;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btn_signup=findViewById(R.id.sign_up);
        btn_login=findViewById(R.id.login_here);
        name=findViewById(R.id.userName);
        email=findViewById(R.id.email);
        pasward=findViewById(R.id.passward);
        phone=findViewById(R.id.phoneno);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_1 = name.getText().toString();
                String str_2 = email.getText().toString();
                String str_3 = pasward.getText().toString();
                String str_4 = phone.getText().toString();
                        if (str_1.equals("")) {
                            name.setError("please enter name!");
                        } else if (str_2.equals("")) {
                            email.setError("please enter email!");
                        }
                        else if (str_3.equals("")) {
                            pasward.setError("please enter passward!");
                        }
                        else if (str_4.equals("")) {
                            phone.setError("please enter phone number!");
                        }

                String url="http://192.168.43.46/FinalYearProject/registerapi.php?action=register&name="+str_1+"&email="+str_2+"&passward="+str_3+"&phone_no="+str_4+"";
                name.setText("");
                email.setText("");
                pasward.setText("");
                phone.setText("");
                final StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {


                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            boolean check=jsonObject.getBoolean("error");
                            if (!check){
                                String success_msg=jsonObject.getString("success_msg");
                                Toast.makeText(getApplicationContext(),success_msg,Toast.LENGTH_LONG).show();
                                Intent intent1;
                                intent1 = new Intent(getApplicationContext(),General_Login_Activity.class);
                                startActivity(intent1);
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
                        Toast.makeText(getApplicationContext(), "register failed", Toast.LENGTH_LONG).show();

                    }



                });
                AppController.getInstance().addToRequestQueue(request);

            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(),General_Login_Activity.class);
                startActivity(intent2);
            }
        });
    }
}
