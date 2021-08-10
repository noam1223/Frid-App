package com.example.fridapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fridapp.R;
import com.example.fridapp.activities.fragments.exrcise.ActivitySetFragment;
import com.example.fridapp.activities.fragments.exrcise.RunStopperScreenFragment;
import com.example.fridapp.activities.fragments.exrcise.SetsOfExerciseFragment;
import com.example.fridapp.activities.fragments.home.HomeFragment;
import com.example.fridapp.helpers.ExerciseEnumHelper;
import com.example.fridapp.helpers.ExerciseNumbersByWeek;
import com.example.fridapp.helpers.UserProgressHelper;
import com.example.fridapp.helpers.interfaces.FragmentListener;
import com.example.fridapp.helpers.singleton.UserSingleton;
import com.example.fridapp.model.SetsOfToday;
import com.example.fridapp.model.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ExerciseTrainingAdapter extends RecyclerView.Adapter<ExerciseTrainingAdapter.ExerciseTrainingViewHolder> {

    Context context;
    User user;
    FragmentListener fragmentListener;
    ArrayList<SetsOfToday> setsOfToday;
    String headLineNameText;
    UserProgressHelper userProgressHelper;
    boolean fitSuggest = false, showIconCheck;
    int week = -1;



    public ExerciseTrainingAdapter(Context context,  User user, FragmentListener fragmentListener,
                                   ArrayList<SetsOfToday> setsOfToday, UserProgressHelper userProgressHelper , boolean fitSuggest,
                                   int week) {

        this.context = context;
        this.user = user;
        this.fragmentListener = fragmentListener;
        this.setsOfToday = setsOfToday;
        this.userProgressHelper = userProgressHelper;
        this.fitSuggest = fitSuggest;
        this.week = week;


        if (this.fragmentListener instanceof HomeFragment){
            showIconCheck = false;
        }else showIconCheck = true;


    }



    @NonNull
    @Override
    public ExerciseTrainingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercise_training_item, null, false);
        return new ExerciseTrainingViewHolder(layoutView);
    }



    @Override
    public void onBindViewHolder(@NonNull final ExerciseTrainingViewHolder holder, int position) {

        if (fitSuggest){

            holder.dayExerciseRecommendedTextView.setVisibility(View.VISIBLE);
            holder.dayExerciseRecommendedTextView.setText("יום " + setsOfToday.get(holder.getAdapterPosition()).getDay());
            holder.numberOfExerciseTextView.setVisibility(View.GONE);
            holder.sumNumberOfExercisesTextView.setVisibility(View.INVISIBLE);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) holder.markerSlicedView.getLayoutParams();
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            holder.bottomLineView.setVisibility(View.INVISIBLE);

        }



        boolean setIcon = false;



        if (showIconCheck) {

            holder.bottomLineView.setVisibility(View.INVISIBLE);

            if (user.getTotalSetsHadDone().size() > week){

                for (int i = 0; i < user.getTotalSetsHadDone().get(week).size(); i++) {

                    if (user.getTotalSetsHadDone().get(week).get(i).getNumSet() == setsOfToday.get(position).getNumSet()
                            && user.getTotalSetsHadDone().get(week).get(i).getExerciseEnumHelper() == setsOfToday.get(position).getExerciseEnumHelper()) {
                        setIcon = true;
                    }

                }

            }else {

                for (int i = 0; i < user.getSetHaveDoneByWeek().size(); i++) {

                    if (user.getSetHaveDoneByWeek().get(i).getNumSet() == setsOfToday.get(position).getNumSet()
                            && user.getSetHaveDoneByWeek().get(i).getExerciseEnumHelper() == setsOfToday.get(position).getExerciseEnumHelper()) {
                        setIcon = true;
                    }

                }


            }

        } else holder.bottomLineView.setLayoutParams(new RelativeLayout.LayoutParams(holder.filedToColorLinearLayout.getLayoutParams().width, holder.bottomLineView.getLayoutParams().height));




        if (setIcon)
            holder.iconCheckImgView.setVisibility(View.VISIBLE);
        else holder.iconCheckImgView.setVisibility(View.GONE);


        switch (setsOfToday.get(holder.getAdapterPosition()).getExerciseEnumHelper()){

            case AEROBIC:

                headLineNameText = context.getString(R.string.FULLBODY_HEB);
                holder.sumNumberOfExercisesTextView.setText("/2");
                holder.numberOfExerciseTextView.setText(setsOfToday.get(holder.getAdapterPosition()).getNumSet() + "");
                holder.markerSlicedView.setBackground(ContextCompat.getDrawable(context, R.drawable.ic_view_pink));
//                holder.exerciseTrainingLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                holder.typeNameOfExerciseTextView.setText(context.getString(R.string.AEROBIC_HEB));
                holder.typeNameOfExerciseTextView.setTextColor(Color.WHITE);
                holder.typeBodyNameOfExerciseTextView.setText(context.getString(R.string.AEROBIC_TYPES_OF_EXERCISES_HEB));
                holder.typeBodyNameOfExerciseTextView.setTextColor(Color.WHITE);
                holder.filedToColorLinearLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.image_view_background_aerobic));
