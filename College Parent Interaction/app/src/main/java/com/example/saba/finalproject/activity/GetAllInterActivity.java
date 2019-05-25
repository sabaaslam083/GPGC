package com.example.saba.finalproject.activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.saba.finalproject.R;
import com.example.saba.finalproject.adapter.InterAdapter;
import com.example.saba.finalproject.model.IntermediateModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
public class GetAllInterActivity extends AppCompatActivity {
    private static final String URL_Inter = "http://192.168.8.101/FinalYearProject/inter_fetch.php";
    List<IntermediateModel> interList;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all_inter);
        recyclerView = findViewById(R.id.r_v);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        interList = new ArrayList<>();

        loadInter();
    }
    private void loadInter() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_Inter,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);

                            for (int i = 0; i < array.length(); i++) {
                                JSONObject inter = array.getJSONObject(i);

                                interList.add(new IntermediateModel(
                                        inter.getInt("id"),
                                        inter.getString("year"),
                                        inter.getString("forms_date"),
                                        inter.getString("fees_date"),
                                        inter.getString("classes_date")
                                ));
                            }
                          InterAdapter  adapter=new InterAdapter(GetAllInterActivity.this,interList);
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        Volley.newRequestQueue(this).add(stringRequest);
    }

}