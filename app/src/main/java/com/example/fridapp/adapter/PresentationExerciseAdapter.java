package com.example.fridapp.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fridapp.R;
import com.example.fridapp.helpers.UserProgressHelper;

public class PresentationExerciseAdapter extends RecyclerView.Adapter<PresentationExerciseAdapter.PresentationExerciseViewHolder> {


    Context context;
    UserProgressHelper userProgressHelper;




    public PresentationExerciseAdapter(Context context, UserProgressHelper userProgressHelper) {
        this.context = context;
        this.userProgressHelper = userProgressHelper;
    }


    @NonNull
    @Override
    public PresentationExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.presentation_exercise_item, null, false);
        PresentationExerciseViewHolder holder = new PresentationExerciseViewHolder(layoutView);

        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull final PresentationExerciseViewHolder holder, int position) {


        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                holder.presentationExerciseTextViewItem.setText(context.getString(userProgressHelper.getExerciseFullSetByIndex().get(1)[holder.getAdapterPosition()]));
                holder.numOfRehearsalsTextView.setText(userProgressHelper.getExerciseFullSetByIndex().get(3)[holder.getAdapterPosition()] + getDescriptionFromKing(userProgressHelper.getExerciseFullSetByIndex().get(4)[holder.getAdapterPosition()]));

                String stringToParse = "android.resource://"+context.getApplicationContext().getPackageName()+"/" + userProgressHelper.getExerciseFullSetByIndex().get(0)[holder.getAdapterPosition()];

                Uri uri = Uri.parse(stringToParse);


                holder.presentationExerciseVideoViewItem.setVideoURI(uri);
                holder.presentationExerciseVideoViewItem.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.setLooping(true);
                        holder.presentationExerciseVideoViewItem.animate().setDuration(1000).alpha(1.0f);
                        holder.presentationExerciseVideoViewItem.start();
                        holder.videoProgressBar.setVisibility(View.GONE);
//                        setHasStableIds(true);

                    }
                });

            }
        };

        runnable.run();

    }



    private String getDescriptionFromKing(int kind) {

        String description = "";

        switch (kind){


            case 1:

                description = " - חזרות";
                break;


            case 2:

                description = " - שניות";
                break;


            case 3:

                description = " - כל צד";
                break;


            case 4:


                description = " - ניעות";
                break;


            case 5:


                description = " - שניות כל צד";
                break;



            case 6:

                description = " - ניעות כל צד";
                break;


        }

        return description;
    }




    @Override
    public int getItemCount() {
        return userProgressHelper.getExerciseFullSetByIndex().get(0).length;
    }



    class PresentationExerciseViewHolder extends RecyclerView.ViewHolder{

        TextView presentationExerciseTextViewItem, numOfRehearsalsTextView;
        VideoView presentationExerciseVideoViewItem;
        LinearLayout presentationLinearLayoutItem;
        ProgressBar videoProgressBar;

        public PresentationExerciseViewHolder(@NonNull View itemView) {
            super(itemView);

            presentationExerciseTextViewItem = itemView.findViewById(R.id.presentation_exercise_name_text_view_item);
            presentationExerciseVideoViewItem = itemView.findViewById(R.id.presentation_exercise_video_item);
            numOfRehearsalsTextView = itemView.findViewById(R.id.number_of_rehearsals_text_view_presentation_exercise_item);
            presentationLinearLayoutItem = itemView.findViewById(R.id.presentation_exercise_item_linear_layout);
            videoProgressBar = itemView.findViewById(R.id.video_progress_bar_presentation_exercise_item);


        }
    }
}
