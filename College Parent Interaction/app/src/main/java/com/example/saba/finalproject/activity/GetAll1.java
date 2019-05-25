package com.example.saba.finalproject.activity;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.saba.finalproject.R;
import com.example.saba.finalproject.adapter.I_Adapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetAll1 extends AppCompatActivity {
    String urladress = "http://192.168.43.46/FinalYearProject/select.php";
    String[] lyear;
    String[] lforms;
    String[] lfees;
    String[] lclasses;
    ListView listView;
    BufferedInputStream is;
    String line = null;
    String result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all1);
        listView = findViewById(R.id.lv_test);
        registerForContextMenu(listView);
        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectData();
        I_Adapter adapter = new I_Adapter(this, lyear, lforms, lfees, lclasses);
        listView.setAdapter(adapter);

    }

    private void collectData() {
        //connection
        try {
            URL url = new URL(urladress);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            is = new BufferedInputStream(con.getInputStream());
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        //connect
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line + "/n");
            }
            is.close();
            result = sb.toString();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        //json
        try {
            JSONArray ja = new JSONArray(result);
            JSONObject jo = null;
            lyear = new String[ja.length()];
            lforms = new String[ja.length()];
            lfees = new String[ja.length()];
            lclasses = new String[ja.length()];
            for (int i = 0; i < ja.length(); i++) {
                jo = ja.getJSONObject(i);
                lyear[i] = jo.getString("year");
                lforms[i] = jo.getString("form_submission_date");
                lfees[i] = jo.getString("fees_submission_date");
                lclasses[i] = jo.getString("classes_start_date");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.contex_menue_inter, menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item
                .getMenuInfo();
        int id = item.getItemId();
        switch (id) {
            case R.id.menue_update:
                Toast.makeText(this, "update", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.menue_delete:

                Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show();


                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }
}
