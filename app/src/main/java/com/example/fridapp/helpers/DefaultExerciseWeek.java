package com.example.fridapp.helpers;

import com.example.fridapp.model.SetsOfToday;

import java.util.ArrayList;

public class DefaultExerciseWeek {

    ArrayList<SetsOfToday> defaultExercisesForWeek;
    ArrayList<SetsOfToday> fitItExerciseForWeek;


    public DefaultExerciseWeek() {

    }


    public ArrayList<SetsOfToday> getDefaultExercisesForWeek() {

        if (defaultExercisesForWeek == null){

            this.defaultExercisesForWeek = new ArrayList<>();

            this.defaultExercisesForWeek.add(new SetsOfToday(ExerciseEnumHelper.HANDS, 1, ""));
            this.defaultExercisesForWeek.add(new SetsOfToday(ExerciseEnumHelper.LEGS, 2, ""));
            this.defaultExercisesForWeek.add(new SetsOfToday(ExerciseEnumHelper.FULLBODY, 3, ""));

            this.defaultExercisesForWeek.add(new SetsOfToday(ExerciseEnumHelper.FLEXIBILITY, 1, ""));
            this.defaultExercisesForWeek.add(new SetsOfToday(ExerciseEnumHelper.FLEXIBILITY, 2, ""));

            this.defaultExercisesForWeek.add(new SetsOfToday(ExerciseEnumHelper.AEROBIC, 1, ""));
            this.defaultExercisesForWeek.add(new SetsOfToday(ExerciseEnumHelper.AEROBIC, 2, ""));

        }


        return defaultExercisesForWeek;
    }



    public void setDefaultExercisesForWeek(ArrayList<SetsOfToday> defaultExercisesForWeek) {
        this.defaultExercisesForWeek = defaultExercisesForWeek;
    }



    public ArrayList<SetsOfToday> getFitItExerciseForWeek() {

        if (fitItExerciseForWeek == null){

            this.fitItExerciseForWeek = new ArrayList<>();

            this.fitItExerciseForWeek.add(new SetsOfToday(ExerciseEnumHelper.HANDS, 1, "ראשון"));
            this.fitItExerciseForWeek.add(new SetsOfToday(ExerciseEnumHelper.FLEXIBILITY, 1, "שני"));
            this.fitItExerciseForWeek.add(new SetsOfToday(ExerciseEnumHelper.LEGS, 2, "שלישי"));
            this.fitItExerciseForWeek.add(new SetsOfToday(ExerciseEnumHelper.AEROBIC, 1, "רביעי"));
            this.fitItExerciseForWeek.add(new SetsOfToday(ExerciseEnumHelper.FLEXIBILITY, 2, "חמישי"));
            this.fitItExerciseForWeek.add(new SetsOfToday(ExerciseEnumHelper.FULLBODY, 3, "שישי"));
            this.fitItExerciseForWeek.add(new SetsOfToday(ExerciseEnumHelper.AEROBIC, 2, "שבת"));


        }


        return fitItExerciseForWeek;
    }

    public void setFitItExerciseForWeek(ArrayList<SetsOfToday> fitItExerciseForWeek) {
        this.fitItExerciseForWeek = fitItExerciseForWeek;
    }


}
