package com.example.fridapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.fridapp.R;

import java.util.List;

public class SpinnerWeekAdapter extends ArrayAdapter<String> {

    private List<String> objects;
    private Context context;


    public SpinnerWeekAdapter(Context context, int resourceId,
                             List<String> objects) {
        super(context, resourceId, objects);
        this.objects = objects;
        this.context = context;
    }


    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }



    public View getCustomView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView =inflater.inflate(R.layout.weekly_spinner_item, parent, false);
        TextView label=(TextView)convertView.findViewById(R.id.weekly_spinner_text_view_weekly_spinner_item);
        label.setText(objects.get(position));

//        if (position == 0) {//Special style for dropdown header
//            label.setTextColor(context.getResources().getColor(R.color.text_hint_color));
//        }

        return convertView;
    }



}
