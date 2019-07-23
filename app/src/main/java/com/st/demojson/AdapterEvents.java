package com.st.demojson;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class AdapterEvents extends BaseAdapter {
    private List<events> listProduct;
    private Activity activity;

    public AdapterEvents(Activity activity,List<events> listProduct ) {
        super();
        this.listProduct = listProduct;
        this.activity = activity;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        Log.i("poipoi", "AdapterDayStasdf: "+listProduct.size());
        return listProduct.size();
    }

    @Override
    public String getItem(int position) {
        // TODO Auto-generated method stub
        return listProduct.get(position).getName();
    }



    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public static class ViewHolder
    {

        public TextView name;
        public TextView isActiv;
    }

    @SuppressLint("DefaultLocale")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder view;
        LayoutInflater inflator = activity.getLayoutInflater();
        if(convertView==null)
        {
            view = new ViewHolder();
            convertView = inflator.inflate(R.layout.row, null);
            view.name = convertView.findViewById(R.id.textView);


            view.isActiv = convertView.findViewById(R.id.textView2);

            // view.txtResult = (TextView) convertView.findViewById(R.id.textView323);
            convertView.setTag(view);
        }else
        {
            view = (ViewHolder) convertView.getTag();
        }

        view.name.setText(String.format("%s. %s", listProduct.get(position).getId(), listProduct.get(position).getName()));
        view.isActiv.setText(String.format("%s", listProduct.get(position).isActive()));
        return convertView;
    }




}