package com.example.fridapp.activities.fragments.exrcise;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.fridapp.R;
import com.example.fridapp.activities.FinishExerciseActivity;
import com.example.fridapp.activities.FinishFullExerciseActivity;
import com.example.fridapp.activities.FinishSetActivity;
import com.example.fridapp.activities.HomePageActivity;
import com.example.fridapp.activities.fragments.home.HomeFragment;
import com.example.fridapp.helpers.ExerciseEnumHelper;
import com.example.fridapp.helpers.UserProgressHelper;
import com.example.fridapp.model.SetsOfToday;
import com.example.fridapp.model.User;

import java.util.Calendar;

public class ActivitySetFragment extends Fragment implements View.OnClickListener {


    private TextView numWeekFromSignedTextView, typeOfExerciseTextView, bodyPartExerciseTextView, nameOfExerciseTextView, numberOfRepetitionTextView, timerOfSetTextView;
    private TextView nameOfNextExerciseTextView, descriptionOfExerciseTextView, subHeadSumExerciseTextView, subHeadNumExerciseTextView, nameNumberOfExerciseTextView, kindOfRepetitionTextView, numberNumberOfExerciseTextView;
    private ProgressBar progressBarTime;
    private VideoView exerciseVideoView;
    private LinearLayout repeatationLinearLayoutArea, descriptionAreaLinearLayout;
    private RelativeLayout parentRelativeLayoutActivitySetFragment;
    private ProgressBar videoWaitingProgressBar;

    private ImageButton skipBackwardsImgBtn, skipForwardsImgBtn, pauseImgBtn;

    private ImageButton showExplanationImgBtn;

    ScrollView activitySetScrollView;

    SetsOfToday setsOfToday = new SetsOfToday();
    int videoIndex = 0;

    CountDownTimer countDownTimer;

    long timeOfStopper = 480000, timeStopperSave = 0;

    User user;
    UserProgressHelper userProgressHelper;
    ValueAnimator valueAnimator;

    boolean explanationClicked = false;
    boolean isExercise = true;


    @Override
    public void onDestroy() {

        if (countDownTimer != null){
            countDownTimer.cancel();
        }

        if (exerciseVideoView.isPlaying()){
            exerciseVideoView.stopPlayback();
            exerciseVideoView.suspend();
        }

        super.onDestroy();

    }




