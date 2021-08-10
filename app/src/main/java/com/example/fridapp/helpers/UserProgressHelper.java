package com.example.fridapp.helpers;

import com.example.fridapp.model.SetsOfToday;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserProgressHelper implements Serializable {

    List<int[]> exerciseFullSet_1;
    List<int[]> exerciseFullSet_2;
    List<int[]> exerciseFullSet_3;
    List<int[]> exercises_items;

    int indexSet;

    String numOfExerciseHeb;
    String exerciseTypePath;
    String exeSubStrengthPath;

    String exeTypeHeb;
    String exeSubStrengthHeb;
    String exeNumOfActivitySet;

    ExerciseEnumHelper exerciseEnumHelper;

    SetsOfToday setsInProgressToday, exerciseSetTobeSave;

    int week;


    public UserProgressHelper(List<int[]> exerciseFullSet_1, List<int[]> exerciseFullSet_2) {
        this.exerciseFullSet_1 = exerciseFullSet_1;
        this.exerciseFullSet_2 = exerciseFullSet_2;
    }


    public UserProgressHelper() {

    }


    public List<int[]> getExerciseFullSet_1() {
        return exerciseFullSet_1;
    }

    public void setExerciseFullSet_1(List<int[]> exerciseFullSet_1) {
        this.exerciseFullSet_1 = exerciseFullSet_1;
    }

    public List<int[]> getExerciseFullSet_2() {
        return exerciseFullSet_2;
    }

    public void setExerciseFullSet_2(List<int[]> exerciseFullSet_2) {
        this.exerciseFullSet_2 = exerciseFullSet_2;
    }

    public List<int[]> getExerciseFullSet_3() {
        return exerciseFullSet_3;
    }

    public void setExerciseFullSet_3(List<int[]> exerciseFullSet_3) {
        this.exerciseFullSet_3 = exerciseFullSet_3;
    }






    public ExerciseEnumHelper getExerciseEnumHelper() {
        return exerciseEnumHelper;
    }


    public void setExerciseEnumHelper(ExerciseEnumHelper exerciseEnumHelper) {
        this.exerciseEnumHelper = exerciseEnumHelper;
    }


    public void setExerciseTypePath(String exerciseTypePath) {
        this.exerciseTypePath = exerciseTypePath;
    }

    public String getExerciseTypePath() {
        return exerciseTypePath;
    }


    public String getExeSubStrengthPath() {
        return exeSubStrengthPath;
    }

    public void setExeSubStrengthPath(String exeSubStrengthPath) {
        this.exeSubStrengthPath = exeSubStrengthPath;
    }


    public String getNumOfExerciseHeb() {
        return numOfExerciseHeb;
    }

    public void setNumOfExerciseHeb(String numOfExerciseHeb) {
        this.numOfExerciseHeb = numOfExerciseHeb;
    }

    public int getIndexSet() {
        return indexSet;
    }

    public void setIndexSet(int indexSet) {
        this.indexSet = indexSet;
    }


    public String getExeTypeHeb() {
        return exeTypeHeb;
    }


    public void setExeTypeHeb(String exeTypeHeb) {
        this.exeTypeHeb = exeTypeHeb;
    }



    public String getExeSubStrengthHeb() {
        return exeSubStrengthHeb;
    }



    public void setExeSubStrengthHeb(String exeSubStrengthHeb) {
        this.exeSubStrengthHeb = exeSubStrengthHeb;
    }




    public String getExeNumOfActivitySet() {
        return exeNumOfActivitySet;
    }




    public void setExeNumOfActivitySet(String exeNumOfActivitySet) {
        this.exeNumOfActivitySet = exeNumOfActivitySet;
    }

    public SetsOfToday getSetsInProgressToday() {
        return setsInProgressToday;
    }

    public void setSetsInProgressToday(SetsOfToday setsInProgressToday) {
        this.setsInProgressToday = setsInProgressToday;
    }


    public SetsOfToday getExerciseSetTobeSave() {
        return exerciseSetTobeSave;
    }

    public void setExerciseSetTobeSave(SetsOfToday exerciseSetTobeSave) {
        this.exerciseSetTobeSave = exerciseSetTobeSave;
    }

    public List<int[]> getExercises_items() {
        return exercises_items;
    }

    public void setExercises_items(List<int[]> exercises_items) {
        this.exercises_items = exercises_items;
    }


    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public List<int[]> getExerciseFullSetByIndex(){

        if (indexSet == 0){
            return exerciseFullSet_1;
        }else if (indexSet == 1){
            return exerciseFullSet_2;
        }else {
            return exerciseFullSet_3;
        }
    }


    public List<List<int[]>> getFullSetExercise(){

        List<List<int[]>> lists = new ArrayList<>();
        lists.add(exerciseFullSet_1);
        lists.add(exerciseFullSet_2);
        lists.add(exerciseFullSet_3);

        return lists;
    }


    @Override
    public String toString() {
        return "UserProgressHelper{" +
                "exerciseFullSet_1=" + exerciseFullSet_1 +
                ", exerciseFullSet_2=" + exerciseFullSet_2 +
                ", exerciseFullSet_3=" + exerciseFullSet_3 +
                ", exercises_items=" + exercises_items +
                ", indexSet=" + indexSet +
                ", numOfExerciseHeb='" + numOfExerciseHeb + '\'' +
                ", exerciseTypePath='" + exerciseTypePath + '\'' +
                ", exeSubStrengthPath='" + exeSubStrengthPath + '\'' +
                ", exeTypeHeb='" + exeTypeHeb + '\'' +
                ", exeSubStrengthHeb='" + exeSubStrengthHeb + '\'' +
                ", exeNumOfActivitySet='" + exeNumOfActivitySet + '\'' +
                ", exerciseEnumHelper=" + exerciseEnumHelper +
                ", setsInProgressToday=" + setsInProgressToday +
                ", exerciseSetTobeSave=" + exerciseSetTobeSave +
                '}';
    }
}
