package com.example.fridapp.activities.fragments.exrcise;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fridapp.R;
import com.example.fridapp.activities.FinishExerciseActivity;
import com.example.fridapp.activities.HomePageActivity;
import com.example.fridapp.activities.fragments.home.HomeFragment;
import com.example.fridapp.adapter.TimeToRunAdapter;
import com.example.fridapp.helpers.UserProgressHelper;
import com.example.fridapp.helpers.interfaces.TimeToRunSetListener;
import com.example.fridapp.helpers.uihelper.ResizeAnimation;
import com.example.fridapp.model.User;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class RunStopperScreenFragment extends Fragment implements View.OnClickListener, TimeToRunSetListener {

    RelativeLayout relativeLayoutAreaRecyclerView;
    View aboveLineRecyclerView, belowLineRecyclerView;
    TextView numOfWeekTextView, subHeadSumExerciseTextView, subHeadNumExerciseTextView, timeStopperRunTextView;
    ImageButton startStopperImageBtn, stopExerciseImageBtn;
//    ImageButton backArrowBtn;
    ProgressBar timeDonutProgress;
    RecyclerView timeToChooseRecyclerView;
    RecyclerView.Adapter timeToChooseAdapter;
    CountDownTimer countDownTimer;
//    ValueAnimator valueAnimator;

    User user;
    UserProgressHelper userProgressHelper;

    long timeForStopper = 0, timeDiffer = 0;
    boolean isRun = false, isStop = false;
    int widthLayout = 0, heightLayout = 0;


    @Override
    public void onDestroy() {

        if (countDownTimer != null)
            countDownTimer.cancel();

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
        View view = inflater.inflate(R.layout.fragment_run_stopper_screen, container, false);

        numOfWeekTextView = view.findViewById(R.id.stopper_text_view_week_nav_run_stopper_screen);
        subHeadSumExerciseTextView = view.findViewById(R.id.sum_of_set_text_view_nav_run_stopper_screen);
        subHeadNumExerciseTextView = view.findViewById(R.id.num_of_set_text_view_nav_run_stopper_screen);
        relativeLayoutAreaRecyclerView = view.findViewById(R.id.relative_layout_recycler_view_area_nav_run_stopper_screen);
        timeStopperRunTextView = view.findViewById(R.id.time_of_stopper_text_view_nav_run_stopper_screen);

        aboveLineRecyclerView = view.findViewById(R.id.above_line_view_run_stopper_screen_fragment);
        belowLineRecyclerView = view.findViewById(R.id.below_line_view_run_stopper_screen_fragment);

        timeDonutProgress = view.findViewById(R.id.donut_progress_bar_nav_run_stopper_screen);
        timeToChooseRecyclerView = view.findViewById(R.id.choose_time_to_run_recycler_view);

        startStopperImageBtn = view.findViewById(R.id.start_stopper_btn_nav_run_stopper_screen);
        startStopperImageBtn.setOnClickListener(this);
        stopExerciseImageBtn = view.findViewById(R.id.stop_stopper_btn_nav_run_stopper_screen);
        stopExerciseImageBtn.setOnClickListener(this);
//        stopExerciseImageBtn.setVisibility(View.INVISIBLE);

//        backArrowBtn = view.findViewById(R.id.back_fragment_btn_nav_run_stopper_screen);
//        backArrowBtn.setOnClickListener(this);

        timeDonutProgress.setProgress(0);


        if (getArguments() != null) {

            user = (User) getArguments().getSerializable("myObj");
            userProgressHelper = (UserProgressHelper) getArguments().getSerializable("list");


            String numExerciseString = userProgressHelper.getExeNumOfActivitySet();

            String[] splitNum = numExerciseString.split("/");

            subHeadSumExerciseTextView.setText("/" + splitNum[1]);
            subHeadNumExerciseTextView.setText(splitNum[0]);

            int week = (Calendar.getInstance().get(Calendar.WEEK_OF_YEAR) - user.getWeekOfSigned()) + 1;
            numOfWeekTextView.setText("שבוע " + week);

            initializeTimeToChooseRecyclerView();

            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayoutAreaRecyclerView.getLayoutParams();
            heightLayout = layoutParams.height;
        }


        return view;
    }




    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.start_stopper_btn_nav_run_stopper_screen:

                handleStopUserAction();

                break;


            case R.id.stop_stopper_btn_nav_run_stopper_screen:

                isStop = true;
                showStopExerciseDialog();

                break;


//            case R.id.back_fragment_btn_nav_run_stopper_screen:
//
//                isStop = true;
//                isRun = true;
//
//                handleStopUserAction();
//                showExitExerciseDialog();
//
//                break;

        }
    }




    public void handleStopUserAction() {

        if (isRun) {

            if (countDownTimer != null)
                countDownTimer.cancel();

            startStopperImageBtn.setImageResource(R.drawable.ic_play_arrow_white_24dp);
            isRun = false;
//            stopExerciseImageBtn.setEnabled(false);

        } else {

            startStopper(timeForStopper);
            startStopperImageBtn.setImageResource(R.drawable.ic_pause_white_24dp);
            isRun = true;
            isStop = false;
//            stopExerciseImageBtn.setEnabled(true);
//            relativeLayoutAreaRecyclerView.setVisibility(View.GONE);

            animateTimeArea();

        }

    }



    public void showExitExerciseDialog() {

//        if (countDownTimer != null)
//            countDownTimer.cancel();


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
//                startStopper(timeForStopper);
            }
        });

        dialog.show();
    }




    public void showStopExerciseDialog() {

//        if (countDownTimer != null)
//            countDownTimer.cancel();

        if (isRun)
            handleStopUserAction();

        final Dialog dialog = new Dialog(getContext());
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.exit_exercise_dialog, null);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(dialogView);

        TextView exitDialogBtn = dialog.findViewById(R.id.close_dialog_btn_exit_exercise_dialog);
        TextView subTextViewExitDialog = dialog.findViewById(R.id.sub_view_text_exit_exercise_dialog);
        Button exitExerciseBtn = dialog.findViewById(R.id.exit_exercise_btn_exit_exercise_dialog);

        subTextViewExitDialog.setText("במידה ותפסיק השעון ייתאפס");

        exitExerciseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                isRun = true;
