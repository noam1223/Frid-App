package com.example.fridapp.activities.fragments.home;

import android.animation.ValueAnimator;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fridapp.R;
import com.example.fridapp.adapter.ExerciseTrainingAdapter;
import com.example.fridapp.helpers.DefaultExerciseWeek;
import com.example.fridapp.helpers.UserProgressHelper;
import com.example.fridapp.helpers.interfaces.FragmentListener;
import com.example.fridapp.helpers.interfaces.OnCheckNotificationListiener;
import com.example.fridapp.helpers.singleton.UserSingleton;
import com.example.fridapp.model.SetsOfToday;
import com.example.fridapp.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import static android.content.Context.MODE_PRIVATE;


public class HomeFragment extends Fragment implements FragmentListener {


    TextView welcomeTextView, numOfWeekSinceUserSignedTextView;
    SwitchCompat switchCompatFitBtn;
    ScrollView scrollViewHome;
    ImageView stillInBadImageView;
    RelativeLayout progressAreaRelativeLayout;
    LinearLayout finishWeekExerciseLinearLayout, finish12WeeksExerciseLinearLayout;

    //////////////////////////////////////////////////////////////////////////////////////////////

    //PROGRESS AREA //
    ProgressBar strengthCircularProgressBar, aerobicCircularProgressBar, flexibilityCircularProgressBar;

    TextView strengthPercentTextView, flexibilityPercentTextView, aerobicPercentTextView;

    //////////////////////////////////////////////////////////////////////////////////////////////

    RecyclerView exerciseTrainingRecyclerView;
    RecyclerView.Adapter exerciseTrainingAdapter;

    User user;

    DefaultExerciseWeek defaultExerciseWeek = new DefaultExerciseWeek();

    UserProgressHelper userProgressHelper;
    ArrayList<SetsOfToday> setsOfToday;
//    ArrayList<String> dayArrayList = new ArrayList<>();
    OnCheckNotificationListiener onCheckNotificationListiener;
    int nativeWeek = -1;
    boolean animateProgress = false;



    @Override
    public void onDestroy() {
        UserSingleton.getInstance().setUser(user);
        super.onDestroy();
    }


    public HomeFragment(OnCheckNotificationListiener onCheckNotificationListiener, boolean animateProgress) {
        this.onCheckNotificationListiener = onCheckNotificationListiener;
        this.animateProgress = animateProgress;

    }


    @Override
    public void onResume() {
        super.onResume();

        requireActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


        requireView().setFocusableInTouchMode(true);
        requireView().requestFocus();
        requireView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {

                if (keyEvent.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {

                    if (getActivity() != null)
                        getActivity().finish();

                    return true;
                }


                return false;
            }
        });


    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        UserSingleton.getInstance().getUser().setExercise(false);

        finishWeekExerciseLinearLayout = view.findViewById(R.id.linear_layout_finish_exercise_week_home_fragment);
        finish12WeeksExerciseLinearLayout = view.findViewById(R.id.linear_layout_finish_exercise_12_weeks_home_fragment);
        progressAreaRelativeLayout = view.findViewById(R.id.progress_view_area_nav_home);
        numOfWeekSinceUserSignedTextView = view.findViewById(R.id.num_of_weeks_text_view_nav_home);
        welcomeTextView = view.findViewById(R.id.welcome_user_text_view_nav_home);
        exerciseTrainingRecyclerView = view.findViewById(R.id.exercise_training_recycler_view);
        scrollViewHome = view.findViewById(R.id.scroll_view_nav_home);
        stillInBadImageView = view.findViewById(R.id.still_in_bad_image_view_home_fragment);

        //////////////////////////////////////////////////////////////////////////////////////////////
        //PROGRESS AREA//

        strengthCircularProgressBar = view.findViewById(R.id.circularProgressBarStrength);
        aerobicCircularProgressBar = view.findViewById(R.id.circularProgressBarAerobic);
        flexibilityCircularProgressBar = view.findViewById(R.id.circularProgressBarFlexibility);


        strengthPercentTextView = view.findViewById(R.id.strength_percent_text_view_nav_home);
        aerobicPercentTextView = view.findViewById(R.id.aerobic_percent_text_view_nav_home);
        flexibilityPercentTextView = view.findViewById(R.id.flexibility_percent_text_view_nav_home);


        //////////////////////////////////////////////////////////////////////////////////////////////

