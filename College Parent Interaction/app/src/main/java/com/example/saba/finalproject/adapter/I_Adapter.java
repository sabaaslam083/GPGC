package com.example.saba.finalproject.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.saba.finalproject.R;

public class I_Adapter extends ArrayAdapter<String> {
    private String[] year;
    private String[] forms;
    private String[] fees;
    private String[] classes;
    private Activity context;
    public I_Adapter(Activity context, String[] year, String[] forms, String[] fees, String[] classes ) {
        super(context, R.layout.item,year);
        this.context=context;
        this.year=year;
        this.forms=forms;
        this.fees=fees;
        this.classes=classes;
    }
    @Nullable
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent){
        View r=convertView;
        ViewHolder viewHolder=null;
        if(r==null){
            LayoutInflater layoutInflaterl=context.getLayoutInflater();
            r=layoutInflaterl.inflate(R.layout.item,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }
else{
            viewHolder=(ViewHolder)r.getTag();
        }
     viewHolder.tv1.setText(year[position]);
        viewHolder.tv2.setText(forms[position]);
        viewHolder.tv3.setText(fees[position]);
        viewHolder.tv4.setText(classes[position]);
        return r;
    }
    class ViewHolder{
        TextView tv1,tv2,tv3,tv4;
        ViewHolder(View v){
            tv1=v.findViewById(R.id.edit_year);
            tv2=v.findViewById(R.id.edit_forms);
            tv3=v.findViewById(R.id.edit_fees);
            tv4=v.findViewById(R.id.edit_classes);
        }

    }

}
