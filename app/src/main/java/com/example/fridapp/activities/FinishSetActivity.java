package com.example.fridapp.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.fridapp.R;
import com.example.fridapp.helpers.UserProgressHelper;
import com.example.fridapp.helpers.singleton.UserSingleton;
import com.example.fridapp.helpers.uihelper.ResizeAnimation;
import com.example.fridapp.model.User;

public class FinishSetActivity extends AppCompatActivity {


    ConstraintLayout waitingAreConstrainLayout;
    TextView oneMinClock, numOfSetTextView, sumOfSetTextView, nextExerciseNameTextView, skipForwardTextView;
    VideoView nextExerciseVideoView;
    CountDownTimer countDownTimer;
    RelativeLayout lineAreaRelativeLayout;

    User user;
    UserProgressHelper userProgressHelper;


    long timeForStopper = 60000;
    long timeFromPresentation = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_set);


        oneMinClock = findViewById(R.id.one_min_res_time_text_view_finish_set_activity);
        lineAreaRelativeLayout = findViewById(R.id.relative_layout_view_lines_area_nav_finish_set_activity);

        waitingAreConstrainLayout = findViewById(R.id.constrain_layout_waiting_time_area_nav_finish_set_activity);

        nextExerciseVideoView = findViewById(R.id.video_view_next_exercise_set_nav_finish_set_activity);

        numOfSetTextView = findViewById(R.id.num_of_set_text_view_nav_finish_set_activity);
        sumOfSetTextView = findViewById(R.id.sum_of_set_text_view_nav_finish_set_activity);

        nextExerciseNameTextView = findViewById(R.id.next_exercise_name_text_view_nav_finish_set_activity);
        skipForwardTextView = findViewById(R.id.skip_next_exercise_set_text_view_nav_finish_set_activity);



        if (getIntent() != null) {

            Bundle bundle = getIntent().getBundleExtra("bundle");

            if (bundle != null) {
                user = (User) bundle.getSerializable("myObj");
                userProgressHelper = (UserProgressHelper) bundle.getSerializable("list");
                timeFromPresentation = bundle.getLong("timer", 10);

                numOfSetTextView.setText(String.valueOf(userProgressHelper.getIndexSet()));
                sumOfSetTextView.setText("/3");

                nextExerciseNameTextView.setText(userProgressHelper.getExerciseFullSetByIndex().get(1)[0]);

                skipForwardTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        moveToNextFragmentByCounter();

                    }
                });


                setFirstFrameOfNextExercise();


                if (timeFromPresentation == 10) {
                    startStopper(timeForStopper);
                } else {

                    startStopper(timeFromPresentation);

                }


                ResizeAnimation resizeAnimation = new ResizeAnimation(lineAreaRelativeLayout, lineAreaRelativeLayout.getLayoutParams().width,
                        lineAreaRelativeLayout.getLayoutParams().width + 120,
                        lineAreaRelativeLayout.getLayoutParams().height,
                        lineAreaRelativeLayout.getLayoutParams().height + 100);

                resizeAnimation.setDuration(400);

                resizeAnimation.setRepeatMode(Animation.REVERSE);
                resizeAnimation.setRepeatCount(Animation.INFINITE);
                resizeAnimation.setFillEnabled(true);
                lineAreaRelativeLayout.startAnimation(resizeAnimation);

            }


            UserSingleton.getInstance().setUser(user);

        }


    }



    //WORKING ON PICTURE OF FIRST EXERCISE OF THE NEXT SET
    private void setFirstFrameOfNextExercise() {
        String stringToParse = "android.resource://"+ getApplicationContext().getPackageName() +"/" + userProgressHelper.getExerciseFullSetByIndex().get(0)[0];

        Uri uri = Uri.parse(stringToParse);

        nextExerciseVideoView.setVideoURI(uri);
        nextExerciseVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                nextExerciseVideoView.start();
            }
        });
    }




    //TRANSFER THE USER TO RELEVANT FRAGMENT BY COUNTER
    //IF COUNTER NOT DONE THE TEXT WILL BE דלג AND WILL MOVE THE USER TO PRESENTATION EXERCISE FRAGMENT
    //IF THE COUNTER DONE THE TEXT WILL BE התחל AND WILL MOVE THE USER TO FRAGMENT ACTIVITY SET AND START THE NEXT EXERCISE SET
    private void moveToNextFragmentByCounter() {

        if (skipForwardTextView.getText().toString().equals("דלג")){

            setResult(RESULT_OK, getIntent());
            countDownTimer.cancel();
            finish();

        } else if (skipForwardTextView.getText().toString().equals("התחל")){

            setResult(RESULT_OK, getIntent());
            countDownTimer.cancel();
            finish();

        }
    }



    //WORKING ON COUNTER DOWN TIMER
    //WHEN FINISH IT WILL STOP THE ANIMATION AND WILL TRANSFER THE USER TO THE NEXT FRAGMENT
    private void startStopper(long time) {

        countDownTimer = new CountDownTimer(time, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

                int seconds = (int) (millisUntilFinished / 1000);
                seconds = seconds % 60;

                oneMinClock.setText(String.format("%02d", seconds));

                timeForStopper = millisUntilFinished;
            }

            @Override
            public void onFinish() {

                final float startSize = 23; // Size in pixels
                final float endSize = 33;
                final int animationDuration = 500; // Animation duration in ms

                ValueAnimator animator = ValueAnimator.ofFloat(startSize, endSize);
                animator.setDuration(animationDuration);
                animator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink_animation);
                        skipForwardTextView.startAnimation(animation1);
                    }
                });
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedValue = (float) valueAnimator.getAnimatedValue();
                        skipForwardTextView.setTextSize(animatedValue);
                    }
                });

                animator.start();
                skipForwardTextView.setText("התחל");
                lineAreaRelativeLayout.clearAnimation();

            }


        }.start();

    }
}