    @Override
    public void onResume() {
        super.onResume();
        requireView().setFocusableInTouchMode(true);
        requireView().requestFocus();
        requireView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {

                if (keyEvent.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {

                    stopExerciseUserAction();
                    showExitExerciseDialog();

                    return true;
                }


                return false;
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity_set, container, false);


        numWeekFromSignedTextView = view.findViewById(R.id.num_of_weeks_text_view_van_activity_set);
        subHeadSumExerciseTextView = view.findViewById(R.id.sum_of_set_text_view_nav_activity_set);
        subHeadNumExerciseTextView = view.findViewById(R.id.num_of_set_text_view_nav_activity_set);
        kindOfRepetitionTextView = view.findViewById(R.id.kind_of_repetition_text_view_nav_activity_set);
        nameNumberOfExerciseTextView = view.findViewById(R.id.name_of_exercise_set_text_view_nav_activity_set);
        numberNumberOfExerciseTextView = view.findViewById(R.id.number_of_exercise_set_text_view_nav_activity_set);
        typeOfExerciseTextView = view.findViewById(R.id.type_of_exercise_nav_activity_set);
        bodyPartExerciseTextView = view.findViewById(R.id.name_part_body_type_of_exercise_nav_activity_set);
        nameOfExerciseTextView = view.findViewById(R.id.name_of_exercise_weeks_text_view_nav_activity_set);
        numberOfRepetitionTextView = view.findViewById(R.id.number_of_repetition_text_view_nav_activity_set);
        timerOfSetTextView = view.findViewById(R.id.timer_of_exercise_text_view_nav_activity_set);
        showExplanationImgBtn = view.findViewById(R.id.show_explanation_exercise_image_btn_activity_set);
        activitySetScrollView = view.findViewById(R.id.scroll_view_nav_activity_set);
        activitySetScrollView.setSmoothScrollingEnabled(true);
        nameOfNextExerciseTextView = view.findViewById(R.id.next_exercise_name_text_view_nav_activity_set);
        descriptionOfExerciseTextView = view.findViewById(R.id.description_of_exercise_set_text_view_activity_set);
        repeatationLinearLayoutArea = view.findViewById(R.id.linear_layout_num_of_repetition_nav_activity_set);
        parentRelativeLayoutActivitySetFragment = view.findViewById(R.id.parent_relative_layout_activity_set_fragment);
//        backBtn = view.findViewById(R.id.back_fragment_btn_nav_activity_set);
        videoWaitingProgressBar = view.findViewById(R.id.video_progress_bar_nav_activity_set);


        descriptionAreaLinearLayout = view.findViewById(R.id.linear_layout_area_text_explanation_exercise_activity_set);
        descriptionAreaLinearLayout.setOnClickListener(this);

        exerciseVideoView = view.findViewById(R.id.video_view_exercise_nav_activity_set);

        skipBackwardsImgBtn = view.findViewById(R.id.skip_backward_img_btn_nav_activity_set);
        skipForwardsImgBtn = view.findViewById(R.id.skip_forward_img_btn_nav_activity_set);
        pauseImgBtn = view.findViewById(R.id.pause_img_btn_nav_activity_set);


        progressBarTime = view.findViewById(R.id.timer_progress_bar_nav_activity_set);


        skipBackwardsImgBtn.setOnClickListener(this);
        skipForwardsImgBtn.setOnClickListener(this);
        pauseImgBtn.setOnClickListener(this);
        showExplanationImgBtn.setOnClickListener(this);


        updateActivitySetFragmentUI(getArguments());

        return view;

    }



    private void updateActivitySetFragmentUI(Bundle bundle) {
        if (bundle != null) {

            progressBarTime.setProgress(0);
            progressBarTime.setMax((int) timeOfStopper);

            user = (User) bundle.getSerializable("myObj");
            userProgressHelper = (UserProgressHelper) bundle.getSerializable("list");
            setsOfToday = (SetsOfToday) bundle.getSerializable("sets");


            //SAVE CURRENT EXERCISE
            user.getSetsOfToday_24h().add(userProgressHelper.getSetsInProgressToday());


            //WORKING ON DATA FOR PRODUCING TO USER (UI)

            int week = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR) - user.getWeekOfSigned() + 1;

            numWeekFromSignedTextView.setText("שבוע " + week);
            typeOfExerciseTextView.setText(userProgressHelper.getExeTypeHeb());

            String numExerciseString = userProgressHelper.getExeNumOfActivitySet();

            if (numExerciseString != null && !numExerciseString.isEmpty()) {

                String[] splitNum = numExerciseString.split("/");

                subHeadSumExerciseTextView.setText("/" + splitNum[1]);
                subHeadNumExerciseTextView.setText(splitNum[0]);

            } else {
                subHeadSumExerciseTextView.setVisibility(View.GONE);
                subHeadNumExerciseTextView.setVisibility(View.GONE);

                typeOfExerciseTextView.setGravity(Gravity.CENTER);
                typeOfExerciseTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            }


            bodyPartExerciseTextView.setText(userProgressHelper.getExeSubStrengthHeb());

            if (userProgressHelper.getExerciseEnumHelper() == ExerciseEnumHelper.FLEXIBILITY) {

                skipBackwardsImgBtn.setEnabled(false);
                bodyPartExerciseTextView.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.custom_background_blue));
                pauseImgBtn.getBackground().setTint(ContextCompat.getColor(requireContext(), R.color.greyBackgroundScreenColor2));

                nameNumberOfExerciseTextView.setVisibility(View.INVISIBLE);
                repeatationLinearLayoutArea.setVisibility(View.GONE);

            }

            int videoIndexClone = (videoIndex + 1);
            numberNumberOfExerciseTextView.setText(videoIndexClone + "/" + userProgressHelper.getExerciseFullSetByIndex().get(0).length);

