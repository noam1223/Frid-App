package com.example.fridapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fridapp.R;
import com.example.fridapp.helpers.ExerciseEnumHelper;
import com.example.fridapp.helpers.ExerciseNumbersByWeek;
import com.example.fridapp.helpers.UserProgressHelper;
import com.example.fridapp.helpers.singleton.UserSingleton;
import com.example.fridapp.model.SetsOfToday;
import com.example.fridapp.model.User;


public class FinishExerciseActivity extends AppCompatActivity {

    Button moveToFlexibilityFragment;
    ImageView group176ImageView;
    TextView moveToHomeFragment, headLineFinishExerciseTextView, numOfSetFinishExerciseTextView, sumOfSetFinishExerciseTextView;
    UserProgressHelper userProgressHelper;
    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_exercise);


        headLineFinishExerciseTextView = findViewById(R.id.set_head_line_text_view_finish_exercise_activity);
        numOfSetFinishExerciseTextView = findViewById(R.id.num_of_set_text_view_finish_exercise_activity);
        sumOfSetFinishExerciseTextView = findViewById(R.id.sum_of_set_text_view_finish_exercise_activity);

        group176ImageView = findViewById(R.id.finish_image_group_176_image_view_finish_exercise_activity);
        group176ImageView.animate().setDuration(1250).scaleX(1).scaleY(1);



        moveToFlexibilityFragment = findViewById(R.id.move_to_flexibility_exercise_btn_finish_exercise_activity);
        moveToFlexibilityFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userProgressHelper.setExerciseEnumHelper(ExerciseEnumHelper.FLEXIBILITY);
                userProgressHelper.setExerciseFullSet_3(new ExerciseNumbersByWeek().getCompletionListFlexibility());
                userProgressHelper.setIndexSet(2);
                userProgressHelper.setExeTypeHeb(getString(R.string.FLEXIBILITY_HEB));
//                userProgressHelper.setExeNumOfActivitySet("");
                userProgressHelper.setExerciseSetTobeSave(null);
                userProgressHelper.setExeSubStrengthHeb(getString(R.string.FULLBODY_HEB));
                userProgressHelper.setExeNumOfActivitySet(userProgressHelper.getExeNumOfActivitySet());
                userProgressHelper.setExerciseTypePath(getString(R.string.FLEXIBILITY_PATH));
                bundle.putSerializable("myObj", UserSingleton.getInstance().getUser());
                bundle.putString("headLine", getString(R.string.FULLBODY_HEB));
                bundle.putSerializable("list", userProgressHelper);


                getIntent().putExtra("bundle", bundle);
                setResult(RESULT_OK, getIntent());
                finish();


            }
        });


        moveToHomeFragment = findViewById(R.id.back_to_home_frag_text_view_finish_exercise_activity);
        moveToHomeFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });



        bundle = getIntent().getBundleExtra("bundle");


        if (bundle != null) {

            User user = (User) bundle.getSerializable("myObj");
            userProgressHelper = (UserProgressHelper) bundle.getSerializable("list");
            String numExerciseString, headLine;
            SetsOfToday setsOfToday = new SetsOfToday();


            boolean exerciseExist = false;

            if (userProgressHelper.getExerciseSetTobeSave() != null) {

                setsOfToday = userProgressHelper.getExerciseSetTobeSave();

                for (int i = 0; i < user.getSetHaveDoneByWeek().size(); i++) {

                    if (user.getSetHaveDoneByWeek().get(i).getExerciseEnumHelper() == userProgressHelper.getExerciseSetTobeSave().getExerciseEnumHelper()
                            && user.getSetHaveDoneByWeek().get(i).getNumSet() == userProgressHelper.getExerciseSetTobeSave().getNumSet()) {
                        exerciseExist = true;
                        break;
                    }
                }


                if (!exerciseExist) {
                    user.getUserProgress().setNumberOfExerciseDoneWeek(user.getUserProgress().getNumberOfExerciseDoneWeek() + 1);
                    user.getSetHaveDoneByWeek().add(userProgressHelper.getExerciseSetTobeSave());
                    user.getSetsOfToday_24h().clear();
                }

            }else {

                setsOfToday = user.getSetHaveDoneByWeek().get(user.getSetHaveDoneByWeek().size() - 1);
            }



            if (setsOfToday.getExerciseEnumHelper() == ExerciseEnumHelper.AEROBIC){

                headLine = getString(R.string.AEROBIC_HEB);
                numExerciseString = 1 + "/1";

            }else {
                headLine = getString(R.string.STRENGTH_HEB);
                numExerciseString = 3 + "/3";

            }

            String[] splitNum = numExerciseString.split("/");

//            headLineFinishExerciseTextView.setText(headLine);

            sumOfSetFinishExerciseTextView.setText("/" + splitNum[1]);
            numOfSetFinishExerciseTextView.setText(splitNum[0]);

            UserSingleton.getInstance().setUser(user);

        }



    }
}