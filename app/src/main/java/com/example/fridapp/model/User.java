package com.example.fridapp.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {

    private String name;
    private String lastName;
    private String sex;
    private float weight;
    private float currentWeight;

    private List<String> imageUrl = new ArrayList<>();

    private boolean isExercise = false;
    private UserProgress userProgress;
    private int dayOfSigned, progressDay, weekOfSigned, progressWeek, monthOfSigned;
    private ArrayList<SetsOfToday> setHaveDoneByWeek;
    private ArrayList<SetsOfToday> setsOfToday_24h;
    private ArrayList<ArrayList<SetsOfToday>> totalSetsHadDone = new ArrayList<>();



    public User() {
        userProgress = new UserProgress();
    }

    public User(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public User(String name, String lastName, String sex, float weight, float currentWeight, List<String> imageUrl, boolean isExercise, UserProgress userProgress, int dayOfSigned, int progressDay, int weekOfSigned, int progressWeek, int monthOfSigned, ArrayList<SetsOfToday> setHaveDoneByWeek, ArrayList<SetsOfToday> setsOfToday_24h, ArrayList<ArrayList<SetsOfToday>> totalSetsHadDone) {
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
        this.weight = weight;
        this.currentWeight = currentWeight;
        this.imageUrl = imageUrl;
        this.isExercise = isExercise;
        this.userProgress = userProgress;
        this.dayOfSigned = dayOfSigned;
        this.progressDay = progressDay;
        this.weekOfSigned = weekOfSigned;
        this.progressWeek = progressWeek;
        this.monthOfSigned = monthOfSigned;
        this.setHaveDoneByWeek = setHaveDoneByWeek;
        this.setsOfToday_24h = setsOfToday_24h;
        this.totalSetsHadDone = totalSetsHadDone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }


    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(float currentWeight) {
        this.currentWeight = currentWeight;
    }

    public UserProgress getUserProgress() {
        return userProgress;
    }

    public void setUserProgress(UserProgress userProgress) {
        this.userProgress = userProgress;
    }


    public int getDayOfSigned() {
        return dayOfSigned;
    }

    public void setDayOfSigned(int dayOfSigned) {
        this.dayOfSigned = dayOfSigned;
    }

    public int getProgressDay() {
        return progressDay;
    }

    public void setProgressDay(int progressDay) {
        this.progressDay = progressDay;
    }


    public int getWeekOfSigned() {
        return weekOfSigned;
    }

    public void setWeekOfSigned(int weekOfSigned) {
        this.weekOfSigned = weekOfSigned;
    }

    public int getProgressWeek() {
        return progressWeek;
    }

    public void setProgressWeek(int progressWeek) {
        this.progressWeek = progressWeek;
    }

    public int getMonthOfSigned() {
        return monthOfSigned;
    }

    public void setMonthOfSigned(int monthOfSigned) {
        this.monthOfSigned = monthOfSigned;
    }


    public ArrayList<SetsOfToday> getSetHaveDoneByWeek() {

        if (setHaveDoneByWeek == null){
            setHaveDoneByWeek = new ArrayList<>();
        }

        return setHaveDoneByWeek;
    }

    public void setSetHaveDoneByWeek(ArrayList<SetsOfToday> setHaveDoneByWeek) {
        this.setHaveDoneByWeek = setHaveDoneByWeek;
    }


    public ArrayList<SetsOfToday> getSetsOfToday_24h() {

        if (setsOfToday_24h == null){
            setsOfToday_24h = new ArrayList<>();
        }

        return setsOfToday_24h;
    }

    public void setSetsOfToday_24h(ArrayList<SetsOfToday> setsOfToday_24h) {
        this.setsOfToday_24h = setsOfToday_24h;
    }

    public void addItemFor24HExercise(SetsOfToday setsOfToday){
        this.setsOfToday_24h.add(setsOfToday);
    }


    public boolean isExercise() {
        return isExercise;
    }

    public void setExercise(boolean exercise) {
        isExercise = exercise;
    }


    public ArrayList<ArrayList<SetsOfToday>> getTotalSetsHadDone() {
        return totalSetsHadDone;
    }

    public void setTotalSetsHadDone(ArrayList<ArrayList<SetsOfToday>> totalSetsHadDone) {
        this.totalSetsHadDone = totalSetsHadDone;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", weight='" + weight + '\'' +
                ", currentWeight='" + currentWeight + '\'' +
                ", imageUrl=" + imageUrl +
                ", isExercise=" + isExercise +
                ", userProgress=" + userProgress +
                ", dayOfSigned=" + dayOfSigned +
                ", progressDay=" + progressDay +
                ", weekOfSigned=" + weekOfSigned +
                ", progressWeek=" + progressWeek +
                ", monthOfSigned=" + monthOfSigned +
                ", setHaveDoneByWeek=" + setHaveDoneByWeek +
                ", setsOfToday_24h=" + setsOfToday_24h +
                '}';
    }
}