//                holder.subParentRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(holder.subParentRelativeLayout.getLayoutParams().width, holder.subParentRelativeLayout.getLayoutParams().height - 30));
                holder.exerciseImageView.setVisibility(View.INVISIBLE);
                holder.iconCheckImgView.setColorFilter(Color.WHITE);

                break;



            case FLEXIBILITY:

                headLineNameText = context.getString(R.string.FULLBODY_HEB);
                holder.sumNumberOfExercisesTextView.setText("/2");
                holder.numberOfExerciseTextView.setText(setsOfToday.get(holder.getAdapterPosition()).getNumSet() + "");
//                holder.markerSlicedView.setBackgroundColor(context.getResources().getColor(R.color.flexibilityColor));
                holder.markerSlicedView.setBackground(ContextCompat.getDrawable(context, R.drawable.ic_view_blue));
                holder.typeNameOfExerciseTextView.setText(context.getString(R.string.FLEXIBILITY_HEB));
                holder.typeBodyNameOfExerciseTextView.setText(context.getString(R.string.FULLBODY_HEB));
//                holder.exerciseImageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.flexibilityimage));
//                Picasso.get().load(R.drawable.flexibilityimage).noFade().into(holder.exerciseImageView);
                holder.exerciseImageView.setImageResource(R.drawable.flexibilityimage);

                break;




            case HANDS:

                holder.sumNumberOfExercisesTextView.setText("/3");
                holder.numberOfExerciseTextView.setText(setsOfToday.get(holder.getAdapterPosition()).getNumSet() + "");
                holder.markerSlicedView.setBackground(ContextCompat.getDrawable(context, R.drawable.ic_view_orange));
                holder.typeNameOfExerciseTextView.setText(context.getString(R.string.STRENGTH_HEB));
                headLineNameText = context.getString(R.string.HAND_HEB);
                holder.typeBodyNameOfExerciseTextView.setText(headLineNameText);
                Picasso.get().load(R.drawable.handsstrengthimage).into(holder.exerciseImageView);

//                holder.exerciseImageView.setImageDrawable(ContextCompat.getDrawable(context ,R.drawable.handsstrengthimage));

                break;


            case FULLBODY:

                holder.sumNumberOfExercisesTextView.setText("/3");
                holder.numberOfExerciseTextView.setText(setsOfToday.get(holder.getAdapterPosition()).getNumSet() + "");
                holder.markerSlicedView.setBackground(ContextCompat.getDrawable(context, R.drawable.ic_view_orange));
                holder.typeNameOfExerciseTextView.setText(context.getString(R.string.STRENGTH_HEB));
                headLineNameText = context.getString(R.string.FULLBODY_HEB);
                holder.typeBodyNameOfExerciseTextView.setText(headLineNameText);
                Picasso.get().load(R.drawable.fullbodystrengthimage).into(holder.exerciseImageView);
//                holder.exerciseImageView.setImageDrawable(ContextCompat.getDrawable(context ,R.drawable.fullbodystrengthimage));

                break;



            case LEGS:


                holder.sumNumberOfExercisesTextView.setText("/3");
                holder.numberOfExerciseTextView.setText(setsOfToday.get(holder.getAdapterPosition()).getNumSet() + "");
                holder.markerSlicedView.setBackground(ContextCompat.getDrawable(context, R.drawable.ic_view_orange));

                holder.typeNameOfExerciseTextView.setText(context.getString(R.string.STRENGTH_HEB));
                headLineNameText = context.getString(R.string.LEGS_HEB);
                holder.typeBodyNameOfExerciseTextView.setText(headLineNameText);
                Picasso.get().load(R.drawable.legsstrengthimage).into(holder.exerciseImageView);
