package com.example.fridapp.activities;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.fridapp.R;
import com.example.fridapp.activities.fragments.signinfragments.LastFirstNameFragment;
import com.example.fridapp.activities.fragments.signinfragments.SexFragment;
import com.example.fridapp.activities.fragments.signinfragments.SignInCallBack;
import com.example.fridapp.activities.fragments.signinfragments.WeightFragment;
import com.example.fridapp.helpers.singleton.UserSingleton;
import com.example.fridapp.model.User;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SigninActivity extends AppCompatActivity implements SignInCallBack, View.OnClickListener {

    Button nextBtn;
    ImageButton backBtn;
    Bundle bundle = new Bundle();

    Fragment[] fragments = new Fragment[]{new LastFirstNameFragment(this),
            new SexFragment(this),
            new WeightFragment(this)};

    int fragmentIndex = 0;

    String firstName = "", lastName = "", sex = "";
    float weight = 0.0f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        backBtn = findViewById(R.id.back_fragment_btn_activity_sign_in);
        backBtn.setVisibility(View.INVISIBLE);
        nextBtn = findViewById(R.id.next_sign_in_btn_signin_activity);

        backBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.sign_in_fragment_container, fragments[fragmentIndex]).commit();

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void firstLastNameCallBack(String name, String lastName) {

        if (!name.isEmpty() && !lastName.isEmpty()) {

            firstName = name;
            this.lastName = lastName;

            bundle.putString("firstName", firstName);
            bundle.putString("lastName", this.lastName);
            fragments[0].setArguments(bundle);

        }

    }

    @Override
    public void sexTypeCallBack(String sex) {

        this.sex = sex;

        bundle.putString("sex", this.sex);
        fragments[1].setArguments(bundle);

    }

    @Override
    public void weightCallBack(String weight) {

        this.weight = Float.parseFloat(weight);

        bundle.putFloat("weight", this.weight);
        fragments[2].setArguments(bundle);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.back_fragment_btn_activity_sign_in:

                if (fragmentIndex <= 0) {
                    fragmentIndex = 0;
                    return;
                } else {
                    fragmentIndex--;
                    getSupportFragmentManager().beginTransaction().replace(R.id.sign_in_fragment_container, fragments[fragmentIndex]).commit();

                    if (fragmentIndex == 0)
                        backBtn.setVisibility(View.INVISIBLE);
                }


                break;


            case R.id.next_sign_in_btn_signin_activity:

                if (fragmentIndex == 2 && checkDataFragmentType()) {
                    showSignInDialog();
                } else if (checkDataFragmentType()) {
                    fragmentIndex++;
                    backBtn.setVisibility(View.VISIBLE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.sign_in_fragment_container, fragments[fragmentIndex]).commit();
                } else Toast.makeText(this, "יש למלא את הפרטים", Toast.LENGTH_SHORT).show();


                break;


        }

    }


    private void saveUserDetails() {


        User newUser = new User(firstName, sex);
        newUser.setLastName(lastName);
        newUser.setWeight(weight);

        newUser.setDayOfSigned(Calendar.getInstance().get(Calendar.DAY_OF_YEAR));
        newUser.setProgressDay(newUser.getDayOfSigned());
        newUser.setWeekOfSigned(Calendar.getInstance().get(Calendar.WEEK_OF_YEAR));
        newUser.setProgressWeek(newUser.getWeekOfSigned());
        newUser.setMonthOfSigned(Calendar.getInstance().get(Calendar.MONTH));

        SharedPreferences sharedPreferences = getSharedPreferences("myObject", MODE_PRIVATE);

        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(newUser);
        prefEditor.putString("User", json);
//        prefEditor.putLong("time", System.currentTimeMillis());
        prefEditor.apply();

        UserSingleton.getInstance().setUser(newUser);

        Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
        intent.putExtra("user", newUser);
        startActivity(intent);
        finish();


    }



    private boolean checkDataFragmentType() {

        if (fragmentIndex == 0) {
            if (firstName.isEmpty() || lastName.isEmpty()) {
                return false;
            }
        } else if (fragmentIndex == 1) {
            if (sex.isEmpty()) {
                return false;
            }
        }

        return true;

    }



    private void showSignInDialog() {
        final Dialog dialog = new Dialog(this);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.sign_in_dialog, null);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(dialogView);

        TextView firstLastNameTextView, sexTextView, weightTextView, dateOfTodayTextView, cancelDialogTextView;
        Button finishSignInBtn;

        finishSignInBtn = dialog.findViewById(R.id.go_to_home_activity_btn_sign_in_dialog);

        firstLastNameTextView = dialog.findViewById(R.id.first_last_name_text_view_sign_in_dialog);
        sexTextView = dialog.findViewById(R.id.sex_text_view_sign_in_dialog);
        weightTextView = dialog.findViewById(R.id.weight_text_view_sign_in_dialog);
        dateOfTodayTextView = dialog.findViewById(R.id.date_day_text_view_sign_in_dialog);
        cancelDialogTextView = dialog.findViewById(R.id.cancel_text_view_clickable_sign_in_dialog);

        cancelDialogTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        finishSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                saveUserDetails();
            }
        });


        firstLastNameTextView.setText(firstName + " " + lastName);
        sexTextView.setText(sex);
        weightTextView.setText(weight + " ק״ג");


        dateOfTodayTextView.setText(new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Calendar.getInstance().getTime()));


        dialog.show();
    }


}
