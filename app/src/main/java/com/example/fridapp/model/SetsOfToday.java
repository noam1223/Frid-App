package com.example.fridapp.model;

import com.example.fridapp.helpers.ExerciseEnumHelper;

import java.io.Serializable;
import java.util.Objects;

public class SetsOfToday implements Serializable {

    ExerciseEnumHelper exerciseEnumHelper;
    int numSet = 0;
    String day;

    public SetsOfToday() {

    }


    public SetsOfToday(ExerciseEnumHelper exerciseEnumHelper, int numSet, String day) {
        this.exerciseEnumHelper = exerciseEnumHelper;
        this.numSet = numSet;
        this.day = day;
    }

    public ExerciseEnumHelper getExerciseEnumHelper() {
        return exerciseEnumHelper;
    }

    public void setExerciseEnumHelper(ExerciseEnumHelper exerciseEnumHelper) {
        this.exerciseEnumHelper = exerciseEnumHelper;
    }

    public int getNumSet() {
        return numSet;
    }

    public void setNumSet(int numSet) {
        this.numSet = numSet;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "SetsOfToday{" +
                "exerciseEnumHelper=" + exerciseEnumHelper +
                ", numSet=" + numSet +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(exerciseEnumHelper, numSet);
    }
}
