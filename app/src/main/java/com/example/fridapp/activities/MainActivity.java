package com.example.fridapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fridapp.R;
import com.example.fridapp.helpers.singleton.UserSingleton;
import com.example.fridapp.model.User;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("myObject", MODE_PRIVATE);
                Gson gson = new Gson();
                String json = sharedPreferences.getString("User", "");

                if (!json.equals("")) {
                    User user = gson.fromJson(json, User.class);


                    UserSingleton.getInstance().setUser(user);

                    startActivity(new Intent(getApplicationContext(), HomePageActivity.class));
                    finish();

                } else {

                    startActivity(new Intent(getApplicationContext(), SigninActivity.class));
                    finish();

                }
            }
        }, 2000);
    }
}
