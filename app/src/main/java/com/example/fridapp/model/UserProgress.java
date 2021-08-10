package com.example.fridapp.model;

import java.io.Serializable;

public class UserProgress implements Serializable {

   private int totalExerciseTobeDone = 84;
   private int numberOfExerciseToBeDoneByWeek = 7;
   private int totalOfExerciseDoneByNow = 0;
   private int numberOfExerciseDoneWeek = 0;

    public UserProgress() {

    }

    public int getTotalExerciseTobeDone() {
        return totalExerciseTobeDone;
    }

    public void setTotalExerciseTobeDone(int totalExerciseTobeDone) {
        this.totalExerciseTobeDone = totalExerciseTobeDone;
    }

    public int getNumberOfExerciseToBeDoneByWeek() {
        return numberOfExerciseToBeDoneByWeek;
    }

    public void setNumberOfExerciseToBeDoneByWeek(int numberOfExerciseToBeDoneByWeek) {
        this.numberOfExerciseToBeDoneByWeek = numberOfExerciseToBeDoneByWeek;
    }

    public int getTotalOfExerciseDoneByNow() {
        return totalOfExerciseDoneByNow;
    }

    public void setTotalOfExerciseDoneByNow(int totalOfExerciseDoneByNow) {
        this.totalOfExerciseDoneByNow = totalOfExerciseDoneByNow;
    }

    public int getNumberOfExerciseDoneWeek() {
        return numberOfExerciseDoneWeek;
    }

    public void setNumberOfExerciseDoneWeek(int numberOfExerciseDoneWeek) {
        this.numberOfExerciseDoneWeek = numberOfExerciseDoneWeek;
    }

    public int getPercentOfProgress() {

        if (totalOfExerciseDoneByNow > 0){

            return totalExerciseTobeDone/totalOfExerciseDoneByNow;

        } else return 0;
    }

}
