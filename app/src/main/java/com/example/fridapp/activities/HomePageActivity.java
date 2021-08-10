package com.example.fridapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.fridapp.R;
import com.example.fridapp.activities.fragments.exrcise.ActivitySetFragment;
import com.example.fridapp.activities.fragments.exrcise.RunStopperScreenFragment;
import com.example.fridapp.activities.fragments.exrcise.SetsOfExerciseFragment;
import com.example.fridapp.activities.fragments.history.ExerciseHistoryFragment;
import com.example.fridapp.activities.fragments.home.HomeFragment;
import com.example.fridapp.activities.fragments.profile.ProfileFragment;
import com.example.fridapp.helpers.interfaces.OnCheckNotificationListiener;
import com.example.fridapp.helpers.singleton.UserSingleton;
import com.example.fridapp.model.User;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

public class HomePageActivity extends AppCompatActivity implements OnCheckNotificationListiener {


    Bundle bundle = new Bundle();
    BottomNavigationView navView;
    View notificationBadge;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        navView = findViewById(R.id.bottom_navigation_home_page_activity);
        navView.setOnItemSelectedListener(navigationItemSelectedListener);
        navView.setSelectedItemId(R.id.nav_home);


        SharedPreferences sharedPreferences = getSharedPreferences("myObject", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("User", "");
        User user = gson.fromJson(json, User.class);
        UserSingleton.getInstance().setUser(user);
        UserSingleton.getInstance().getUser().setExercise(false);

        bundle.putSerializable("myObj", user);
        Fragment homeFragment = new HomeFragment(HomePageActivity.this, true);
        setDataInFragment(homeFragment);



    }



    private void addBadgeView() {
        try {

            BottomNavigationMenuView menuView = (BottomNavigationMenuView) navView.getChildAt(0);
            BottomNavigationItemView itemView = (BottomNavigationItemView) menuView.getChildAt(0); //set this to 0, 1, 2, or 3.. accordingly which menu item of the bottom bar you want to show badge
            notificationBadge = LayoutInflater.from(this).inflate(R.layout.component_tabbar_badge, itemView, false);
            itemView.addView(notificationBadge);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void removeBadgedView(){

        try {

            BottomNavigationMenuView menuView = (BottomNavigationMenuView) navView.getChildAt(0);
            BottomNavigationItemView itemView = (BottomNavigationItemView) menuView.getChildAt(0); //set this to 0, 1, 2, or 3.. accordingly which menu item of the bottom bar you want to show badge


            if (notificationBadge != null) {
                notificationBadge.setVisibility(View.GONE);
                itemView.getChildAt(3).setVisibility(View.GONE);
                itemView.getChildAt(2).setVisibility(View.GONE);
                itemView.getChildAt(1).setVisibility(View.GONE);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            if (UserSingleton.getInstance().getUser() != null && UserSingleton.getInstance().getUser().isExercise()){
                isUserInExercise();
                return true;
            }


            Fragment selectedFragment = null;


            int id = item.getItemId();

            if (id == R.id.nav_profile){

                try {

                    if (notificationBadge != null && notificationBadge.getVisibility() == View.VISIBLE) {
                        selectedFragment = new ProfileFragment(true, HomePageActivity.this);

                    } else {
                        onCheckNotification(false);
                        selectedFragment = new ProfileFragment(false, HomePageActivity.this);
                    }

                    setDataInFragment(selectedFragment);

                }catch (Exception e){
                    Toast.makeText(HomePageActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            } else if (id == R.id.nav_calender){

                selectedFragment = new ExerciseHistoryFragment();
                setDataInFragment(selectedFragment);

            } else if (id == R.id.nav_home){

                selectedFragment = new HomeFragment(HomePageActivity.this, false);
                setDataInFragment(selectedFragment);

            }

            return true;
        }
    };



    public void isUserInExercise() {

        User user = UserSingleton.getInstance().getUser();

        if (user.isExercise()) {


            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);

            if (fragment != null) {

                if (fragment instanceof RunStopperScreenFragment) {

                    ((RunStopperScreenFragment)fragment).handleStopUserAction();
                    ((RunStopperScreenFragment)fragment).showExitExerciseDialog();

                } else if (fragment instanceof SetsOfExerciseFragment) {

                    setDataInFragment(new HomeFragment(this, false));

                } else if (fragment instanceof ActivitySetFragment) {
                    ((ActivitySetFragment)fragment).updatePauseUI();
                    ((ActivitySetFragment)fragment).showExitExerciseDialog();
                }

            }


        }


    }


    private void setDataInFragment(Fragment selectedFragment) {
        selectedFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }



    @Override
    public void onBackPressed() {
//        super.onBackPressed();

    }


    @Override
    public void onCheckNotification(boolean checked) {

        if (checked)
            addBadgeView();
        else removeBadgedView();
    }


    private void saveUser() {

        SharedPreferences sharedPreferences = getSharedPreferences("myObject", MODE_PRIVATE);

        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(UserSingleton.getInstance().getUser());
        prefEditor.putString("User", json);
        prefEditor.apply();

    }


    @Override
    protected void onStop() {
        saveUser();
        super.onStop();
    }
}