        switchCompatFitBtn = view.findViewById(R.id.switch_btn_fit_nav_home);
        switchCompatFitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (switchCompatFitBtn.isChecked()) {
                    switchCompatFitBtn.setTextColor(requireContext().getResources().getColor(R.color.buttonColor));
                    setsOfToday = getSetsOfTodays(defaultExerciseWeek.getFitItExerciseForWeek());

                } else {
                    switchCompatFitBtn.setTextColor(Color.parseColor("#27170432"));
                    setsOfToday = getSetsOfTodays(defaultExerciseWeek.getDefaultExercisesForWeek());
//                    initializeExerciseTrainingRecyclerView(setsOfToday, false, dayArrayList, nativeWeek);
                }

                initializeExerciseTrainingRecyclerView(setsOfToday, switchCompatFitBtn.isChecked(), nativeWeek);

            }
        });


        //////////////////////////////////////////////////////////////////
        ////// WORKING ON PROGRESS DAY OF USER
        // CHECKING IF WEEK HAS PASSED TO REPRODUCE THE EXERCISES OF THE EXACT WEEK

        Calendar c = Calendar.getInstance();

        user = UserSingleton.getInstance().getUser();
        userProgressHelper = new UserProgressHelper();

        if (c.get(Calendar.WEEK_OF_YEAR) - user.getWeekOfSigned() > 12){
            finish12WeeksExerciseLinearLayout.setVisibility(View.VISIBLE);
            stillInBadImageView.setVisibility(View.INVISIBLE);
            progressAreaRelativeLayout.setVisibility(View.INVISIBLE);
            exerciseTrainingRecyclerView.setVisibility(View.INVISIBLE);
            numOfWeekSinceUserSignedTextView.setVisibility(View.INVISIBLE);
        }else updateHomeFragmentUI(c);


        UserSingleton.getInstance().setUser(user);
        return view;

    }

    private void updateHomeFragmentUI(Calendar c) {
        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("myObject", MODE_PRIVATE);
//        long time = sharedPreferences.getLong("time", 0);

        if (c.get(Calendar.WEEK_OF_YEAR) > user.getProgressWeek()) {
            user.setProgressWeek(c.get(Calendar.WEEK_OF_YEAR));
            user.getUserProgress().setTotalOfExerciseDoneByNow(user.getUserProgress().getTotalOfExerciseDoneByNow()
                    + user.getUserProgress().getNumberOfExerciseDoneWeek());
            user.getTotalSetsHadDone().add(new ArrayList<SetsOfToday>(user.getSetHaveDoneByWeek()));
            user.getSetHaveDoneByWeek().clear();
//            user.setWeekOfSigned(user.getWeekOfSigned() - 1);

            SharedPreferences.Editor prefEditor = sharedPreferences.edit();
//            prefEditor.putLong("time", System.currentTimeMillis());
            prefEditor.apply();
            user.getUserProgress().setNumberOfExerciseDoneWeek(0);
        }

        //////////////////////////////////////////////////////////


        //CHECK IF THERE IS EXERCISES IN USER
        setsOfToday = getSetsOfTodays(defaultExerciseWeek.getFitItExerciseForWeek());

        float str = 0, aer = 0, flex = 0;

        for (int i = 0; i < user.getSetHaveDoneByWeek().size(); i++) {

            switch (user.getSetHaveDoneByWeek().get(i).getExerciseEnumHelper()) {

                case FLEXIBILITY:
                    flex++;
                    break;


                case AEROBIC:
                    aer++;
                    break;

                default:
                    str++;
                    break;


            }

        }


        welcomeTextView.setText("היי " + user.getName() + " " + user.getLastName() + ", " + getTimeOfday(c));
        int week = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR) - user.getWeekOfSigned() + 1;
        nativeWeek = week - 1;
        numOfWeekSinceUserSignedTextView.setText("שבוע " + week);

        checkSetNotificationTakePhoto(week);

        progressBarUI(str, aer, flex);

        if ((str == 0 && aer == 0 && flex == 0) && c.get(Calendar.WEEK_OF_YEAR) - user.getWeekOfSigned() < 12) {
            stillInBadImageView.setVisibility(View.VISIBLE);
            progressAreaRelativeLayout.setVisibility(View.INVISIBLE);
        }


        if (setsOfToday.size() > 0)
            initializeExerciseTrainingRecyclerView(setsOfToday, true, nativeWeek);
        else finishWeekExerciseLinearLayout.setVisibility(View.VISIBLE);
    }


    private void progressBarUI(float str, float aer, float flex) {
        if (!animateProgress) {
            strengthCircularProgressBar.setProgress((int)str * 100);
            flexibilityCircularProgressBar.setProgress((int)flex * 100);
            aerobicCircularProgressBar.setProgress((int)aer * 100);
        } else {

            if (str > 0) {
//                strengthCircularProgressBar.setProgressMax(strengthCircularProgressBar.getProgressMax() * 100);
                animateProgress((int) str, strengthCircularProgressBar);
            } else strengthCircularProgressBar.setProgress(0);


            if (flex > 0) {
//                flexibilityCircularProgressBar.setProgressMax(flexibilityCircularProgressBar.getProgressMax() * 100);
                animateProgress((int) flex, flexibilityCircularProgressBar);
            } else flexibilityCircularProgressBar.setProgress(0);


            if (aer > 0) {
//                aerobicCircularProgressBar.setProgressMax(aerobicCircularProgressBar.getProgressMax() * 100);
                animateProgress((int) aer, aerobicCircularProgressBar);

            } else aerobicCircularProgressBar.setProgress(0);
        }


        strengthPercentTextView.setText(((int) (str / 3 * 100)) + "%");
        flexibilityPercentTextView.setText((int) (flex / 2 * 100) + "%");
        aerobicPercentTextView.setText((int) (aer / 2 * 100) + "%");
    }


    private void animateProgress(int value, final ProgressBar circularProgressBar) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, value * 100);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                circularProgressBar.setProgress((int) Float.parseFloat(valueAnimator.getAnimatedValue().toString()));
            }
        });

        valueAnimator.start();
    }


    private void checkSetNotificationTakePhoto(int week) {

        boolean[] openedPics = picThatOpenByWeek(week);
        int sum = 0;

        for (boolean pic :
                openedPics) {

            if (pic)
                sum++;

        }


        if (user.getImageUrl().size() < sum) {
            onCheckNotificationListiener.onCheckNotification(true);
        } else onCheckNotificationListiener.onCheckNotification(false);

    }




    private ArrayList<SetsOfToday> getSetsOfTodays(ArrayList<SetsOfToday> setsOfTodays) {

        for (int i = 0; i < user.getSetHaveDoneByWeek().size(); i++) {

            for (int j = 0; j < setsOfTodays.size(); j++) {

                if (user.getSetHaveDoneByWeek().get(i).getExerciseEnumHelper() == setsOfTodays.get(j).getExerciseEnumHelper()
                        && user.getSetHaveDoneByWeek().get(i).getNumSet() == setsOfTodays.get(j).getNumSet()) {

                    setsOfTodays.remove(j);

                    break;
                }
            }
        }
        return setsOfTodays;
    }




    private void initializeExerciseTrainingRecyclerView(ArrayList<SetsOfToday> setsOfToday, boolean recommendedByFit, int week) {

        exerciseTrainingRecyclerView.setNestedScrollingEnabled(false);
        exerciseTrainingRecyclerView.setHasFixedSize(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        exerciseTrainingRecyclerView.setLayoutManager(layoutManager);
        exerciseTrainingAdapter = new ExerciseTrainingAdapter(getContext(), user, this, setsOfToday, userProgressHelper, recommendedByFit, week);
        exerciseTrainingRecyclerView.setAdapter(exerciseTrainingAdapter);


    }


    @Override
    public void onTransactionFragmentListener(Fragment fragment) {
        getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }


    private String getTimeOfday(Calendar c) {

        String theTime = "";
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay >= 0 && timeOfDay < 12) {

            theTime = "בוקר טוב";

        } else if (timeOfDay >= 12 && timeOfDay < 16) {

            theTime = "צהריים טובים";

        } else if (timeOfDay >= 16 && timeOfDay < 21) {

            theTime = "ערב טוב";

        } else if (timeOfDay >= 21 && timeOfDay < 24) {

            theTime = "לילה טוב";

        } else {

            theTime = "יום נעים";

        }

        return theTime;
    }


    private boolean[] picThatOpenByWeek(int week) {

        boolean[] openedPic;

        if (week >= 1 && week < 4) {
            openedPic = new boolean[]{true, false, false, false};
        } else if (week >= 4 && week < 8) {
            openedPic = new boolean[]{true, true, false, false};
        } else if (week >= 8 && week < 12) {
            openedPic = new boolean[]{true, true, true, false};
        } else openedPic = new boolean[]{true, true, true, true};


        return openedPic;
    }

}
