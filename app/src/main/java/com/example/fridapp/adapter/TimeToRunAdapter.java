package com.example.fridapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fridapp.R;
import com.example.fridapp.helpers.interfaces.TimeToRunSetListener;

public class TimeToRunAdapter extends RecyclerView.Adapter<TimeToRunAdapter.TimeToRunAdapterViewHolder> {

    Context context;
    TimeToRunSetListener timeToRunSetListener;
    int[] times = {20, 30, 40 , 50, 60 , 70, 80, 90};
    int itemSelectedPosition = 1;
    //60000
    int oneMin = 60000;


    public TimeToRunAdapter(Context context, TimeToRunSetListener timeToRunSetListener) {
        this.context = context;
        this.timeToRunSetListener = timeToRunSetListener;

        timeToRunSetListener.timeToRun( (long) times[itemSelectedPosition] * oneMin);

    }




    @NonNull
    @Override
    public TimeToRunAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.time_to_run_item, null, false);
        return new TimeToRunAdapterViewHolder(layoutView);
    }



    @Override
    public void onBindViewHolder(@NonNull final TimeToRunAdapterViewHolder holder, int position) {

        if (itemSelectedPosition == holder.getAdapterPosition()){

            holder.timeToStopLinearLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.custom_background3));
            holder.timeToRunTextView.setTextColor(Color.WHITE);
            holder.minuteTimeTextView.setTextColor(Color.WHITE);

        } else {

            holder.timeToStopLinearLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.custom_background));
            holder.timeToRunTextView.setTextColor(ContextCompat.getColor(context, R.color.buttonColor));
            holder.minuteTimeTextView.setTextColor(ContextCompat.getColor(context,R.color.buttonColor));

        }

        holder.timeToRunTextView.setText(String.valueOf(times[holder.getAdapterPosition()]));

        holder.timeToStopLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemSelectedPosition = holder.getAdapterPosition();
                timeToRunSetListener.timeToRun((long)(times[holder.getAdapterPosition()] * oneMin));
                notifyDataSetChanged();

            }
        });


    }


    @Override
    public int getItemCount() {
        return times.length;
    }



    class TimeToRunAdapterViewHolder extends RecyclerView.ViewHolder{

        LinearLayout timeToStopLinearLayout;
        TextView timeToRunTextView, minuteTimeTextView;

        public TimeToRunAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            timeToStopLinearLayout = itemView.findViewById(R.id.linear_layout_nav_time_to_run_item_nav_run_stopper_screen);
            timeToRunTextView = itemView.findViewById(R.id.time_for_text_view_item_nav_stopper);
            minuteTimeTextView = itemView.findViewById(R.id.minute_time_text_view_item_nav_stopper);

        }

    }
}