//                isStop = true;
//                handleStopUserAction();

                animateTimeAreaOpen();
                dialog.dismiss();
            }
        });

        exitDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                isRun = false;
//                isStop = false;
                dialog.dismiss();
            }
        });

        dialog.show();
    }





    private void initializeTimeToChooseRecyclerView() {

        timeToChooseRecyclerView.setNestedScrollingEnabled(false);
        timeToChooseRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        timeToChooseRecyclerView.setLayoutManager(layoutManager);
        timeToChooseAdapter = new TimeToRunAdapter(getContext(), this);
        if (timeToChooseRecyclerView.getItemDecorationCount() > 0){
            timeToChooseRecyclerView.removeItemDecoration(itemDecoration);
        }
        timeToChooseRecyclerView.addItemDecoration(itemDecoration);
        timeToChooseRecyclerView.setAdapter(timeToChooseAdapter);

    }


    RecyclerView.ItemDecoration itemDecoration = new RecyclerView.ItemDecoration() {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            outRect.left = 24;
        }
    };


    private void startStopper(long time) {

        countDownTimer = new CountDownTimer(time, 50) {

            @Override
            public void onTick(long millisUntilFinished) {


                String hms = String.format("%02d:%02d:%02d",
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)), TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
                timeStopperRunTextView.setText(hms);

                timeForStopper = millisUntilFinished;
                timeDonutProgress.setProgress((int) (timeDiffer - millisUntilFinished));

            }

            @Override
            public void onFinish() {

                timeStopperRunTextView.setText("00:00:00");
                startStopperImageBtn.setEnabled(false);
                stopExerciseImageBtn.setEnabled(false);
                relativeLayoutAreaRecyclerView.setVisibility(View.GONE);

                Intent intent = new Intent(getActivity(), FinishExerciseActivity.class);
                Bundle bundle = new Bundle();

                bundle.putSerializable("myObj", user);

                bundle.putSerializable("list", userProgressHelper);

                intent.putExtra("bundle", bundle);

//                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                mLauncher.launch(intent);
            }


        }.start();

    }



    ActivityResultLauncher<Intent> mLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    // Do your code from onActivityResult
                    Intent intent = result.getData();

                    if (intent != null){

                        Bundle bundle = intent.getBundleExtra("bundle");


                        if (bundle != null){
                            Fragment fragment = new ActivitySetFragment();
                            fragment.setArguments(bundle);
                            getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                        }

                    }else {
                        Fragment fragment = new HomeFragment(((HomePageActivity)getActivity()) , true);
                        getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                    }
                }
            });






//    private void animateProgress(final CircularProgressBar progressBar, long duration, int from) {
//
//        if (valueAnimator != null)
//            valueAnimator = null;
//
//        valueAnimator = ValueAnimator.ofInt(from, (int) progressBar.getProgressMax());
//        valueAnimator.setDuration(duration);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                progressBar.setProgress(Integer.parseInt(valueAnimator.getAnimatedValue().toString()));
//            }
//        });
//
//        valueAnimator.start();
//    }



    @Override
    public void timeToRun(long time) {

        timeForStopper = time;
        timeDiffer = time;
        timeDonutProgress.setMax((int) time);
        timeDonutProgress.setProgress(0);

        String hms = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(time),
                TimeUnit.MILLISECONDS.toMinutes(time) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(time)), TimeUnit.MILLISECONDS.toSeconds(time) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(time)));
        timeStopperRunTextView.setText(hms);

    }




    private void animateTimeArea() {

        ResizeAnimation resizeAnimation = new ResizeAnimation(relativeLayoutAreaRecyclerView, relativeLayoutAreaRecyclerView.getLayoutParams().width, relativeLayoutAreaRecyclerView.getLayoutParams().width, relativeLayoutAreaRecyclerView.getLayoutParams().height, 0);
        resizeAnimation.setDuration(750);
        resizeAnimation.setFillEnabled(true);
        resizeAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                relativeLayoutAreaRecyclerView.setVisibility(View.INVISIBLE);
//                relativeLayoutAreaRecyclerView.getLayoutParams().height = heightLayout;
                relativeLayoutAreaRecyclerView.clearAnimation();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        relativeLayoutAreaRecyclerView.startAnimation(resizeAnimation);
    }




    private void animateTimeAreaOpen() {
        relativeLayoutAreaRecyclerView.setVisibility(View.VISIBLE);

        ResizeAnimation resizeAnimation = new ResizeAnimation(relativeLayoutAreaRecyclerView, relativeLayoutAreaRecyclerView.getLayoutParams().width, relativeLayoutAreaRecyclerView.getLayoutParams().width, 0, heightLayout);
        resizeAnimation.setDuration(750);
        resizeAnimation.setFillEnabled(true);
        resizeAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                aboveLineRecyclerView.setVisibility(View.INVISIBLE);
                belowLineRecyclerView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                initializeTimeToChooseRecyclerView();
                aboveLineRecyclerView.setVisibility(View.VISIBLE);
                belowLineRecyclerView.setVisibility(View.VISIBLE);
                relativeLayoutAreaRecyclerView.clearAnimation();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        relativeLayoutAreaRecyclerView.startAnimation(resizeAnimation);
    }

}
