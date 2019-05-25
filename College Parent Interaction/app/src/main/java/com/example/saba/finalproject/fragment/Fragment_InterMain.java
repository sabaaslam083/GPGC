package com.example.saba.finalproject.fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.saba.finalproject.R;
import com.example.saba.finalproject.aap.AppController;
import com.example.saba.finalproject.activity.GetAll1;
import com.example.saba.finalproject.activity.GetAllInterActivity;

import org.json.JSONException;
import org.json.JSONObject;


public class Fragment_InterMain extends Fragment {
EditText year,forms,fees,classes;
Button btn_add,btn_view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_inter_main, container, false);
        year=v.findViewById(R.id.edit_year);
        forms=v.findViewById(R.id.edit_forms);
        fees=v.findViewById(R.id.edit_fees);
        classes=v.findViewById(R.id.edit_classes);
        btn_add=v.findViewById(R.id.add);
        btn_view=v.findViewById(R.id.view);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_year=year.getText().toString();
                String str_form=forms.getText().toString();
                String str_fees=fees.getText().toString();
                String str_classes=classes.getText().toString();
                if (str_year.equals("")) {
                    year.setError("please enter Year!");
                } else if (str_form.equals("")) {
                    forms.setError("please enter any date!");
                }
                else if (str_fees.equals("")) {
                    fees.setError("please enter any date!");
                }
                else if (str_classes.equals("")) {
                    classes.setError("please enter classes date!");
                }
                String url = "http://192.168.1.153/FinalYearProject/inter_insertapi.php?action=insert&year="+ str_year +"&form_submission_date="+ str_form +"&fee_submission_date="+ str_fees +"&classes_start_date="+ str_classes;
                year.setText("");
                forms.setText("");
                fees.setText("");
                classes.setText("");
                final StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            boolean check=jsonObject.getBoolean("error");

                            if (!check){
                                String success_msg=jsonObject.getString("success_msg");
                                Toast.makeText(getActivity(),success_msg,Toast.LENGTH_LONG).show();

                            }
                            else{
                                String error_msg=jsonObject.getString("error_msg");
                                Toast.makeText(getActivity(),error_msg,Toast.LENGTH_LONG).show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), "Insertion failed", Toast.LENGTH_LONG).show();

                    }


                });
                AppController.getInstance().addToRequestQueue(request);
            }
        });
        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"toast",Toast.LENGTH_LONG).show();
         Intent intent;
                intent = new Intent(getActivity(),GetAll1.class);
                startActivity(intent);

            }
        });


        return v;


            }


    }


