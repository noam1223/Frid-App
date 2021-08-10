package com.example.fridapp.activities;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.example.fridapp.R;
import com.example.fridapp.helpers.ExerciseEnumHelper;
import com.example.fridapp.helpers.UserProgressHelper;
import com.example.fridapp.helpers.singleton.UserSingleton;
import com.example.fridapp.model.SetsOfToday;
import com.example.fridapp.model.User;

//import nl.dionsegijn.konfetti.KonfettiView;
//import nl.dionsegijn.konfetti.models.Shape;
//import nl.dionsegijn.konfetti.models.Size;

public class FinishFullExerciseActivity extends AppCompatActivity {

    ConstraintLayout finishTotalImageAreaConstrainLayout;
    Button moveToFlexibilityFragment;
    TextView moveToHomeFragment, headLineFinishExerciseTextView, numOfSetFinishExerciseTextView, sumOfSetFinishExerciseTextView;


    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        setResult(RESULT_OK);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_full_exercise);

        finishTotalImageAreaConstrainLayout = findViewById(R.id.images_view_area_constrain_layout_finish_full_exercise_activity);

        headLineFinishExerciseTextView = findViewById(R.id.set_head_line_text_view_finish_full_exercise_activity);
        numOfSetFinishExerciseTextView = findViewById(R.id.num_of_set_text_view_finish_full_exercise_activity);
        sumOfSetFinishExerciseTextView = findViewById(R.id.sum_of_set_text_view_finish_full_exercise_activity);
        moveToHomeFragment = findViewById(R.id.back_to_home_frag_text_view_finish_full_exercise_activity);

        finishTotalImageAreaConstrainLayout.animate().setDuration(1250).scaleX(1).scaleY(1);
//        DisplayMetrics display = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(display);
//        final KonfettiView konfettiView = findViewById(R.id.viewKonfetti);
//        konfettiView.build()
//                .addColors(ContextCompat.getColor(getApplicationContext(), R.color.confetti_color), ContextCompat.getColor(getApplicationContext(), R.color.buttonColor))
//                .setDirection(display.heightPixels, 359.0)
//                .setSpeed(1f, 4f)
//                .setFadeOutEnabled(true)
//                .setTimeToLive(1550L)
//                .addShapes(Shape.Square.INSTANCE, Shape.Circle.INSTANCE)
//                .addSizes(new Size(12, 3f))
//                .setPosition(-50f, display.widthPixels + 50f, -50f, -50f)
//                .streamFor(150, 1250L);



        moveToHomeFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK);
                finish();
            }
        });


        Bundle bundle = getIntent().getBundleExtra("bundle");


        if (bundle != null){

            User user = (User) bundle.getSerializable("myObj");
            UserProgressHelper userProgressHelper = (UserProgressHelper) bundle.getSerializable("list");
            boolean exerciseExist = false;
            String numExerciseString, headLine;





            if (userProgressHelper.getExerciseSetTobeSave() != null) {

                for (int i = 0; i < user.getSetHaveDoneByWeek().size(); i++) {

                    if (user.getSetHaveDoneByWeek().get(i).getExerciseEnumHelper() == userProgressHelper.getExerciseSetTobeSave().getExerciseEnumHelper()
                            && user.getSetHaveDoneByWeek().get(i).getNumSet() == userProgressHelper.getExerciseSetTobeSave().getNumSet()) {
                        exerciseExist = true;
                    }

                }


                if (!exerciseExist) {
                    user.getUserProgress().setNumberOfExerciseDoneWeek(user.getUserProgress().getNumberOfExerciseDoneWeek() + 1);
                    user.getSetHaveDoneByWeek().add(userProgressHelper.getExerciseSetTobeSave());
                    user.getSetsOfToday_24h().clear();
                }


                numExerciseString = userProgressHelper.getExeNumOfActivitySet();
                headLine = userProgressHelper.getExeTypeHeb();



            }else {

                SetsOfToday setsOfToday = user.getSetHaveDoneByWeek().get(user.getSetHaveDoneByWeek().size() - 1);

                if (setsOfToday.getExerciseEnumHelper() == ExerciseEnumHelper.FLEXIBILITY){

                    headLine = getString(R.string.FLEXIBILITY_HEB);
                    numExerciseString = setsOfToday.getNumSet() + "/2";

                }else if (setsOfToday.getExerciseEnumHelper() == ExerciseEnumHelper.AEROBIC){

                    headLine = getString(R.string.AEROBIC_HEB);
                    numExerciseString = setsOfToday.getNumSet() + "/2";

                }else {
                    headLine = getString(R.string.STRENGTH_HEB);
                    numExerciseString = setsOfToday.getNumSet() + "/3";

                }


            }

            headLineFinishExerciseTextView.setText(headLine);

            String[] splitNum = numExerciseString.split("/");

            sumOfSetFinishExerciseTextView.setText("/" + splitNum[1]);
            numOfSetFinishExerciseTextView.setText(splitNum[0]);

            UserSingleton.getInstance().setUser(user);

        }

    }
}