            moveAnotherVideo();
            startStopper(timeOfStopper);
            animateProgress(progressBarTime, progressBarTime.getMax(), progressBarTime.getProgress());

        }
    }



    private String getHebrewSetText(int userIndexSet) {

        if (userIndexSet == 0) {
            return "סט א׳";
        } else if (userIndexSet == 1) {
            return "סט ב׳";
        } else return "סט ג׳";

    }



    @Override
    public void onClick(View v) {

        switch (v.getId()) {


            case R.id.skip_backward_img_btn_nav_activity_set:

                videoIndex--;

                if (videoIndex < 0) {

                    if (userProgressHelper.getExerciseEnumHelper() == ExerciseEnumHelper.FLEXIBILITY){
                        videoIndex = 0;
                        return;
                    }else videoIndex = userProgressHelper.getExerciseFullSetByIndex().get(0).length - 1;
                }

                moveAnotherVideo();

                break;


            case R.id.skip_forward_img_btn_nav_activity_set:

                videoIndex++;

                if (videoIndex >= userProgressHelper.getExerciseFullSetByIndex().get(0).length) {

                    if (userProgressHelper.getExerciseEnumHelper() == ExerciseEnumHelper.FLEXIBILITY) {

                        Intent intent = new Intent(getActivity(), FinishFullExerciseActivity.class);
                        Bundle bundle = new Bundle();

                        bundle.putSerializable("myObj", user);
                        bundle.putSerializable("sets", setsOfToday);


                        bundle.putSerializable("list", userProgressHelper);

                        intent.putExtra("bundle", bundle);
                        homeLauncher.launch(intent);

                    }

                    videoIndex = 0;

                }

                skipBackwardsImgBtn.setEnabled(true);
                moveAnotherVideo();

                break;


            case R.id.pause_img_btn_nav_activity_set:

                stopExerciseUserAction();

                break;


            case R.id.show_explanation_exercise_image_btn_activity_set:

                updateDescriptionUI();

                break;


            case R.id.linear_layout_area_text_explanation_exercise_activity_set:

                updateDescriptionUI();

                break;
        }
    }



    public void stopExerciseUserAction() {
        if (isExercise){
            updatePauseUI();
            disableButtons();

        }else {
            if (valueAnimator.isPaused())
                valueAnimator.resume();

            exerciseVideoView.resume();
            startStopper(timeStopperSave);
            pauseImgBtn.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.ic_pause_purple_24dp));
            isExercise = true;
            enableButtons();
        }
    }




    public void updatePauseUI() {

        exerciseVideoView.pause();

        if (countDownTimer != null)
            countDownTimer.cancel();

        if (valueAnimator != null && valueAnimator.isRunning())
            valueAnimator.pause();

        pauseImgBtn.setBackground(ContextCompat.getDrawable(requireContext() ,R.drawable.ic_play_arrow_purple_24dp));
        isExercise = false;
    }


    private void updateDescriptionUI() {
        if (!explanationClicked) {
            descriptionOfExerciseTextView.setVisibility(View.VISIBLE);
            showExplanationImgBtn.animate().rotation(0);
            activitySetScrollView.smoothScrollBy(0, parentRelativeLayoutActivitySetFragment.getBottom());
            explanationClicked = true;
        } else {
            descriptionOfExerciseTextView.setVisibility(View.GONE);
            showExplanationImgBtn.animate().rotation(180);
            explanationClicked = false;
        }
    }




    private void disableButtons() {
        skipBackwardsImgBtn.setEnabled(false);
        skipForwardsImgBtn.setEnabled(false);
//        pauseImgBtn.setEnabled(false);
    }


    private void enableButtons() {
        skipBackwardsImgBtn.setEnabled(true);
        skipForwardsImgBtn.setEnabled(true);
//        pauseImgBtn.setEnabled(false);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////// PLAYING VIDEO FUNCTION


    private void moveAnotherVideo() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                String stringToParse = "android.resource://" + requireActivity().getPackageName() + "/" + userProgressHelper.getExerciseFullSetByIndex().get(0)[videoIndex];

                Uri uri = Uri.parse(stringToParse);


                exerciseVideoView.setVideoURI(uri);
                exerciseVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.setLooping(true);

                        if (exerciseVideoView.getAlpha() < 1){
                            exerciseVideoView.animate().setDuration(500).alpha(1.0f);
                            videoWaitingProgressBar.setVisibility(View.GONE);
                        }

                        exerciseVideoView.start();

                        if (userProgressHelper.getExerciseEnumHelper() == ExerciseEnumHelper.FLEXIBILITY) {

                            updateFlexibilityUI();
                            startStopper(20000);
                            animateProgress(progressBarTime, progressBarTime.getMax() - progressBarTime.getProgress(), progressBarTime.getProgress());


                        } else {
                            updateTextViewUIForVideo();
                        }
                    }
                });

            }
        };

        runnable.run();
    }



    private void updateFlexibilityUI() {

        nameOfExerciseTextView.setText(userProgressHelper.getExerciseFullSetByIndex().get(1)[videoIndex]);
        descriptionOfExerciseTextView.setText(userProgressHelper.getExerciseFullSetByIndex().get(2)[videoIndex]);

        if (videoIndex < userProgressHelper.getExerciseFullSetByIndex().get(0).length - 1) {
            nameOfNextExerciseTextView.setText(userProgressHelper.getExerciseFullSetByIndex().get(1)[videoIndex + 1]);
        } else
            nameOfNextExerciseTextView.setText("סוף אימון");

        numberNumberOfExerciseTextView.setText((videoIndex + 1) + "/" + userProgressHelper.getExerciseFullSetByIndex().get(0).length);

        skipForwardsImgBtn.getBackground().setTint(ContextCompat.getColor(requireContext(), R.color.greyBackgroundScreenColor2));
        skipForwardsImgBtn.setEnabled(false);
    }



    private void updateTextViewUIForVideo() {

        nameNumberOfExerciseTextView.setText(getHebrewSetText(userProgressHelper.getIndexSet()));
        nameOfExerciseTextView.setText(userProgressHelper.getExerciseFullSetByIndex().get(1)[videoIndex]);
        descriptionOfExerciseTextView.setText(userProgressHelper.getExerciseFullSetByIndex().get(2)[videoIndex]);

        if (videoIndex < userProgressHelper.getExerciseFullSetByIndex().get(0).length - 1) {
            nameOfNextExerciseTextView.setText(userProgressHelper.getExerciseFullSetByIndex().get(1)[videoIndex + 1]);
        } else
            nameOfNextExerciseTextView.setText(userProgressHelper.getExerciseFullSetByIndex().get(1)[0]);


        int kind = userProgressHelper.getExerciseFullSetByIndex().get(4)[videoIndex];
        numberNumberOfExerciseTextView.setText((videoIndex + 1) + "/" + userProgressHelper.getExerciseFullSetByIndex().get(0).length);

        kindOfRepetitionTextView.setText(getDescriptionFromKing(kind));
        numberOfRepetitionTextView.setText(userProgressHelper.getExerciseFullSetByIndex().get(3)[videoIndex] + "");

    }


    int progress = 0;

    private void animateProgress(final ProgressBar progressBar, long duration, int from) {

        if (valueAnimator != null)
            valueAnimator.cancel();

        valueAnimator = ValueAnimator.ofInt(from, progressBar.getMax());
        valueAnimator.setDuration(duration);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                progressBarTime.setProgress(Integer.parseInt(valueAnimator.getAnimatedValue().toString()));
            }
        });

        valueAnimator.start();
    }




    private void startStopper(long timeForStopper) {

        
        if (userProgressHelper.getExerciseEnumHelper() == ExerciseEnumHelper.FLEXIBILITY) {
        progressBarTime.setMax((int) timeForStopper);
        progressBarTime.setProgress(0);
        }

        if (countDownTimer != null)
            countDownTimer.cancel();

        countDownTimer = new CountDownTimer(timeForStopper, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                timerOfSetTextView.setText(String.format("%02d", minutes)
                        + ":" + String.format("%02d", seconds));
//
//                int time = 0;
////
//                if (userProgressHelper.getExerciseEnumHelper() == ExerciseEnumHelper.FLEXIBILITY) {
//                    time = (int) (20000 - millisUntilFinished);
//                } else time = (int) (timeOfStopper - millisUntilFinished);

                timeStopperSave = millisUntilFinished;
//                progressBarTime.setProgress((int) (progressBarTime.getMax() - millisUntilFinished));
            }


            @Override
            public void onFinish() {

                if (userProgressHelper.getExerciseEnumHelper() == ExerciseEnumHelper.FLEXIBILITY) {

                    timerOfSetTextView.setText("00:00");

                    skipForwardsImgBtn.getBackground().setTint(ContextCompat.getColor(requireContext(), R.color.buttonColor));
                    skipForwardsImgBtn.setEnabled(true);
                    progressBarTime.setProgress(progressBarTime.getMax());


                } else {
                    finishedStrengthStopper();
                    valueAnimator.cancel();
                    countDownTimer.cancel();
                }

            }


        }.start();

    }




    private void finishedStrengthStopper() {
        timerOfSetTextView.setText("00:00");
//        timeOfStopper = 0;
        progressBarTime.setProgress(progressBarTime.getMax());
        final ObjectAnimator colorAnim = ObjectAnimator.ofInt(timerOfSetTextView, "textColor",
                requireContext().getResources().getColor(R.color.buttonColor), Color.BLACK);
        colorAnim.setRepeatCount(3);
        colorAnim.setDuration(500L);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                Intent intent;
                intent = new Intent(getActivity(), FinishSetActivity.class);

                Bundle bundle = new Bundle();

                userProgressHelper.getSetsInProgressToday().setNumSet(userProgressHelper.getSetsInProgressToday().getNumSet() + 1);

                userProgressHelper.setIndexSet(userProgressHelper.getIndexSet() + 1);

                bundle.putSerializable("myObj", user);
                bundle.putSerializable("sets", setsOfToday);
                bundle.putSerializable("list", userProgressHelper);

                intent.putExtra("bundle", bundle);


                if (userProgressHelper.getIndexSet() > 2) {

                    intent = new Intent(getActivity(), FinishExerciseActivity.class);
                    intent.putExtra("bundle", bundle);

                    mLauncher.launch(intent);

                }else {
                    mLauncher.launch(intent);
                }



                colorAnim.removeAllListeners();

            }
        });

        colorAnim.start();
    }




    ActivityResultLauncher<Intent> mLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    // Do your code from onActivityResult
                    Intent intent = result.getData();
                    videoIndex = 0;

                    if (intent != null){

                        Bundle bundle = intent.getBundleExtra("bundle");

                        if (bundle != null){

                            updateActivitySetFragmentUI(bundle);
                        }

                    }else {

                        if (userProgressHelper.getIndexSet() > 2){
                            getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment((HomePageActivity) getActivity(), true)).commit();
                        }else getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment((HomePageActivity) getActivity(), false)).commit();
                    }
                }
            });



    ActivityResultLauncher<Intent> homeLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    Intent intent = result.getData();

                    if (intent != null) {

                        Bundle bundle = intent.getBundleExtra("bundle");

                        if (bundle != null) {

                            videoIndex = 0;
                            updateActivitySetFragmentUI(bundle);

                        }

                    }else getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment((HomePageActivity) getActivity(), true)).commit();

                }
            });




    public void showExitExerciseDialog() {

        final Dialog dialog = new Dialog(getContext());
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.exit_exercise_dialog, null);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(dialogView);

        TextView exitDialogBtn = dialog.findViewById(R.id.close_dialog_btn_exit_exercise_dialog);
        Button exitExerciseBtn = dialog.findViewById(R.id.exit_exercise_btn_exit_exercise_dialog);

        exitExerciseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment((HomePageActivity) getActivity(), false)).commit();
                dialog.dismiss();
            }
        });

        exitDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }







    //RETURN THE NAME OF THE REPEATEAION
    private String getDescriptionFromKing(int kind) {

        String description = "";

        switch (kind) {


            case 1:

                description = "חזרות";
                break;


            case 2:

                description = "שניות";
                break;


            case 3:

                description = "כל צד";
                break;


            case 4:


                description = "ניעות";
                break;


            case 5:


                description = "שניות כל צד";
                break;


            case 6:

                description = "ניעות כל צד";
                break;


        }

        return description;
    }
}