//                holder.exerciseImageView.setImageDrawable(ContextCompat.getDrawable(context ,R.drawable.legsstrengthimage));

                break;





        }



        holder.exerciseTrainingLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment;
                Bundle bundle = new Bundle();
                userProgressHelper.setWeek(week);
                bundle.putInt("week", week);
                ExerciseNumbersByWeek exerciseNumbersByWeek = new ExerciseNumbersByWeek();


                switch (setsOfToday.get(holder.getAdapterPosition()).getExerciseEnumHelper()) {


                    case AEROBIC:

                        fragment = new RunStopperScreenFragment();


                        userProgressHelper.setExerciseEnumHelper(setsOfToday.get(holder.getAdapterPosition()).getExerciseEnumHelper());
                        userProgressHelper.setExeTypeHeb(context.getString(R.string.AEROBIC_HEB));
                        userProgressHelper.setExerciseTypePath(context.getString(R.string.AEROBIC_PATH));
                        userProgressHelper.setExeNumOfActivitySet(setsOfToday.get(holder.getAdapterPosition()).getNumSet() + "/2");

                        if (!showIconCheck)
                            userProgressHelper.setExerciseSetTobeSave(setsOfToday.get(holder.getAdapterPosition()));
                        else userProgressHelper.setExerciseSetTobeSave(null);

                        userProgressHelper.setExeSubStrengthHeb(context.getString(R.string.FULLBODY_HEB));
                        bundle.putSerializable("myObj", user);
                        bundle.putString("headLine", headLineNameText);
                        bundle.putSerializable("list", userProgressHelper);

                        fragment.setArguments(bundle);
                        fragmentListener.onTransactionFragmentListener(fragment);
                        break;


                    case FLEXIBILITY:

                        fragment = new ActivitySetFragment();

                        userProgressHelper.setExerciseEnumHelper(setsOfToday.get(holder.getAdapterPosition()).getExerciseEnumHelper());
                        userProgressHelper.setExerciseFullSet_1(exerciseNumbersByWeek.getListFlexibility());
                        userProgressHelper.setIndexSet(0);
                        userProgressHelper.setExeTypeHeb(context.getString(R.string.FLEXIBILITY_HEB));
                        userProgressHelper.setExeNumOfActivitySet(setsOfToday.get(holder.getAdapterPosition()).getNumSet() + "/2");
                        userProgressHelper.setExerciseTypePath(context.getString(R.string.FLEXIBILITY_PATH));

                        if (!showIconCheck)
                            userProgressHelper.setExerciseSetTobeSave(setsOfToday.get(holder.getAdapterPosition()));
                        else userProgressHelper.setExerciseSetTobeSave(null);

                        userProgressHelper.setExeSubStrengthHeb(context.getString(R.string.FULLBODY_HEB));
                        bundle.putSerializable("myObj", user);
                        bundle.putString("headLine", headLineNameText);
                        bundle.putSerializable("list", userProgressHelper);
                        fragment.setArguments(bundle);
                        fragmentListener.onTransactionFragmentListener(fragment);
                        break;


                        default:

                            fragment = new SetsOfExerciseFragment();
                            userProgressHelper.setExerciseEnumHelper(setsOfToday.get(holder.getAdapterPosition()).getExerciseEnumHelper());
                            userProgressHelper.setExeTypeHeb(context.getString(R.string.STRENGTH_HEB));
                            userProgressHelper.setExerciseTypePath(context.getString(R.string.STRENGTH_PATH));

                            if (!showIconCheck)
                                userProgressHelper.setExerciseSetTobeSave(setsOfToday.get(holder.getAdapterPosition()));
                            else userProgressHelper.setExerciseSetTobeSave(null);

                            userProgressHelper.setExeNumOfActivitySet(setsOfToday.get(holder.getAdapterPosition()).getNumSet() + "/3");

                            List<List<int[]>> lists;


                            if (setsOfToday.get(holder.getAdapterPosition()).getExerciseEnumHelper() == ExerciseEnumHelper.HANDS){

                                userProgressHelper.setExeSubStrengthHeb(context.getString(R.string.HAND_HEB));
                                userProgressHelper.setExeSubStrengthPath(context.getString(R.string.HANDS_PATH));
                                userProgressHelper.setExercises_items(exerciseNumbersByWeek.getExerciseItemHandsListByWeek(week));
                                lists = exerciseNumbersByWeek.getListHandsByWeek(week);



                            } else if(setsOfToday.get(holder.getAdapterPosition()).getExerciseEnumHelper() == ExerciseEnumHelper.LEGS){

                                userProgressHelper.setExeSubStrengthHeb(context.getString(R.string.LEGS_HEB));
                                userProgressHelper.setExeSubStrengthPath(context.getString(R.string.LEGS_PATH));
                                userProgressHelper.setExercises_items(exerciseNumbersByWeek.getExerciseItemLegsListByWeek(week));

                                lists = exerciseNumbersByWeek.getListLegsByWeek(week);



                            }else {

                                userProgressHelper.setExeSubStrengthHeb(context.getString(R.string.FULLBODY_HEB));
                                userProgressHelper.setExeSubStrengthPath(context.getString(R.string.FULL_BODY_PATH));
                                userProgressHelper.setExercises_items(exerciseNumbersByWeek.getExerciseItemFullBodyListByWeek(week));
                                lists = exerciseNumbersByWeek.getListFullBodyByWeek(week);

                            }

                            userProgressHelper.setExerciseFullSet_1(lists.get(0));
                            userProgressHelper.setExerciseFullSet_2(lists.get(1));
                            userProgressHelper.setExerciseFullSet_3(lists.get(2));



                            bundle.putSerializable("myObj", user);
                            bundle.putSerializable("sets", setsOfToday.get(holder.getAdapterPosition()));
                            bundle.putString("headLine", headLineNameText);

                            bundle.putSerializable("list", userProgressHelper);


                            fragment.setArguments(bundle);
                            fragmentListener.onTransactionFragmentListener(fragment);
                            break;

                }

                UserSingleton.getInstance().getUser().setExercise(true);
            }
        });

    }


    @Override
    public int getItemCount() {
        return setsOfToday.size();
    }


    class ExerciseTrainingViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout exerciseTrainingLinearLayout;
        RelativeLayout filedToColorLinearLayout;
        RelativeLayout subParentRelativeLayout;


        TextView numberOfExerciseTextView, typeNameOfExerciseTextView, typeBodyNameOfExerciseTextView, dayExerciseRecommendedTextView, sumNumberOfExercisesTextView;
        View markerSlicedView, bottomLineView;

        ImageView exerciseImageView, iconCheckImgView;

        public ExerciseTrainingViewHolder(@NonNull View itemView) {
            super(itemView);

            exerciseTrainingLinearLayout = itemView.findViewById(R.id.relative_layout_pictures_user_item);
            filedToColorLinearLayout = itemView.findViewById(R.id.linear_layout_types_text_views_exercise_training_item);
            subParentRelativeLayout = itemView.findViewById(R.id.relative_layout_parent_exercise_training_item);
            dayExerciseRecommendedTextView = itemView.findViewById(R.id.day_fit_recommended_by_fit_nav_exercise_training);
            numberOfExerciseTextView = itemView.findViewById(R.id.number_of_exercise_training_item);
            sumNumberOfExercisesTextView = itemView.findViewById(R.id.sum_number_of_exercise_training_item);
            typeNameOfExerciseTextView = itemView.findViewById(R.id.type_name_of_exercise_training_item);
            typeBodyNameOfExerciseTextView = itemView.findViewById(R.id.type_body_name_of_exercise_training_item);
            exerciseImageView = itemView.findViewById(R.id.image_exercise_training_item);
            markerSlicedView = itemView.findViewById(R.id.view_background_horizontal_exercise_training_item);
            iconCheckImgView = itemView.findViewById(R.id.check_icon_img_view_exercise_training_item);
            bottomLineView = itemView.findViewById(R.id.view_bottom_line_exercise_training_item);
        }
    }

}
