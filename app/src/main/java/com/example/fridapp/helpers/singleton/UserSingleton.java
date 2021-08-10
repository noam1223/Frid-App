package com.example.fridapp.helpers.singleton;

import com.example.fridapp.model.User;

public class UserSingleton {
    private static final UserSingleton instance = new UserSingleton();

    public static UserSingleton getInstance(){
        return instance;
    }

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
