package com.example.fridapp.helpers;

import com.example.fridapp.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExerciseNumbersByWeek {


    // 1 - חזרות
    // 2 - שניות
    // 3 - כל צד
    // 4 - ניעות
    // 5 - כל צד שניות
    // 6 - כל צד ניעות

    public ExerciseNumbersByWeek() {


    }



    private int[] getInts(int[] set_1, int[] set_2) {
        int[] week_1_2_hands_set_3 = new int[set_1.length + set_2.length];
        System.arraycopy(set_1, 0, week_1_2_hands_set_3, 0, set_1.length);
        System.arraycopy(set_2, 0, week_1_2_hands_set_3, set_1.length, set_2.length);
        return week_1_2_hands_set_3;
    }



    private ArrayList<int[]> getSetThreeArray(int[] set_1, int[] set_2, int[] set_1_name, int[] set_2_name, int[] set_1_description, int[] set_2_description,
                                              int[] set_1_repeats, int[] set_2_repeats, int[] set_1_kindOfRepeats, int[] set_2_kindOfRepeats) {
        int[] week_set_3 = getInts(set_1, set_2);

        int[] week_names_set_3 = getInts(set_1_name, set_2_name);

        int[] week_descriptionNameString_set_3 = getInts(set_1_description , set_2_description);

        int[] week_repeats_set_3 = getInts(set_1_repeats, set_2_repeats);

        int[] week_kindOfRepeats_set_3 = getInts(set_1_kindOfRepeats, set_2_kindOfRepeats);

        return new ArrayList<>(Arrays.asList(week_set_3, week_names_set_3, week_descriptionNameString_set_3, week_repeats_set_3, week_kindOfRepeats_set_3));
    }





    /////////////////////////////////
    ////////HANDS

    private int[] week_1_2_hands_set_1 = {R.raw.e6,R.raw.e1,R.raw.e41,R.raw.e4,R.raw.e5};
    private int[] week_1_2_handsNameString_set_1 = {R.string.NAME_EXERCISE_6, R.string.NAME_EXERCISE_1, R.string.NAME_EXERCISE_41, R.string.NAME_EXERCISE_4, R.string.NAME_EXERCISE_5};
    private int[] week_1_2_handsDescriptionNameString_set_1 = {R.string.EXERCISE_6, R.string.EXERCISE_1, R.string.EXERCISE_41, R.string.EXERCISE_4, R.string.EXERCISE_5};
    private int[] week_1_2_handsRepeats_set_1 = {20, 10, 8, 15, 20};
    private int[] week_1_2_handsKindOfRepeat_set_1 = {1, 1, 1, 1, 1};


    private int[] week_1_2_hands_set_2 = {R.raw.e17,R.raw.e8 ,R.raw.e28,R.raw.e37,R.raw.e40};
    private int[] week_1_2_handsNameString_set_2 = {R.string.NAME_EXERCISE_17,R.string.NAME_EXERCISE_8 , R.string.NAME_EXERCISE_28, R.string.NAME_EXERCISE_37, R.string.NAME_EXERCISE_40};
    private int[] week_1_2_handsDescriptionNameString_set_2 = {R.string.EXERCISE_17,R.string.EXERCISE_8, R.string.EXERCISE_28, R.string.EXERCISE_37, R.string.EXERCISE_40};
    private int[] week_1_2_handsRepeats_set_2 = {40, 15, 40, 40, 15};
    private int[] week_1_2_handsKindOfRepeat_set_2 = {2, 1, 1, 2, 1};

    private int[] week_1_2_handsItems = {R.drawable.ic_mattress, R.drawable.ic_weight_3_5};
    private int[] week_1_2_handsItemsString = {R.string.EQUIPMENT_MATTRESS, R.string.EQUIPMENT_WEIGHT_1_3};

    private List<int[]> week_1_2_hands_set_1_list;
    private List<int[]> week_1_2_hands_set_2_list;
    private List<int[]> week_1_2_hands_set_3_list;




    private int[] week_3_4_hands_set_1 = {R.raw.e41,R.raw.e23,R.raw.e44,R.raw.e12,R.raw.e2};
    private int[] week_3_4_handsNameString_set_1 = {R.string.NAME_EXERCISE_41, R.string.NAME_EXERCISE_23, R.string.NAME_EXERCISE_44, R.string.NAME_EXERCISE_12, R.string.NAME_EXERCISE_2};
    private int[] week_3_4_handsDescriptionNameString_set_1 = {R.string.EXERCISE_41, R.string.EXERCISE_23, R.string.EXERCISE_44, R.string.EXERCISE_12, R.string.EXERCISE_2};
    private int[] week_3_4_handsRepeats_set_1 = {12, 20, 10, 10, 15};
    private int[] week_3_4_handsKindOfRepeat_set_1 = {1, 2, 1, 1, 1};


    private int[] week_3_4_hands_set_2 = {R.raw.e33,R.raw.e36,R.raw.e13,R.raw.e9,R.raw.e17};
    private int[] week_3_4_handsNameString_set_2 = {R.string.NAME_EXERCISE_33, R.string.NAME_EXERCISE_36, R.string.NAME_EXERCISE_13, R.string.NAME_EXERCISE_9, R.string.NAME_EXERCISE_17};
    private int[] week_3_4_handsDescriptionNameString_set_2 = {R.string.EXERCISE_33, R.string.EXERCISE_36, R.string.EXERCISE_13, R.string.EXERCISE_9, R.string.EXERCISE_17};
    private int[] week_3_4_handsRepeats_set_2 = {40, 8, 20, 20, 40};
    private int[] week_3_4_handsKindOfRepeat_set_2 = {1, 1, 2, 1, 2};

    private int[] week_3_4_handsItems = {R.drawable.ic_mattress};
    private int[] week_3_4_handsItemsString = {R.string.EQUIPMENT_MATTRESS};

    private List<int[]> week_3_4_hands_set_1_list;
    private List<int[]> week_3_4_hands_set_2_list;
    private List<int[]> week_3_4_hands_set_3_list;








    private int[] week_5_7_hands_set_1 = {R.raw.e18,R.raw.e26,R.raw.e22,R.raw.e11,R.raw.e2};
    private int[] week_5_7_handsNameString_set_1 = {R.string.NAME_EXERCISE_18, R.string.NAME_EXERCISE_26, R.string.NAME_EXERCISE_22, R.string.NAME_EXERCISE_11, R.string.NAME_EXERCISE_2};
    private int[] week_5_7_handsDescriptionNameString_set_1 = {R.string.EXERCISE_18, R.string.EXERCISE_26, R.string.EXERCISE_22, R.string.EXERCISE_11, R.string.EXERCISE_2};
    private int[] week_5_7_handsRepeats_set_1 = {30, 20, 15, 15, 15};
    private int[] week_5_7_handsKindOfRepeat_set_1 = {1, 2, 3, 1, 1};


    private int[] week_5_7_hands_set_2 = {R.raw.e36, R.raw.e45,R.raw.e35,R.raw.e37, R.raw.e41};
    private int[] week_5_7_handsNameString_set_2 = {R.string.NAME_EXERCISE_36, R.string.NAME_EXERCISE_45, R.string.NAME_EXERCISE_35, R.string.NAME_EXERCISE_37, R.string.NAME_EXERCISE_41};
    private int[] week_5_7_handsDescriptionNameString_set_2 = {R.string.EXERCISE_36, R.string.EXERCISE_45, R.string.EXERCISE_35, R.string.EXERCISE_37, R.string.EXERCISE_41};
    private int[] week_5_7_handsRepeats_set_2 = {10, 12, 15, 20, 15};
    private int[] week_5_7_handsKindOfRepeat_set_2 = {1, 3, 1, 2, 1};

    private int[] week_5_7_handsItems = {R.drawable.ic_mattress, R.drawable.ic_weight_3_5};
    private int[] week_5_7_handsItemsString = {R.string.EQUIPMENT_MATTRESS, R.string.EQUIPMENT_WEIGHT_1_3};

    private List<int[]> week_5_7_hands_set_1_list;
    private List<int[]> week_5_7_hands_set_2_list;
    private List<int[]> week_5_7_hands_set_3_list;






    private int[] week_6_8_hands_set_1 = {R.raw.e19, R.raw.e28, R.raw.e27, R.raw.e12, R.raw.e3};
    private int[] week_6_8_handsNameString_set_1 = {R.string.NAME_EXERCISE_19, R.string.NAME_EXERCISE_28, R.string.NAME_EXERCISE_27, R.string.NAME_EXERCISE_12, R.string.NAME_EXERCISE_3};
    private int[] week_6_8_handsDescriptionNameString_set_1 = {R.string.EXERCISE_19, R.string.EXERCISE_28, R.string.EXERCISE_27, R.string.EXERCISE_12, R.string.EXERCISE_3};
    private int[] week_6_8_handsRepeats_set_1 = {40, 20, 10, 8, 12};
    private int[] week_6_8_handsKindOfRepeat_set_1 = {2, 1, 3, 1, 1};


    private int[] week_6_8_hands_set_2 = {R.raw.e95 ,R.raw.e46, R.raw.e32, R.raw.e38, R.raw.e36};
    private int[] week_6_8_handsNameString_set_2 = {R.string.NAME_EXERCISE_95,R.string.NAME_EXERCISE_46, R.string.NAME_EXERCISE_32, R.string.NAME_EXERCISE_38, R.string.NAME_EXERCISE_36};
    private int[] week_6_8_handsDescriptionNameString_set_2 = {R.string.EXERCISE_95,R.string.EXERCISE_46, R.string.EXERCISE_32, R.string.EXERCISE_38, R.string.EXERCISE_36};
    private int[] week_6_8_handsRepeats_set_2 = {6, 12, 10, 30, 12};
    private int[] week_6_8_handsKindOfRepeat_set_2 = {1, 3, 3, 2, 1};

    private int[] week_6_8_handsItems = {R.drawable.ic_mattress,R.drawable.ic_weight_3_5, R.drawable.ic_weight_3_5};
    private int[] week_6_8_handsItemsString = {R.string.EQUIPMENT_MATTRESS,R.string.EQUIPMENT_WEIGHT_1_3, R.string.EQUIPMENT_WEIGHT_3_5};

    private List<int[]> week_6_8_hands_set_1_list;
    private List<int[]> week_6_8_hands_set_2_list;
    private List<int[]> week_6_8_hands_set_3_list;







    private int[] week_9_11_hands_set_1 = {R.raw.e48, R.raw.e38, R.raw.e49, R.raw.e43, R.raw.e52};
    private int[] week_9_11_handsNameString_set_1 = {R.string.NAME_EXERCISE_48, R.string.NAME_EXERCISE_38, R.string.NAME_EXERCISE_49, R.string.NAME_EXERCISE_43, R.string.NAME_EXERCISE_52};
    private int[] week_9_11_handsDescriptionNameString_set_1 = {R.string.EXERCISE_48, R.string.EXERCISE_38, R.string.EXERCISE_49, R.string.EXERCISE_43, R.string.EXERCISE_52};
    private int[] week_9_11_handsRepeats_set_1 = {12, 40, 15, 10, 10};
    private int[] week_9_11_handsKindOfRepeat_set_1 = {1, 2, 3, 1, 1};


    private int[] week_9_11_hands_set_2 = {R.raw.e31, R.raw.e15, R.raw.e30, R.raw.e25, R.raw.e17};
    private int[] week_9_11_handsNameString_set_2 = {R.string.NAME_EXERCISE_31, R.string.NAME_EXERCISE_15, R.string.NAME_EXERCISE_30, R.string.NAME_EXERCISE_25, R.string.NAME_EXERCISE_17};
    private int[] week_9_11_handsDescriptionNameString_set_2 = {R.string.EXERCISE_31, R.string.EXERCISE_15, R.string.EXERCISE_30, R.string.EXERCISE_25, R.string.EXERCISE_17};
    private int[] week_9_11_handsRepeats_set_2 = {10, 12, 10, 30, 30};
    private int[] week_9_11_handsKindOfRepeat_set_2 = {3, 3, 3, 2, 2};


    private int[] week_9_11_handsItems = {R.drawable.ic_mattress, R.drawable.ic_weight_3_5};
    private int[] week_9_11_handsItemsString = {R.string.EQUIPMENT_MATTRESS, R.string.EQUIPMENT_WEIGHT_3_5};


    private List<int[]> week_9_11_hands_set_1_list;
    private List<int[]> week_9_11_hands_set_2_list;
    private List<int[]> week_9_11_hands_set_3_list;







    private int[] week_10_hands_set_1 = {R.raw.e81 ,R.raw.e60, R.raw.e72, R.raw.e85, R.raw.e39};
    private int[] week_10_handsNameString_set_1 = { R.string.NAME_EXERCISE_81,R.string.NAME_EXERCISE_60, R.string.NAME_EXERCISE_72, R.string.NAME_EXERCISE_85, R.string.NAME_EXERCISE_39};
    private int[] week_10_handsDescriptionNameString_set_1 = { R.string.EXERCISE_81,R.string.EXERCISE_60, R.string.EXERCISE_72, R.string.EXERCISE_85, R.string.EXERCISE_39};
    private int[] week_10_handsRepeats_set_1 = {15, 16, 30, 15, 10};
    private int[] week_10_handsKindOfRepeat_set_1 = {3, 1, 5, 1, 1};



    private int[] week_10_hands_set_2 = {R.raw.e84, R.raw.e14, R.raw.e63, R.raw.e54, R.raw.e86};
    private int[] week_10_handsNameString_set_2 = {R.string.NAME_EXERCISE_84, R.string.NAME_EXERCISE_14, R.string.NAME_EXERCISE_63, R.string.NAME_EXERCISE_54, R.string.NAME_EXERCISE_86};
    private int[] week_10_handsDescriptionNameString_set_2 = {R.string.EXERCISE_84, R.string.EXERCISE_14, R.string.EXERCISE_63, R.string.EXERCISE_54, R.string.EXERCISE_86};
    private int[] week_10_handsRepeats_set_2 = {50, 25, 15, 15, 10};
    private int[] week_10_handsKindOfRepeat_set_2 = {1, 5, 1, 3, 1};


    private int[] week_10_handsItems = {R.drawable.ic_mattress, R.drawable.noun_resistance};
    private int[] week_10_handsItemsString = {R.string.EQUIPMENT_MATTRESS, R.string.EQUIPMENT_NOUN_RESISTANCE};


    private List<int[]> week_10_hands_set_1_list;
    private List<int[]> week_10_hands_set_2_list;
    private List<int[]> week_10_hands_set_3_list;



    private int[] week_12_hands_set_1 = {R.raw.e82, R.raw.e94, R.raw.e66, R.raw.e53, R.raw.e86};
    private int[] week_12_handsNameString_set_1 = {R.string.NAME_EXERCISE_82, R.string.NAME_EXERCISE_94, R.string.NAME_EXERCISE_66, R.string.NAME_EXERCISE_53, R.string.NAME_EXERCISE_86};
    private int[] week_12_handsDescriptionNameString_set_1 = {R.string.EXERCISE_82, R.string.EXERCISE_94, R.string.EXERCISE_66, R.string.EXERCISE_53, R.string.EXERCISE_86};
    private int[] week_12_handsRepeats_set_1 = {15, 40, 15, 12, 10};
    private int[] week_12_handsKindOfRepeat_set_1 = {1, 2, 1, 3, 1};



    private int[] week_12_hands_set_2 = {R.raw.e84, R.raw.e77, R.raw.e88, R.raw.e64, R.raw.e87};
    private int[] week_12_handsNameString_set_2 = {R.string.NAME_EXERCISE_84, R.string.NAME_EXERCISE_77, R.string.NAME_EXERCISE_88, R.string.NAME_EXERCISE_64, R.string.NAME_EXERCISE_87};
    private int[] week_12_handsDescriptionNameString_set_2 = {R.string.EXERCISE_84, R.string.EXERCISE_77, R.string.EXERCISE_88, R.string.EXERCISE_64, R.string.EXERCISE_87};
    private int[] week_12_handsRepeats_set_2 = {60, 20, 20, 20, 20};
    private int[] week_12_handsKindOfRepeat_set_2 = {2, 3, 1, 1, 1};

    private int[] week_12_handsItems = {R.drawable.ic_mattress, R.drawable.ic_stair_step ,R.drawable.noun_resistance};
    private int[] week_12_handsItemsString = {R.string.EQUIPMENT_MATTRESS, R.string.EQUIPMENT_STEP, R.string.EQUIPMENT_WEIGHT_3_5};


    private List<int[]> week_12_hands_set_1_list;
    private List<int[]> week_12_hands_set_2_list;
    private List<int[]> week_12_hands_set_3_list;







    public List<List<int[]>> getListHandsByWeek(int week) {

        List<List<int[]>> lists = new ArrayList<>();

        if (week == 0 || week == 1) {

            this.week_1_2_hands_set_1_list = new ArrayList<>(Arrays.asList(this.week_1_2_hands_set_1, this.week_1_2_handsNameString_set_1, this.week_1_2_handsDescriptionNameString_set_1, this.week_1_2_handsRepeats_set_1, this.week_1_2_handsKindOfRepeat_set_1));
            this.week_1_2_hands_set_2_list = new ArrayList<>(Arrays.asList(this.week_1_2_hands_set_2, this.week_1_2_handsNameString_set_2, this.week_1_2_handsDescriptionNameString_set_2, this.week_1_2_handsRepeats_set_2, this.week_1_2_handsKindOfRepeat_set_2));

            this.week_1_2_hands_set_3_list = getSetThreeArray(week_1_2_hands_set_1, week_1_2_hands_set_2, week_1_2_handsNameString_set_1, week_1_2_handsNameString_set_2,
                    week_1_2_handsDescriptionNameString_set_1, week_1_2_handsDescriptionNameString_set_2, week_1_2_handsRepeats_set_1, week_1_2_handsRepeats_set_2,
                    week_1_2_handsKindOfRepeat_set_1, week_1_2_handsKindOfRepeat_set_2);

            lists.add(this.week_1_2_hands_set_1_list);
            lists.add(this.week_1_2_hands_set_2_list);
            lists.add(this.week_1_2_hands_set_3_list);


        } else if (week == 2 || week == 3) {

            this.week_3_4_hands_set_1_list = new ArrayList<>(Arrays.asList(this.week_3_4_hands_set_1, this.week_3_4_handsNameString_set_1, this.week_3_4_handsDescriptionNameString_set_1, this.week_3_4_handsRepeats_set_1, this.week_3_4_handsKindOfRepeat_set_1));
            this.week_3_4_hands_set_2_list = new ArrayList<>(Arrays.asList(this.week_3_4_hands_set_2, this.week_3_4_handsNameString_set_2, this.week_3_4_handsDescriptionNameString_set_2, this.week_3_4_handsRepeats_set_2, this.week_3_4_handsKindOfRepeat_set_2));

            this.week_3_4_hands_set_3_list = getSetThreeArray(week_3_4_hands_set_1, week_3_4_hands_set_2, week_3_4_handsNameString_set_1, week_3_4_handsNameString_set_2,
                    week_3_4_handsDescriptionNameString_set_1, week_3_4_handsDescriptionNameString_set_2, week_3_4_handsRepeats_set_1, week_3_4_handsRepeats_set_2,
                    week_3_4_handsKindOfRepeat_set_1, week_3_4_handsKindOfRepeat_set_2);

            lists.add(this.week_3_4_hands_set_1_list);
            lists.add(this.week_3_4_hands_set_2_list);
            lists.add(this.week_3_4_hands_set_3_list);


        } else if (week == 4 || week == 6) {


            this.week_5_7_hands_set_1_list = new ArrayList<>(Arrays.asList(this.week_5_7_hands_set_1, this.week_5_7_handsNameString_set_1, this.week_5_7_handsDescriptionNameString_set_1, this.week_5_7_handsRepeats_set_1, this.week_5_7_handsKindOfRepeat_set_1));
            this.week_5_7_hands_set_2_list = new ArrayList<>(Arrays.asList(this.week_5_7_hands_set_2, this.week_5_7_handsNameString_set_2, this.week_5_7_handsDescriptionNameString_set_2, this.week_5_7_handsRepeats_set_2, this.week_5_7_handsKindOfRepeat_set_2));

            int[] week_5_7_hands_set_3 = new int[week_5_7_hands_set_1.length + week_5_7_hands_set_2.length];
            int[] week_5_7_handsNameString_set_3 = new int[week_5_7_handsNameString_set_1.length + week_5_7_handsNameString_set_2.length];
            int[] week_5_7_handsDescriptionNameString_set_3 = new int[week_5_7_handsDescriptionNameString_set_1.length + week_5_7_handsDescriptionNameString_set_2.length];
            int[] week_5_7_handsRepeats_set_3 = new int[week_5_7_handsRepeats_set_1.length + week_5_7_handsRepeats_set_2.length];
            int[] week_5_7_handsKindOfRepeat_set_3 = new int[week_5_7_handsKindOfRepeat_set_1.length + week_5_7_handsKindOfRepeat_set_2.length];


            week_5_7_hands_set_3[0] = week_5_7_hands_set_1[0];
            week_5_7_hands_set_3[1] = week_5_7_hands_set_2[0];
            week_5_7_handsNameString_set_3[0] = week_5_7_handsNameString_set_1[0];
            week_5_7_handsNameString_set_3[1] = week_5_7_handsNameString_set_2[0];
            week_5_7_handsDescriptionNameString_set_3[0] = week_5_7_handsDescriptionNameString_set_1[0];
            week_5_7_handsDescriptionNameString_set_3[1] = week_5_7_handsDescriptionNameString_set_2[0];
            week_5_7_handsRepeats_set_3[0] = week_5_7_handsRepeats_set_1[0];
            week_5_7_handsRepeats_set_3[1] = week_5_7_handsRepeats_set_2[0];
            week_5_7_handsKindOfRepeat_set_3[0] = week_5_7_handsKindOfRepeat_set_1[0];
            week_5_7_handsKindOfRepeat_set_3[1] = week_5_7_handsKindOfRepeat_set_2[0];

            int iSetOne = 1;
            int iSetTwo = 1;

            for (int i = 2; i < week_5_7_hands_set_3.length ; i++) {

                if (i % 2 == 0){

                    week_5_7_hands_set_3[i] = week_5_7_hands_set_1[iSetOne];
                    week_5_7_handsNameString_set_3[i] = week_5_7_handsNameString_set_1[iSetOne];
                    week_5_7_handsDescriptionNameString_set_3[i] = week_5_7_handsDescriptionNameString_set_1[iSetOne];
                    week_5_7_handsRepeats_set_3[i] = week_5_7_handsRepeats_set_1[iSetOne];
                    week_5_7_handsKindOfRepeat_set_3[i] = week_5_7_handsKindOfRepeat_set_1[iSetOne];
                    iSetOne++;


                } else {

                    week_5_7_hands_set_3[i] = week_5_7_hands_set_2[iSetTwo];
                    week_5_7_handsNameString_set_3[i] = week_5_7_handsNameString_set_2[iSetTwo];
                    week_5_7_handsDescriptionNameString_set_3[i] = week_5_7_handsDescriptionNameString_set_2[iSetTwo];
                    week_5_7_handsRepeats_set_3[i] = week_5_7_handsRepeats_set_2[iSetTwo];
                    week_5_7_handsKindOfRepeat_set_3[i] = week_5_7_handsKindOfRepeat_set_2[iSetTwo];
                    iSetTwo++;

                }

            }

            this.week_5_7_hands_set_3_list = new ArrayList<>(Arrays.asList(week_5_7_hands_set_3, week_5_7_handsNameString_set_3, week_5_7_handsDescriptionNameString_set_3, week_5_7_handsRepeats_set_3, week_5_7_handsKindOfRepeat_set_3));



            lists.add(this.week_5_7_hands_set_1_list);
            lists.add(this.week_5_7_hands_set_2_list);
            lists.add(this.week_5_7_hands_set_3_list);



        } else if (week == 5 || week == 7) {

            this.week_6_8_hands_set_1_list = new ArrayList<>(Arrays.asList(this.week_6_8_hands_set_1, this.week_6_8_handsNameString_set_1, this.week_6_8_handsDescriptionNameString_set_1, this.week_6_8_handsRepeats_set_1, this.week_6_8_handsKindOfRepeat_set_1));
            this.week_6_8_hands_set_2_list = new ArrayList<>(Arrays.asList(this.week_6_8_hands_set_2, this.week_6_8_handsNameString_set_2, this.week_6_8_handsDescriptionNameString_set_2, this.week_6_8_handsRepeats_set_2, this.week_6_8_handsKindOfRepeat_set_2));



            int[] week_6_8_hands_set_3 = new int[week_6_8_hands_set_1.length + week_6_8_hands_set_2.length];
            int[] week_6_8_handsNameString_set_3 = new int[week_6_8_handsNameString_set_1.length + week_6_8_handsNameString_set_2.length];
            int[] week_6_8_handsDescriptionNameString_set_3 = new int[week_6_8_handsDescriptionNameString_set_1.length + week_6_8_handsDescriptionNameString_set_2.length];
            int[] week_6_8_handsRepeats_set_3 = new int[week_5_7_handsRepeats_set_1.length + week_5_7_handsRepeats_set_2.length];
            int[] week_6_8_handsKindOfRepeat_set_3 = new int[week_5_7_handsKindOfRepeat_set_1.length + week_5_7_handsKindOfRepeat_set_2.length];



            week_6_8_hands_set_3[0] = week_6_8_hands_set_1[0];
            week_6_8_hands_set_3[1] = week_6_8_hands_set_2[0];
            week_6_8_handsNameString_set_3[0] = week_6_8_handsNameString_set_1[0];
            week_6_8_handsNameString_set_3[1] = week_6_8_handsNameString_set_2[0];
            week_6_8_handsDescriptionNameString_set_3[0] = week_6_8_handsDescriptionNameString_set_1[0];
            week_6_8_handsDescriptionNameString_set_3[1] = week_6_8_handsDescriptionNameString_set_2[0];
            week_6_8_handsRepeats_set_3[0] = week_6_8_handsRepeats_set_1[0];
            week_6_8_handsRepeats_set_3[1] = week_6_8_handsRepeats_set_2[0];
            week_6_8_handsKindOfRepeat_set_3[0] = week_6_8_handsKindOfRepeat_set_1[0];
            week_6_8_handsKindOfRepeat_set_3[1] = week_6_8_handsKindOfRepeat_set_2[0];


            int iSetOne = 1;
            int iSetTwo = 1;

            for (int i = 2; i < week_6_8_hands_set_3.length ; i++) {

                if (i % 2 == 0){

                    week_6_8_hands_set_3[i] = week_6_8_hands_set_1[iSetOne];
                    week_6_8_handsNameString_set_3[i] = week_6_8_handsNameString_set_1[iSetOne];
                    week_6_8_handsDescriptionNameString_set_3[i] = week_6_8_handsDescriptionNameString_set_1[iSetOne];
                    week_6_8_handsRepeats_set_3[i] = week_6_8_handsRepeats_set_1[iSetOne];
                    week_6_8_handsKindOfRepeat_set_3[i] = week_6_8_handsKindOfRepeat_set_1[iSetOne];
                    iSetOne++;


                } else {

                    week_6_8_hands_set_3[i] = week_6_8_hands_set_2[iSetTwo];
                    week_6_8_handsNameString_set_3[i] = week_6_8_handsNameString_set_2[iSetTwo];
                    week_6_8_handsDescriptionNameString_set_3[i] = week_6_8_handsDescriptionNameString_set_2[iSetTwo];
                    week_6_8_handsRepeats_set_3[i] = week_6_8_handsRepeats_set_2[iSetTwo];
                    week_6_8_handsKindOfRepeat_set_3[i] = week_6_8_handsKindOfRepeat_set_2[iSetTwo];
                    iSetTwo++;

                }

            }


            this.week_6_8_hands_set_3_list = new ArrayList<>(Arrays.asList(week_6_8_hands_set_3, week_6_8_handsNameString_set_3, week_6_8_handsDescriptionNameString_set_3, week_6_8_handsRepeats_set_3, week_6_8_handsKindOfRepeat_set_3));




            lists.add(this.week_6_8_hands_set_1_list);
            lists.add(this.week_6_8_hands_set_2_list);
            lists.add(this.week_6_8_hands_set_3_list);

        } else if (week == 8 || week == 10) {



            this.week_9_11_hands_set_1_list = new ArrayList<>(Arrays.asList(this.week_9_11_hands_set_1, this.week_9_11_handsNameString_set_1, this.week_9_11_handsDescriptionNameString_set_1, this.week_9_11_handsRepeats_set_1, this.week_9_11_handsKindOfRepeat_set_1));
            this.week_9_11_hands_set_2_list = new ArrayList<>(Arrays.asList(this.week_9_11_hands_set_2, this.week_9_11_handsNameString_set_2, this.week_9_11_handsDescriptionNameString_set_2, this.week_9_11_handsRepeats_set_2, this.week_9_11_handsKindOfRepeat_set_2));


            this.week_9_11_hands_set_3_list = getSetThreeArray(week_9_11_hands_set_2, week_9_11_hands_set_1, week_9_11_handsNameString_set_2, week_9_11_handsNameString_set_1,
                    week_9_11_handsDescriptionNameString_set_2, week_9_11_handsDescriptionNameString_set_1, week_9_11_handsRepeats_set_2, week_9_11_handsRepeats_set_1
                    , week_9_11_handsKindOfRepeat_set_2, week_9_11_handsKindOfRepeat_set_1);

            lists.add(this.week_9_11_hands_set_1_list);
            lists.add(this.week_9_11_hands_set_2_list);
            lists.add(this.week_9_11_hands_set_3_list);




        } else if (week == 9) {


            this.week_10_hands_set_1_list = new ArrayList<>(Arrays.asList(this.week_10_hands_set_1, this.week_10_handsNameString_set_1, this.week_10_handsDescriptionNameString_set_1, this.week_10_handsRepeats_set_1, this.week_10_handsKindOfRepeat_set_1));
            this.week_10_hands_set_2_list = new ArrayList<>(Arrays.asList(this.week_10_hands_set_2, this.week_10_handsNameString_set_2, this.week_10_handsDescriptionNameString_set_2, this.week_10_handsRepeats_set_2, this.week_10_handsKindOfRepeat_set_2));

            this.week_10_hands_set_3_list = getSetThreeArray(week_10_hands_set_2, week_10_hands_set_1, week_10_handsNameString_set_2, week_10_handsNameString_set_1,
                    week_10_handsDescriptionNameString_set_2, week_10_handsDescriptionNameString_set_1, week_10_handsRepeats_set_2, week_10_handsRepeats_set_1
                    , week_10_handsKindOfRepeat_set_2, week_10_handsKindOfRepeat_set_1);

            lists.add(this.week_10_hands_set_1_list);
            lists.add(this.week_10_hands_set_2_list);
            lists.add(this.week_10_hands_set_3_list);


        } else if (week == 11) {



            this.week_12_hands_set_1_list = new ArrayList<>(Arrays.asList(this.week_12_hands_set_1, this.week_12_handsNameString_set_1, this.week_12_handsDescriptionNameString_set_1, this.week_12_handsRepeats_set_1, this.week_12_handsKindOfRepeat_set_1));
            this.week_12_hands_set_2_list = new ArrayList<>(Arrays.asList(this.week_12_hands_set_2, this.week_12_handsNameString_set_2, this.week_12_handsDescriptionNameString_set_2, this.week_12_handsRepeats_set_2, this.week_12_handsKindOfRepeat_set_2));


            this.week_12_hands_set_3_list = getSetThreeArray(week_12_hands_set_2, week_12_hands_set_1, week_12_handsNameString_set_2, week_12_handsNameString_set_1,
                    week_12_handsDescriptionNameString_set_2, week_12_handsDescriptionNameString_set_1, week_12_handsRepeats_set_2, week_12_handsRepeats_set_1
                    ,week_12_handsKindOfRepeat_set_1, week_12_handsKindOfRepeat_set_2);

            lists.add(this.week_12_hands_set_1_list);
            lists.add(this.week_12_hands_set_2_list);
            lists.add(this.week_12_hands_set_3_list);




        }

        return lists;

    }





    public List<int[]> getExerciseItemHandsListByWeek(int week){

        List<int[]> exerciseItemList = new ArrayList<>();

        if (week == 0 || week == 1){

            exerciseItemList.add(week_1_2_handsItems);
            exerciseItemList.add(week_1_2_handsItemsString);

        } else if (week == 2 || week == 3){

            exerciseItemList.add(week_3_4_handsItems);
            exerciseItemList.add(week_3_4_handsItemsString);

        } else if (week == 4 || week == 6){

            exerciseItemList.add(week_5_7_handsItems);
            exerciseItemList.add(week_5_7_handsItemsString);

        } else if (week == 5 || week == 7){

            exerciseItemList.add(week_6_8_handsItems);
            exerciseItemList.add(week_6_8_handsItemsString);

        } else if (week == 8 || week == 10){

            exerciseItemList.add(week_9_11_handsItems);
            exerciseItemList.add(week_9_11_handsItemsString);

        } else if (week == 9){

            exerciseItemList.add(week_10_handsItems);
            exerciseItemList.add(week_10_handsItemsString);

        } else if (week == 11){

            exerciseItemList.add(week_12_handsItems);
            exerciseItemList.add(week_12_handsItemsString);

        }

        return exerciseItemList;
    }





    /////////////////////////////////
    ////////LEGS



    private int[] week_1_2_legs_set_1 = {R.raw.e71, R.raw.e65, R.raw.e70, R.raw.e54, R.raw.e94};
    private int[] week_1_2_legsNameString_set_1 = {R.string.NAME_EXERCISE_71, R.string.NAME_EXERCISE_65, R.string.NAME_EXERCISE_70, R.string.NAME_EXERCISE_54, R.string.NAME_EXERCISE_94};
    private int[] week_1_2_legsDescriptionNameString_set_1 = {R.string.EXERCISE_71, R.string.EXERCISE_65, R.string.EXERCISE_70, R.string.EXERCISE_54, R.string.EXERCISE_94};
    private int[] week_1_2_legsRepeats_set_1 = {40, 15, 30, 15, 20};
    private int[] week_1_2_legsKindOfRepeat_set_1 = {2, 1, 1, 3, 1};


    private int[] week_1_2_legs_set_2 = {R.raw.e83, R.raw.e76, R.raw.e67, R.raw.e92, R.raw.e63};
    private int[] week_1_2_legsNameString_set_2 = {R.string.NAME_EXERCISE_83, R.string.NAME_EXERCISE_76, R.string.NAME_EXERCISE_67, R.string.NAME_EXERCISE_92, R.string.NAME_EXERCISE_63};
    private int[] week_1_2_legsDescriptionNameString_set_2 = {R.string.EXERCISE_83, R.string.EXERCISE_76, R.string.EXERCISE_67, R.string.EXERCISE_92, R.string.EXERCISE_63};
    private int[] week_1_2_legsRepeats_set_2 = {40, 20, 60, 10, 15};
    private int[] week_1_2_legsKindOfRepeat_set_2 = {1, 1, 1, 1, 1};

    private int[] week_1_2_legsItems = {R.drawable.ic_mattress, R.drawable.ic_stair_step};
    private int[] week_1_2_legsItemsString = {R.string.EQUIPMENT_MATTRESS, R.string.EQUIPMENT_STEP};


    private List<int[]> week_1_2_legs_set_1_list;
    private List<int[]> week_1_2_legs_set_2_list;
    private List<int[]> week_1_2_legs_set_3_list;


    private int[] week_3_4_legs_set_1 = {R.raw.e56, R.raw.e67, R.raw.e68, R.raw.e64, R.raw.e51};
    private int[] week_3_4_legsNameString_set_1 = {R.string.NAME_EXERCISE_56, R.string.NAME_EXERCISE_67, R.string.NAME_EXERCISE_68, R.string.NAME_EXERCISE_64, R.string.NAME_EXERCISE_51};
    private int[] week_3_4_legsDescriptionNameString_set_1 = {R.string.EXERCISE_56, R.string.EXERCISE_67, R.string.EXERCISE_68, R.string.EXERCISE_64, R.string.EXERCISE_51};
    private int[] week_3_4_legsRepeats_set_1 = {8, 40, 20, 15, 10};
    private int[] week_3_4_legsKindOfRepeat_set_1 = {3, 2, 3, 1, 1};



    private int[] week_3_4_legs_set_2 = {R.raw.e75, R.raw.e66, R.raw.e58, R.raw.e84, R.raw.e77};
    private int[] week_3_4_legsNameString_set_2 = {R.string.NAME_EXERCISE_75, R.string.NAME_EXERCISE_66, R.string.NAME_EXERCISE_58, R.string.NAME_EXERCISE_84, R.string.NAME_EXERCISE_77};
    private int[] week_3_4_legsDescriptionNameString_set_2 = {R.string.EXERCISE_75, R.string.EXERCISE_66, R.string.EXERCISE_58, R.string.EXERCISE_84, R.string.EXERCISE_77};
    private int[] week_3_4_legsRepeats_set_2 = {15, 12, 10, 50, 10};
    private int[] week_3_4_legsKindOfRepeat_set_2 = {3, 1, 3, 1, 3};


    private int[] week_3_4_legsItems = {R.drawable.ic_mattress, R.drawable.ic_stair_step};
    private int[] week_3_4_legsItemsString = {R.string.EQUIPMENT_MATTRESS, R.string.EQUIPMENT_STEP, R.string.EQUIPMENT_WEIGHT_1_3};


    private List<int[]> week_3_4_legs_set_1_list;
    private List<int[]> week_3_4_legs_set_2_list;
    private List<int[]> week_3_4_legs_set_3_list;


    private int[] week_5_7_legs_set_1 = {R.raw.e76, R.raw.e72, R.raw.e55, R.raw.e85, R.raw.e58};
    private int[] week_5_7_legsNameString_set_1 = {R.string.NAME_EXERCISE_76, R.string.NAME_EXERCISE_72, R.string.NAME_EXERCISE_55, R.string.NAME_EXERCISE_85, R.string.NAME_EXERCISE_58};
    private int[] week_5_7_legsDescriptionNameString_set_1 = {R.string.EXERCISE_76, R.string.EXERCISE_72, R.string.EXERCISE_55, R.string.EXERCISE_85, R.string.EXERCISE_58};
    private int[] week_5_7_legsRepeats_set_1 = {8, 30, 24, 12, 8};
    private int[] week_5_7_legsKindOfRepeat_set_1 = {3, 5, 1, 1, 3};



    private int[] week_5_7_legs_set_2 = {R.raw.e87, R.raw.e14, R.raw.e86, R.raw.e64, R.raw.e68};
    private int[] week_5_7_legsNameString_set_2 = {R.string.NAME_EXERCISE_87, R.string.NAME_EXERCISE_14, R.string.NAME_EXERCISE_86, R.string.NAME_EXERCISE_64, R.string.NAME_EXERCISE_68};
    private int[] week_5_7_legsDescriptionNameString_set_2 = {R.string.EXERCISE_87, R.string.EXERCISE_14, R.string.EXERCISE_86, R.string.EXERCISE_64, R.string.EXERCISE_68};
    private int[] week_5_7_legsRepeats_set_2 = {15, 20, 8, 15, 25};
    private int[] week_5_7_legsKindOfRepeat_set_2 = {1, 5, 1, 1, 3};


    private int[] week_5_7_legsItems = {R.drawable.ic_mattress, R.drawable.ic_stair_step, R.drawable.ic_weight_3_5};
    private int[] week_5_7_legsItemsString = {R.string.EQUIPMENT_MATTRESS, R.string.EQUIPMENT_STEP,R.string.EQUIPMENT_WEIGHT_1_3};


    private List<int[]> week_5_7_legs_set_1_list;
    private List<int[]> week_5_7_legs_set_2_list;
    private List<int[]> week_5_7_legs_set_3_list;


    private int[] week_6_8_legs_set_1 = {R.raw.e80, R.raw.e83, R.raw.e94, R.raw.e61, R.raw.e88};
    private int[] week_6_8_legsNameString_set_1 = {R.string.NAME_EXERCISE_80, R.string.NAME_EXERCISE_83, R.string.NAME_EXERCISE_94, R.string.NAME_EXERCISE_61, R.string.NAME_EXERCISE_88};
    private int[] week_6_8_legsDescriptionNameString_set_1 = {R.string.EXERCISE_80, R.string.EXERCISE_83, R.string.EXERCISE_94, R.string.EXERCISE_61, R.string.EXERCISE_88};
    private int[] week_6_8_legsRepeats_set_1 = {15, 40, 30, 10, 15};
    private int[] week_6_8_legsKindOfRepeat_set_1 = {3, 1, 1, 3, 1};



    private int[] week_6_8_legs_set_2 = {R.raw.e74, R.raw.e53, R.raw.e64, R.raw.e90, R.raw.e89};
    private int[] week_6_8_legsNameString_set_2 = {R.string.NAME_EXERCISE_74, R.string.NAME_EXERCISE_53, R.string.NAME_EXERCISE_64, R.string.NAME_EXERCISE_90, R.string.NAME_EXERCISE_89};
    private int[] week_6_8_legsDescriptionNameString_set_2 = {R.string.EXERCISE_74, R.string.EXERCISE_53, R.string.EXERCISE_64, R.string.EXERCISE_90, R.string.EXERCISE_89};
    private int[] week_6_8_legsRepeats_set_2 = {12, 10, 15, 10, 10};
    private int[] week_6_8_legsKindOfRepeat_set_2 = {3, 3, 1, 3, 1};

    private int[] week_6_8_legsItems = {R.drawable.ic_mattress, R.drawable.ic_weight_3_5};
    private int[] week_6_8_legsItemsString = {R.string.EQUIPMENT_MATTRESS, R.string.EQUIPMENT_WEIGHT_3_5};


    private List<int[]> week_6_8_legs_set_1_list;
    private List<int[]> week_6_8_legs_set_2_list;
    private List<int[]> week_6_8_legs_set_3_list;


    private int[] week_9_11_legs_set_1 = {R.raw.e83, R.raw.e21, R.raw.e6, R.raw.e33, R.raw.e91};
    private int[] week_9_11_legsNameString_set_1 = {R.string.NAME_EXERCISE_83, R.string.NAME_EXERCISE_21, R.string.NAME_EXERCISE_6, R.string.NAME_EXERCISE_33, R.string.NAME_EXERCISE_91};
    private int[] week_9_11_legsDescriptionNameString_set_1 = {R.string.EXERCISE_83, R.string.EXERCISE_21, R.string.EXERCISE_6, R.string.EXERCISE_33, R.string.EXERCISE_91};
    private int[] week_9_11_legsRepeats_set_1 = {50, 25, 60, 60, 20};
    private int[] week_9_11_legsKindOfRepeat_set_1 = {1, 3, 1, 1, 1};



    private int[] week_9_11_legs_set_2 = {R.raw.e67, R.raw.e4, R.raw.e10, R.raw.e16, R.raw.e96};
    private int[] week_9_11_legsNameString_set_2 = {R.string.NAME_EXERCISE_67, R.string.NAME_EXERCISE_4, R.string.NAME_EXERCISE_10, R.string.NAME_EXERCISE_16, R.string.NAME_EXERCISE_96};
    private int[] week_9_11_legsDescriptionNameString_set_2 = {R.string.EXERCISE_67, R.string.EXERCISE_4, R.string.EXERCISE_10, R.string.EXERCISE_16, R.string.EXERCISE_96};
    private int[] week_9_11_legsRepeats_set_2 = {40, 15, 30, 20, 20};
    private int[] week_9_11_legsKindOfRepeat_set_2 = {2, 1, 1, 5, 1};


    private int[] week_9_11_legsItems = {R.drawable.ic_mattress, R.drawable.ic_weight_3_5};
    private int[] week_9_11_legsItemsString = {R.string.EQUIPMENT_MATTRESS, R.string.EQUIPMENT_WEIGHT_1_3};


    private List<int[]> week_9_11_legs_set_1_list;
    private List<int[]> week_9_11_legs_set_2_list;
    private List<int[]> week_9_11_legs_set_3_list;




    private int[] week_10_legs_set_1 = {R.raw.e37, R.raw.e35, R.raw.e50, R.raw.e45, R.raw.e34};
    private int[] week_10_legsNameString_set_1 = {R.string.NAME_EXERCISE_37, R.string.NAME_EXERCISE_35, R.string.NAME_EXERCISE_50, R.string.NAME_EXERCISE_45, R.string.NAME_EXERCISE_34};
    private int[] week_10_legsDescriptionNameString_set_1 = {R.string.EXERCISE_37, R.string.EXERCISE_35, R.string.EXERCISE_50, R.string.EXERCISE_45, R.string.EXERCISE_34};
    private int[] week_10_legsRepeats_set_1 = {40, 12, 8, 12, 15};
    private int[] week_10_legsKindOfRepeat_set_1 = {2, 1, 1, 3, 1};



    private int[] week_10_legs_set_2 = {R.raw.e20, R.raw.e29, R.raw.e27, R.raw.e5, R.raw.e7};
    private int[] week_10_legsNameString_set_2 = {R.string.NAME_EXERCISE_20, R.string.NAME_EXERCISE_29, R.string.NAME_EXERCISE_27, R.string.NAME_EXERCISE_5, R.string.NAME_EXERCISE_7};
    private int[] week_10_legsDescriptionNameString_set_2 = {R.string.EXERCISE_20, R.string.EXERCISE_29, R.string.EXERCISE_27, R.string.EXERCISE_5, R.string.EXERCISE_7};
    private int[] week_10_legsRepeats_set_2 = {30, 20, 15, 40, 30};
    private int[] week_10_legsKindOfRepeat_set_2 = {1, 1, 3, 1, 1};


    private int[] week_10_legsItems = {R.drawable.ic_mattress, R.drawable.ic_stair_step, R.drawable.ic_weight_3_5};
    private int[] week_10_legsItemsString = {R.string.EQUIPMENT_MATTRESS, R.string.EQUIPMENT_STEP, R.string.EQUIPMENT_WEIGHT_3_5};



    private List<int[]> week_10_legs_set_1_list;
    private List<int[]> week_10_legs_set_2_list;
    private List<int[]> week_10_legs_set_3_list;



    private int[] week_12_legs_set_1 = {R.raw.e50, R.raw.e45, R.raw.e44, R.raw.e42, R.raw.e34};
    private int[] week_12_legsNameString_set_1 = {R.string.NAME_EXERCISE_50, R.string.NAME_EXERCISE_45, R.string.NAME_EXERCISE_44, R.string.NAME_EXERCISE_42, R.string.NAME_EXERCISE_34};
    private int[] week_12_legsDescriptionNameString_set_1 = {R.string.EXERCISE_50, R.string.EXERCISE_45, R.string.EXERCISE_44, R.string.EXERCISE_42, R.string.EXERCISE_34};
    private int[] week_12_legsRepeats_set_1 = {6, 15, 10, 12, 15};
    private int[] week_12_legsKindOfRepeat_set_1 = {1, 3, 1, 1, 1};



    private int[] week_12_legs_set_2 = {R.raw.e20,R.raw.e8 , R.raw.e5, R.raw.e27, R.raw.e95};
    private int[] week_12_legsNameString_set_2 = {R.string.NAME_EXERCISE_20,R.string.NAME_EXERCISE_8, R.string.NAME_EXERCISE_5, R.string.NAME_EXERCISE_27, R.string.NAME_EXERCISE_95};
    private int[] week_12_legsDescriptionNameString_set_2 = {R.string.EXERCISE_20,R.string.EXERCISE_8, R.string.EXERCISE_5, R.string.EXERCISE_27, R.string.EXERCISE_95};
    private int[] week_12_legsRepeats_set_2 = {40, 40, 40, 15, 6};
    private int[] week_12_legsKindOfRepeat_set_2 = {2, 2, 1, 3, 1};


    private int[] week_12_legsItems = {R.drawable.ic_mattress, R.drawable.ic_stair_step, R.drawable.ic_weight_3_5};
    private int[] week_12_legsItemsString = {R.string.EQUIPMENT_MATTRESS, R.string.EQUIPMENT_STEP, R.string.EQUIPMENT_WEIGHT_3_5};


    private List<int[]> week_12_legs_set_1_list;
    private List<int[]> week_12_legs_set_2_list;
    private List<int[]> week_12_legs_set_3_list;





    public List<List<int[]>> getListLegsByWeek(int week) {

        List<List<int[]>> lists = new ArrayList<>();

        if (week == 0 || week == 1) {

            this.week_1_2_legs_set_1_list = new ArrayList<>(Arrays.asList(this.week_1_2_legs_set_1, this.week_1_2_legsNameString_set_1, this.week_1_2_legsDescriptionNameString_set_1, this.week_1_2_legsRepeats_set_1, this.week_1_2_legsKindOfRepeat_set_1));
            this.week_1_2_legs_set_2_list = new ArrayList<>(Arrays.asList(this.week_1_2_legs_set_2, this.week_1_2_legsNameString_set_2, this.week_1_2_legsDescriptionNameString_set_2, this.week_1_2_legsRepeats_set_2, this.week_1_2_legsKindOfRepeat_set_2));


            this.week_1_2_legs_set_3_list = getSetThreeArray(week_1_2_legs_set_1, week_1_2_legs_set_2, week_1_2_legsNameString_set_1, week_1_2_legsNameString_set_2,
                    week_1_2_legsDescriptionNameString_set_1, week_1_2_legsDescriptionNameString_set_2, week_1_2_legsRepeats_set_1, week_1_2_legsRepeats_set_2
                    , week_1_2_legsKindOfRepeat_set_1, week_1_2_legsKindOfRepeat_set_2);



            lists.add(this.week_1_2_legs_set_1_list);
            lists.add(this.week_1_2_legs_set_2_list);
            lists.add(this.week_1_2_legs_set_3_list);


        } else if (week == 2 || week == 3) {

            this.week_3_4_legs_set_1_list = new ArrayList<>(Arrays.asList(this.week_3_4_legs_set_1, this.week_3_4_legsNameString_set_1, this.week_3_4_legsDescriptionNameString_set_1, this.week_3_4_legsRepeats_set_1, this.week_3_4_legsKindOfRepeat_set_1));
            this.week_3_4_legs_set_2_list = new ArrayList<>(Arrays.asList(this.week_3_4_legs_set_2, this.week_3_4_legsNameString_set_2, this.week_3_4_legsDescriptionNameString_set_2, this.week_3_4_legsRepeats_set_2, this.week_3_4_legsKindOfRepeat_set_2));


            this.week_3_4_legs_set_3_list = getSetThreeArray(week_3_4_legs_set_1, week_3_4_legs_set_2, week_3_4_legsNameString_set_1, week_3_4_legsNameString_set_2,
                    week_3_4_legsDescriptionNameString_set_1, week_3_4_legsDescriptionNameString_set_2, week_3_4_legsRepeats_set_1, week_3_4_legsRepeats_set_2
                    , week_3_4_legsKindOfRepeat_set_1, week_3_4_legsKindOfRepeat_set_2);


            lists.add(this.week_3_4_legs_set_1_list);
            lists.add(this.week_3_4_legs_set_2_list);
            lists.add(this.week_3_4_legs_set_3_list);


        } else if (week == 4 || week == 6) {

            this.week_5_7_legs_set_1_list = new ArrayList<>(Arrays.asList(this.week_5_7_legs_set_1, this.week_5_7_legsNameString_set_1, this.week_5_7_legsDescriptionNameString_set_1, this.week_5_7_legsRepeats_set_1, this.week_5_7_legsKindOfRepeat_set_1));
            this.week_5_7_legs_set_2_list = new ArrayList<>(Arrays.asList(this.week_5_7_legs_set_2, this.week_5_7_legsNameString_set_2, this.week_5_7_legsDescriptionNameString_set_2, this.week_5_7_legsRepeats_set_2, this.week_5_7_legsKindOfRepeat_set_2));


            int[] week_5_7_legs_set_3 = new int[week_5_7_legs_set_1.length + week_5_7_legs_set_2.length];
            int[] week_5_7_legsNameString_set_3 = new int[week_5_7_legsNameString_set_1.length + week_5_7_legsNameString_set_2.length];
            int[] week_5_7_legsDescriptionNameString_set_3 = new int[week_5_7_legsDescriptionNameString_set_1.length + week_5_7_legsDescriptionNameString_set_2.length];
            int[] week_5_7_legsRepeats_set_3 = new int[week_5_7_legsRepeats_set_1.length + week_5_7_legsRepeats_set_2.length];
            int[] week_5_7_legsKindOfRepeat_set_3 = new int[week_5_7_legsKindOfRepeat_set_1.length + week_5_7_legsKindOfRepeat_set_2.length];


            week_5_7_legs_set_3[0] = week_5_7_legs_set_1[0];
            week_5_7_legs_set_3[1] = week_5_7_legs_set_2[0];
            week_5_7_legsNameString_set_3[0] = week_5_7_legsNameString_set_1[0];
            week_5_7_legsNameString_set_3[1] = week_5_7_legsNameString_set_2[0];
            week_5_7_legsDescriptionNameString_set_3[0] = week_5_7_legsDescriptionNameString_set_1[0];
            week_5_7_legsDescriptionNameString_set_3[1] = week_5_7_legsDescriptionNameString_set_2[0];
            week_5_7_legsRepeats_set_3[0] = week_5_7_legsRepeats_set_1[0];
            week_5_7_legsRepeats_set_3[1] = week_5_7_legsRepeats_set_2[0];
            week_5_7_legsKindOfRepeat_set_3[0] = week_5_7_legsKindOfRepeat_set_1[0];
            week_5_7_legsKindOfRepeat_set_3[1] = week_5_7_legsKindOfRepeat_set_2[0];

            int iSetOne = 1;
            int iSetTwo = 1;

            for (int i = 2; i < week_5_7_legs_set_3.length ; i++) {

                if (i % 2 == 0){

                    week_5_7_legs_set_3[i] = week_5_7_legs_set_1[iSetOne];
                    week_5_7_legsNameString_set_3[i] = week_5_7_legsNameString_set_1[iSetOne];
                    week_5_7_legsDescriptionNameString_set_3[i] = week_5_7_legsDescriptionNameString_set_1[iSetOne];
                    week_5_7_legsRepeats_set_3[i] = week_5_7_legsRepeats_set_1[iSetOne];
                    week_5_7_legsKindOfRepeat_set_3[i] = week_5_7_legsKindOfRepeat_set_1[iSetOne];
                    iSetOne++;


                } else {

                    week_5_7_legs_set_3[i] = week_5_7_legs_set_2[iSetTwo];
                    week_5_7_legsNameString_set_3[i] = week_5_7_legsNameString_set_2[iSetTwo];
                    week_5_7_legsDescriptionNameString_set_3[i] = week_5_7_legsDescriptionNameString_set_2[iSetTwo];
                    week_5_7_legsRepeats_set_3[i] = week_5_7_legsRepeats_set_2[iSetTwo];
                    week_5_7_legsKindOfRepeat_set_3[i] = week_5_7_legsKindOfRepeat_set_2[iSetTwo];
                    iSetTwo++;

                }

            }


            this.week_5_7_legs_set_3_list = new ArrayList<>(Arrays.asList(week_5_7_legs_set_3, week_5_7_legsNameString_set_3, week_5_7_legsDescriptionNameString_set_3, week_5_7_legsRepeats_set_3, week_5_7_legsKindOfRepeat_set_3));


            lists.add(this.week_5_7_legs_set_1_list);
            lists.add(this.week_5_7_legs_set_2_list);
            lists.add(this.week_5_7_legs_set_3_list);


        } else if (week == 5 || week == 7) {

            this.week_6_8_legs_set_1_list = new ArrayList<>(Arrays.asList(this.week_6_8_legs_set_1, this.week_6_8_legsNameString_set_1, this.week_6_8_legsDescriptionNameString_set_1, this.week_6_8_legsRepeats_set_1, this.week_6_8_legsKindOfRepeat_set_1));
            this.week_6_8_legs_set_2_list = new ArrayList<>(Arrays.asList(this.week_6_8_legs_set_2, this.week_6_8_legsNameString_set_2, this.week_6_8_legsDescriptionNameString_set_2, this.week_6_8_legsRepeats_set_2, this.week_6_8_legsKindOfRepeat_set_2));



            int[] week_6_8_legs_set_3 = new int[week_6_8_legs_set_1.length + week_6_8_legs_set_2.length];
            int[] week_6_8_legsNameString_set_3 = new int[week_6_8_legsNameString_set_1.length + week_6_8_legsNameString_set_2.length];
            int[] week_6_8_legsDescriptionNameString_set_3 = new int[week_6_8_legsDescriptionNameString_set_1.length + week_6_8_legsDescriptionNameString_set_2.length];
            int[] week_6_8_legsRepeats_set_3 = new int[week_6_8_legsRepeats_set_1.length + week_6_8_legsRepeats_set_2.length];
            int[] week_6_8_legsKindOfRepeat_set_3 = new int[week_6_8_legsKindOfRepeat_set_1.length + week_6_8_legsKindOfRepeat_set_2.length];


            week_6_8_legs_set_3[0] = week_6_8_legs_set_1[0];
            week_6_8_legs_set_3[1] = week_6_8_legs_set_2[0];
            week_6_8_legsNameString_set_3[0] = week_6_8_legsNameString_set_1[0];
            week_6_8_legsNameString_set_3[1] = week_6_8_legsNameString_set_2[0];
            week_6_8_legsDescriptionNameString_set_3[0] = week_6_8_legsDescriptionNameString_set_1[0];
            week_6_8_legsDescriptionNameString_set_3[1] = week_6_8_legsDescriptionNameString_set_2[0];
            week_6_8_legsRepeats_set_3[0] = week_6_8_legsRepeats_set_1[0];
            week_6_8_legsRepeats_set_3[1] = week_6_8_legsRepeats_set_2[0];
            week_6_8_legsKindOfRepeat_set_3[0] = week_6_8_legsKindOfRepeat_set_1[0];
            week_6_8_legsKindOfRepeat_set_3[0] = week_6_8_legsKindOfRepeat_set_2[0];

            int iSetOne = 1;
            int iSetTwo = 1;

            for (int i = 2; i < week_6_8_legs_set_3.length ; i++) {

                if (i % 2 == 0){

                    week_6_8_legs_set_3[i] = week_6_8_legs_set_1[iSetOne];
                    week_6_8_legsNameString_set_3[i] = week_6_8_legsNameString_set_1[iSetOne];
                    week_6_8_legsDescriptionNameString_set_3[i] = week_6_8_legsDescriptionNameString_set_1[iSetOne];
                    week_6_8_legsRepeats_set_3[i] = week_6_8_legsRepeats_set_1[iSetOne];
                    week_6_8_legsKindOfRepeat_set_3[i] = week_6_8_legsKindOfRepeat_set_1[iSetOne];
                    iSetOne++;


                } else {

                    week_6_8_legs_set_3[i] = week_6_8_legs_set_2[iSetTwo];
                    week_6_8_legsNameString_set_3[i] = week_6_8_legsNameString_set_2[iSetTwo];
                    week_6_8_legsDescriptionNameString_set_3[i] = week_6_8_legsDescriptionNameString_set_2[iSetTwo];
                    week_6_8_legsRepeats_set_3[i] = week_6_8_legsRepeats_set_2[iSetTwo];
                    week_6_8_legsKindOfRepeat_set_3[i] = week_6_8_legsKindOfRepeat_set_2[iSetTwo];
                    iSetTwo++;

                }

            }


            this.week_6_8_legs_set_3_list = new ArrayList<>(Arrays.asList(week_6_8_legs_set_3, week_6_8_legsNameString_set_3, week_6_8_legsDescriptionNameString_set_3, week_6_8_legsRepeats_set_3, week_6_8_legsKindOfRepeat_set_3));



            lists.add(this.week_6_8_legs_set_1_list);
            lists.add(this.week_6_8_legs_set_2_list);
            lists.add(this.week_6_8_legs_set_3_list);

        } else if (week == 8 || week == 10) {



            this.week_9_11_legs_set_1_list = new ArrayList<>(Arrays.asList(this.week_9_11_legs_set_1, this.week_9_11_legsNameString_set_1, this.week_9_11_legsDescriptionNameString_set_1, this.week_9_11_legsRepeats_set_1, this.week_9_11_legsKindOfRepeat_set_1));
            this.week_9_11_legs_set_2_list = new ArrayList<>(Arrays.asList(this.week_9_11_legs_set_2, this.week_9_11_legsNameString_set_2, this.week_9_11_legsDescriptionNameString_set_2, this.week_9_11_legsRepeats_set_2, this.week_9_11_legsKindOfRepeat_set_2));


            this.week_9_11_legs_set_3_list = getSetThreeArray(week_9_11_legs_set_2, week_9_11_legs_set_1, week_9_11_legsNameString_set_2, week_9_11_legsNameString_set_1,
                    week_9_11_legsDescriptionNameString_set_2, week_9_11_legsDescriptionNameString_set_1,
                    this.week_9_11_legsRepeats_set_2, this.week_9_11_legsRepeats_set_1,
                    this.week_9_11_legsKindOfRepeat_set_2, this.week_9_11_legsKindOfRepeat_set_1);



            lists.add(this.week_9_11_legs_set_1_list);
            lists.add(this.week_9_11_legs_set_2_list);
            lists.add(this.week_9_11_legs_set_3_list);



        } else if (week == 9) {


            this.week_10_legs_set_1_list = new ArrayList<>(Arrays.asList(this.week_10_legs_set_1, this.week_10_legsNameString_set_1, this.week_10_legsDescriptionNameString_set_1, this.week_10_legsRepeats_set_1, this.week_10_legsKindOfRepeat_set_1));
            this.week_10_legs_set_2_list = new ArrayList<>(Arrays.asList(this.week_10_legs_set_2, this.week_10_legsNameString_set_2, this.week_10_legsDescriptionNameString_set_2, this.week_10_legsRepeats_set_2, this.week_10_legsKindOfRepeat_set_2));


            this.week_10_legs_set_3_list = getSetThreeArray(week_10_legs_set_2, week_10_legs_set_1, week_10_legsNameString_set_2, week_10_legsNameString_set_1,
                    week_10_legsDescriptionNameString_set_2, week_10_legsDescriptionNameString_set_1,
                    this.week_10_legsRepeats_set_2, this.week_10_legsRepeats_set_1,
                    this.week_10_legsKindOfRepeat_set_2, this.week_10_legsKindOfRepeat_set_1);



            lists.add(this.week_10_legs_set_1_list);
            lists.add(this.week_10_legs_set_2_list);
            lists.add(this.week_10_legs_set_3_list);



        } else if (week == 11) {


            this.week_12_legs_set_1_list = new ArrayList<>(Arrays.asList(this.week_12_legs_set_1, this.week_12_legsNameString_set_1, this.week_12_legsDescriptionNameString_set_1, this.week_12_legsRepeats_set_1, this.week_12_legsKindOfRepeat_set_1));
            this.week_12_legs_set_2_list = new ArrayList<>(Arrays.asList(this.week_12_legs_set_2, this.week_12_legsNameString_set_2, this.week_12_legsDescriptionNameString_set_2, this.week_12_legsRepeats_set_2, this.week_12_legsKindOfRepeat_set_2));



            this.week_12_legs_set_3_list = getSetThreeArray(week_12_legs_set_2, week_12_legs_set_1, week_12_legsNameString_set_2, week_12_legsNameString_set_1,
                    week_12_legsDescriptionNameString_set_2, week_12_legsDescriptionNameString_set_1,
                    this.week_12_legsRepeats_set_2, this.week_12_legsRepeats_set_1,
                    this.week_12_legsKindOfRepeat_set_2, this.week_12_legsKindOfRepeat_set_1);



            lists.add(this.week_12_legs_set_1_list);
            lists.add(this.week_12_legs_set_2_list);
            lists.add(this.week_12_legs_set_3_list);


        }

        return lists;

    }





    public List<int[]> getExerciseItemLegsListByWeek(int week){

        List<int[]> exerciseItemList = new ArrayList<>();

        if (week == 0 || week == 1){

            exerciseItemList.add(week_1_2_legsItems);
            exerciseItemList.add(week_1_2_legsItemsString);

        } else if (week == 2 || week == 3){

            exerciseItemList.add(week_3_4_legsItems);
            exerciseItemList.add(week_3_4_legsItemsString);

        } else if (week == 4 || week == 6){

            exerciseItemList.add(week_5_7_legsItems);
            exerciseItemList.add(week_5_7_legsItemsString);

        } else if (week == 5 || week == 7){

            exerciseItemList.add(week_6_8_legsItems);
            exerciseItemList.add(week_6_8_legsItemsString);

        } else if (week == 8 || week == 10){

            exerciseItemList.add(week_9_11_legsItems);
            exerciseItemList.add(week_9_11_legsItemsString);

        } else if (week == 9){

            exerciseItemList.add(week_10_legsItems);
            exerciseItemList.add(week_10_legsItemsString);

        } else if (week == 11){

            exerciseItemList.add(week_12_legsItems);
            exerciseItemList.add(week_12_legsItemsString);

        }

        return exerciseItemList;
    }




    /////////////////////////////////
    ////////FULL BODY


    private int[] week_1_2_fullBody_set_1 = {R.raw.e33, R.raw.e4, R.raw.e40, R.raw.e57, R.raw.e39};
    private int[] week_1_2_fullBodyNameString_set_1 = {R.string.NAME_EXERCISE_33, R.string.NAME_EXERCISE_4, R.string.NAME_EXERCISE_40, R.string.NAME_EXERCISE_57, R.string.NAME_EXERCISE_39};
    private int[] week_1_2_fullBodyDescriptionNameString_set_1 = {R.string.EXERCISE_33, R.string.EXERCISE_4, R.string.EXERCISE_40, R.string.EXERCISE_57, R.string.EXERCISE_39};
    private int[] week_1_2_fullBodyRepeats_set_1 = {30, 15, 15, 10, 10};
    private int[] week_1_2_fullBodyKindOfRepeat_set_1 = {1, 1, 1, 3, 1};



    private int[] week_1_2_fullBody_set_2 = {R.raw.e17,R.raw.e71, R.raw.e8, R.raw.e92, R.raw.e41};
    private int[] week_1_2_fullBodyNameString_set_2 = {R.string.NAME_EXERCISE_17, R.string.NAME_EXERCISE_71,R.string.NAME_EXERCISE_8, R.string.NAME_EXERCISE_92, R.string.NAME_EXERCISE_41};
    private int[] week_1_2_fullBodyDescriptionNameString_set_2 = {R.string.EXERCISE_17, R.string.EXERCISE_71,R.string.EXERCISE_8, R.string.EXERCISE_92, R.string.EXERCISE_41};
    private int[] week_1_2_fullBodyRepeats_set_2 = {40, 40, 15, 10, 8};
    private int[] week_1_2_fullBodyKindOfRepeat_set_2 = {2, 2, 1, 1, 1};

    private int[] week_1_2_fullBodyItems = {R.drawable.ic_mattress};
    private int[] week_1_2_fullBodyItemsString = {R.string.EQUIPMENT_MATTRESS};


    private List<int[]> week_1_2_fullBody_set_1_list;
    private List<int[]> week_1_2_fullBody_set_2_list;
    private List<int[]> week_1_2_fullBody_set_3_list;


    private int[] week_3_4_fullBody_set_1 = {R.raw.e12, R.raw.e9, R.raw.e42, R.raw.e55, R.raw.e52};
    private int[] week_3_4_fullBodyNameString_set_1 = {R.string.NAME_EXERCISE_12, R.string.NAME_EXERCISE_9, R.string.NAME_EXERCISE_42, R.string.NAME_EXERCISE_55, R.string.NAME_EXERCISE_52};
    private int[] week_3_4_fullBodyDescriptionNameString_set_1 = {R.string.EXERCISE_12, R.string.EXERCISE_9, R.string.EXERCISE_42, R.string.EXERCISE_55, R.string.EXERCISE_52};
    private int[] week_3_4_fullBodyRepeats_set_1 = {10, 20, 12, 20, 10};
    private int[] week_3_4_fullBodyKindOfRepeat_set_1 = {1, 1, 1, 1, 1};



    private int[] week_3_4_fullBody_set_2 = {R.raw.e33, R.raw.e72, R.raw.e13, R.raw.e64, R.raw.e36};
    private int[] week_3_4_fullBodyNameString_set_2 = {R.string.NAME_EXERCISE_33, R.string.NAME_EXERCISE_72, R.string.NAME_EXERCISE_13, R.string.NAME_EXERCISE_64, R.string.NAME_EXERCISE_36};
    private int[] week_3_4_fullBodyDescriptionNameString_set_2 = {R.string.EXERCISE_33, R.string.EXERCISE_72, R.string.EXERCISE_13, R.string.EXERCISE_64, R.string.EXERCISE_36};
    private int[] week_3_4_fullBodyRepeats_set_2 = {40, 40, 20, 15, 8};
    private int[] week_3_4_fullBodyKindOfRepeat_set_2 = {1, 5, 2, 1, 1};

    private int[] week_3_4_fullBodyItems = {R.drawable.ic_weight_3_5};
    private int[] week_3_4_fullBodyItemsString = {R.string.EQUIPMENT_WEIGHT_1_3};


    private List<int[]> week_3_4_fullBody_set_1_list;
    private List<int[]> week_3_4_fullBody_set_2_list;
    private List<int[]> week_3_4_fullBody_set_3_list;


    private int[] week_5_7_fullBody_set_1 = {R.raw.e33, R.raw.e26, R.raw.e36, R.raw.e59, R.raw.e85};
    private int[] week_5_7_fullBodyNameString_set_1 = {R.string.NAME_EXERCISE_33, R.string.NAME_EXERCISE_26, R.string.NAME_EXERCISE_36, R.string.NAME_EXERCISE_59, R.string.NAME_EXERCISE_85};
    private int[] week_5_7_fullBodyDescriptionNameString_set_1 = {R.string.EXERCISE_33, R.string.EXERCISE_26, R.string.EXERCISE_36, R.string.EXERCISE_59, R.string.EXERCISE_85};
    private int[] week_5_7_fullBodyRepeats_set_1 = {50, 20, 10, 24, 12};
    private int[] week_5_7_fullBodyKindOfRepeat_set_1 = {1, 2, 1, 1, 1};




    private int[] week_5_7_fullBody_set_2 = {R.raw.e21, R.raw.e9, R.raw.e45, R.raw.e64, R.raw.e72};
    private int[] week_5_7_fullBodyNameString_set_2 = {R.string.NAME_EXERCISE_21, R.string.NAME_EXERCISE_9, R.string.NAME_EXERCISE_45, R.string.NAME_EXERCISE_64, R.string.NAME_EXERCISE_72};
    private int[] week_5_7_fullBodyDescriptionNameString_set_2 = {R.string.EXERCISE_21, R.string.EXERCISE_9, R.string.EXERCISE_45, R.string.EXERCISE_64, R.string.EXERCISE_72};
    private int[] week_5_7_fullBodyRepeats_set_2 = {15, 20, 12, 15, 30};
    private int[] week_5_7_fullBodyKindOfRepeat_set_2 = {3, 1, 3, 1, 5};

    private int[] week_5_7_fullBodyItems = {R.drawable.ic_mattress, R.drawable.ic_weight_3_5};
    private int[] week_5_7_fullBodyItemsString = {R.string.EQUIPMENT_MATTRESS, R.string.EQUIPMENT_WEIGHT_1_3};

    private List<int[]> week_5_7_fullBody_set_1_list;
    private List<int[]> week_5_7_fullBody_set_2_list;
    private List<int[]> week_5_7_fullBody_set_3_list;


    private int[] week_6_8_fullBody_set_1 = {R.raw.e19, R.raw.e3, R.raw.e95, R.raw.e61, R.raw.e88};
    private int[] week_6_8_fullBodyNameString_set_1 = {R.string.NAME_EXERCISE_19, R.string.NAME_EXERCISE_3, R.string.NAME_EXERCISE_95, R.string.NAME_EXERCISE_61, R.string.NAME_EXERCISE_88};
    private int[] week_6_8_fullBodyDescriptionNameString_set_1 = {R.string.EXERCISE_19, R.string.EXERCISE_3, R.string.EXERCISE_95, R.string.EXERCISE_61, R.string.EXERCISE_88};
    private int[] week_6_8_fullBodyRepeats_set_1 = {20, 12, 6, 10, 15};
    private int[] week_6_8_fullBodyKindOfRepeat_set_1 = {5, 1, 1, 3, 1};



    private int[] week_6_8_fullBody_set_2 = {R.raw.e5, R.raw.e27, R.raw.e32, R.raw.e80, R.raw.e53};
    private int[] week_6_8_fullBodyNameString_set_2 = {R.string.NAME_EXERCISE_5, R.string.NAME_EXERCISE_27, R.string.NAME_EXERCISE_32, R.string.NAME_EXERCISE_80, R.string.NAME_EXERCISE_53};
    private int[] week_6_8_fullBodyDescriptionNameString_set_2 = {R.string.EXERCISE_5, R.string.EXERCISE_27, R.string.EXERCISE_32, R.string.EXERCISE_80, R.string.EXERCISE_53};
    private int[] week_6_8_fullBodyRepeats_set_2 = {30, 15, 10, 10, 10};
    private int[] week_6_8_fullBodyKindOfRepeat_set_2 = {1, 3, 3, 3, 3};

    private int[] week_6_8_fullBodyItems = {R.drawable.ic_mattress};
    private int[] week_6_8_fullBodyItemsString = {R.string.EQUIPMENT_MATTRESS};


    private List<int[]> week_6_8_fullBody_set_1_list;
    private List<int[]> week_6_8_fullBody_set_2_list;
    private List<int[]> week_6_8_fullBody_set_3_list;


    private int[] week_9_11_fullBody_set_1 = {R.raw.e79, R.raw.e78, R.raw.e59, R.raw.e93, R.raw.e77};
    private int[] week_9_11_fullBodyNameString_set_1 = {R.string.NAME_EXERCISE_79, R.string.NAME_EXERCISE_78, R.string.NAME_EXERCISE_59, R.string.NAME_EXERCISE_93, R.string.NAME_EXERCISE_77};
    private int[] week_9_11_fullBodyDescriptionNameString_set_1 = {R.string.EXERCISE_79, R.string.EXERCISE_78, R.string.EXERCISE_59, R.string.EXERCISE_93, R.string.EXERCISE_77};
    private int[] week_9_11_fullBodyRepeats_set_1 = {10, 10, 24, 6, 8};
    private int[] week_9_11_fullBodyKindOfRepeat_set_1 = {3, 1, 1, 1, 3};



    private int[] week_9_11_fullBody_set_2 = {R.raw.e62, R.raw.e73, R.raw.e56, R.raw.e69, R.raw.e88};
    private int[] week_9_11_fullBodyNameString_set_2 = {R.string.NAME_EXERCISE_62, R.string.NAME_EXERCISE_73, R.string.NAME_EXERCISE_56, R.string.NAME_EXERCISE_69, R.string.NAME_EXERCISE_88};
    private int[] week_9_11_fullBodyDescriptionNameString_set_2 = {R.string.EXERCISE_62, R.string.EXERCISE_73, R.string.EXERCISE_56, R.string.EXERCISE_69, R.string.EXERCISE_88};
    private int[] week_9_11_fullBodyRepeats_set_2 = {8, 20, 10, 25, 20};
    private int[] week_9_11_fullBodyKindOfRepeat_set_2 = {3, 1, 3, 3, 1};


    private int[] week_9_11_fullBodyItems = {R.drawable.ic_mattress, R.drawable.ic_weight_3_5};
    private int[] week_9_11_fullBodyItemsString = {R.string.EQUIPMENT_MATTRESS, R.string.EQUIPMENT_WEIGHT_3_5, R.string.EQUIPMENT_NOUN_RESISTANCE};


    private List<int[]> week_9_11_fullBody_set_1_list;
    private List<int[]> week_9_11_fullBody_set_2_list;
    private List<int[]> week_9_11_fullBody_set_3_list;





    private int[] week_10_fullBody_set_1 = {R.raw.e5,R.raw.e3,R.raw.e34,R.raw.e75,R.raw.e60};
    private int[] week_10_fullBodyNameString_set_1 = {R.string.NAME_EXERCISE_5, R.string.NAME_EXERCISE_3, R.string.NAME_EXERCISE_34, R.string.NAME_EXERCISE_75, R.string.NAME_EXERCISE_60};
    private int[] week_10_fullBodyDescriptionNameString_set_1 = {R.string.EXERCISE_5, R.string.EXERCISE_3, R.string.EXERCISE_34, R.string.EXERCISE_75, R.string.NAME_EXERCISE_60};
    private int[] week_10_fullBodyRepeats_set_1 = {30, 12, 15, 20, 10};
    private int[] week_10_fullBodyKindOfRepeat_set_1 = {1, 1, 1, 3, 3};



    private int[] week_10_fullBody_set_2 = {R.raw.e20,R.raw.e37,R.raw.e50,R.raw.e81,R.raw.e85};
    private int[] week_10_fullBodyNameString_set_2 = {R.string.NAME_EXERCISE_20, R.string.NAME_EXERCISE_37, R.string.NAME_EXERCISE_50, R.string.NAME_EXERCISE_81, R.string.NAME_EXERCISE_85};
    private int[] week_10_fullBodyDescriptionNameString_set_2 = {R.string.EXERCISE_20, R.string.EXERCISE_37, R.string.EXERCISE_50, R.string.EXERCISE_81, R.string.EXERCISE_85};
    private int[] week_10_fullBodyRepeats_set_2 = {40, 40, 8, 20, 15};
    private int[] week_10_fullBodyKindOfRepeat_set_2 = {1, 2, 1, 1, 1};

    private int[] week_10_fullBodyItems = {R.drawable.ic_mattress, R.drawable.noun_resistance, R.drawable.ic_weight_3_5};
    private int[] week_10_fullBodyItemsString = {R.string.EQUIPMENT_MATTRESS, R.string.EQUIPMENT_NOUN_RESISTANCE, R.string.EQUIPMENT_WEIGHT_3_5};


    private List<int[]> week_10_fullBody_set_1_list;
    private List<int[]> week_10_fullBody_set_2_list;
    private List<int[]> week_10_fullBody_set_3_list;






    private int[] week_12_fullBody_set_1 = {R.raw.e52, R.raw.e27, R.raw.e11, R.raw.e85, R.raw.e64};
    private int[] week_12_fullBodyNameString_set_1 = {R.string.NAME_EXERCISE_52, R.string.NAME_EXERCISE_27, R.string.NAME_EXERCISE_11, R.string.NAME_EXERCISE_85, R.string.NAME_EXERCISE_64};
    private int[] week_12_fullBodyDescriptionNameString_set_1 = {R.string.EXERCISE_52, R.string.EXERCISE_27, R.string.EXERCISE_11, R.string.EXERCISE_85, R.string.NAME_EXERCISE_64};
    private int[] week_12_fullBodyRepeats_set_1 = {8, 20, 10, 15, 15};
    private int[] week_12_fullBodyKindOfRepeat_set_1 = {1, 3, 1, 1, 1};



    private int[] week_12_fullBody_set_2 = {R.raw.e24, R.raw.e36, R.raw.e32, R.raw.e72, R.raw.e53};
    private int[] week_12_fullBodyNameString_set_2 = {R.string.NAME_EXERCISE_24, R.string.NAME_EXERCISE_36, R.string.NAME_EXERCISE_32, R.string.NAME_EXERCISE_72, R.string.NAME_EXERCISE_53};
    private int[] week_12_fullBodyDescriptionNameString_set_2 = {R.string.EXERCISE_24, R.string.EXERCISE_36, R.string.EXERCISE_32, R.string.EXERCISE_72, R.string.EXERCISE_53};
    private int[] week_12_fullBodyRepeats_set_2 = {30, 15, 20, 30, 20};
    private int[] week_12_fullBodyKindOfRepeat_set_2 = {2, 1, 1, 5, 1};



    private int[] week_12_fullBodyItems = {R.drawable.ic_mattress};
    private int[] week_12_fullBodyItemsString = {R.string.EQUIPMENT_MATTRESS};


    private List<int[]> week_12_fullBody_set_1_list;
    private List<int[]> week_12_fullBody_set_2_list;
    private List<int[]> week_12_fullBody_set_3_list;




    public List<List<int[]>> getListFullBodyByWeek(int week) {

        List<List<int[]>> lists = new ArrayList<>();

        if (week == 0 || week == 1) {

            this.week_1_2_fullBody_set_1_list = new ArrayList<>(Arrays.asList(this.week_1_2_fullBody_set_1, this.week_1_2_fullBodyNameString_set_1, this.week_1_2_fullBodyDescriptionNameString_set_1, this.week_1_2_fullBodyRepeats_set_1, this.week_1_2_fullBodyKindOfRepeat_set_1));
            this.week_1_2_fullBody_set_2_list = new ArrayList<>(Arrays.asList(this.week_1_2_fullBody_set_2, this.week_1_2_fullBodyNameString_set_2, this.week_1_2_fullBodyDescriptionNameString_set_2, this.week_1_2_fullBodyRepeats_set_2, this.week_1_2_fullBodyKindOfRepeat_set_2));


            this.week_1_2_fullBody_set_3_list = getSetThreeArray(week_1_2_fullBody_set_1, week_1_2_fullBody_set_2, week_1_2_fullBodyNameString_set_1, week_1_2_fullBodyNameString_set_2,
                    week_1_2_fullBodyDescriptionNameString_set_1, week_1_2_fullBodyDescriptionNameString_set_2, week_1_2_fullBodyRepeats_set_1, week_1_2_fullBodyRepeats_set_2
                    , week_1_2_fullBodyKindOfRepeat_set_1, week_1_2_fullBodyKindOfRepeat_set_2);


            lists.add(this.week_1_2_fullBody_set_1_list);
            lists.add(this.week_1_2_fullBody_set_2_list);
            lists.add(this.week_1_2_fullBody_set_3_list);



        } else if (week == 2 || week == 3) {

            this.week_3_4_fullBody_set_1_list = new ArrayList<>(Arrays.asList(this.week_3_4_fullBody_set_1, this.week_3_4_fullBodyNameString_set_1, this.week_3_4_fullBodyDescriptionNameString_set_1, this.week_3_4_fullBodyRepeats_set_1, this.week_3_4_fullBodyKindOfRepeat_set_1));
            this.week_3_4_fullBody_set_2_list = new ArrayList<>(Arrays.asList(this.week_3_4_fullBody_set_2, this.week_3_4_fullBodyNameString_set_2, this.week_3_4_fullBodyDescriptionNameString_set_2, this.week_3_4_fullBodyRepeats_set_2, this.week_3_4_fullBodyKindOfRepeat_set_2));


            this.week_3_4_fullBody_set_3_list = getSetThreeArray(week_3_4_fullBody_set_1, week_3_4_fullBody_set_2, week_3_4_fullBodyNameString_set_1, week_3_4_fullBodyNameString_set_2,
                    week_3_4_fullBodyDescriptionNameString_set_1, week_3_4_fullBodyDescriptionNameString_set_2, week_3_4_fullBodyRepeats_set_1, week_3_4_fullBodyRepeats_set_2
                    , week_3_4_fullBodyKindOfRepeat_set_1, week_3_4_fullBodyKindOfRepeat_set_2);



            lists.add(this.week_3_4_fullBody_set_1_list);
            lists.add(this.week_3_4_fullBody_set_2_list);
            lists.add(this.week_3_4_fullBody_set_3_list);



        } else if (week == 4 || week == 6) {

            this.week_5_7_fullBody_set_1_list = new ArrayList<>(Arrays.asList(this.week_5_7_fullBody_set_1, this.week_5_7_fullBodyNameString_set_1, this.week_5_7_fullBodyDescriptionNameString_set_1, this.week_5_7_fullBodyRepeats_set_1, this.week_5_7_fullBodyKindOfRepeat_set_1));
            this.week_5_7_fullBody_set_2_list = new ArrayList<>(Arrays.asList(this.week_5_7_fullBody_set_2, this.week_5_7_fullBodyNameString_set_2, this.week_5_7_fullBodyDescriptionNameString_set_2, this.week_5_7_fullBodyRepeats_set_2, this.week_5_7_fullBodyKindOfRepeat_set_2));



            int[] week_5_7_fullBody_set_3 = new int[week_5_7_fullBody_set_1.length + week_5_7_fullBody_set_2.length];
            int[] week_5_7_fullBodyNameString_set_3 = new int[week_5_7_fullBodyNameString_set_1.length + week_5_7_fullBodyNameString_set_2.length];
            int[] week_5_7_fullBodyDescriptionNameString_set_3 = new int[week_5_7_fullBodyDescriptionNameString_set_1.length + week_5_7_fullBodyDescriptionNameString_set_2.length];
            int[] week_5_7_fullBodyRepeats_set_3 = new int[week_5_7_fullBodyRepeats_set_1.length + week_5_7_fullBodyRepeats_set_2.length];
            int[] week_5_7_fullBodyKindOfRepeat_set_3 = new int[week_5_7_fullBodyKindOfRepeat_set_1.length + week_5_7_fullBodyKindOfRepeat_set_2.length];

            week_5_7_fullBody_set_3[0] = week_5_7_fullBody_set_1[0];
            week_5_7_fullBody_set_3[1] = week_5_7_fullBody_set_2[0];
            week_5_7_fullBodyNameString_set_3[0] = week_5_7_fullBody_set_1[0];
            week_5_7_fullBodyNameString_set_3[1] = week_5_7_fullBody_set_2[0];
            week_5_7_fullBodyDescriptionNameString_set_3[0] = week_5_7_fullBody_set_1[0];
            week_5_7_fullBodyDescriptionNameString_set_3[1] = week_5_7_fullBody_set_2[0];
            week_5_7_fullBodyRepeats_set_3[0] = week_5_7_fullBodyRepeats_set_1[0];
            week_5_7_fullBodyRepeats_set_3[1] = week_5_7_fullBodyRepeats_set_2[0];
            week_5_7_fullBodyKindOfRepeat_set_3[0] = week_5_7_fullBodyKindOfRepeat_set_1[0];
            week_5_7_fullBodyKindOfRepeat_set_3[1] = week_5_7_fullBodyKindOfRepeat_set_2[0];


            int iSetOne = 1;
            int iSetTwo = 1;

            for (int i = 2; i < week_5_7_fullBody_set_3.length ; i++) {

                if (i % 2 == 0){

                    week_5_7_fullBody_set_3[i] = week_5_7_fullBody_set_1[iSetOne];
                    week_5_7_fullBodyNameString_set_3[i] = week_5_7_fullBodyNameString_set_1[iSetOne];
                    week_5_7_fullBodyDescriptionNameString_set_3[i] = week_5_7_fullBodyDescriptionNameString_set_1[iSetOne];
                    week_5_7_fullBodyRepeats_set_3[i] = week_5_7_fullBodyRepeats_set_1[iSetOne];
                    week_5_7_fullBodyKindOfRepeat_set_3[i] = week_5_7_fullBodyKindOfRepeat_set_1[iSetOne];
                    iSetOne++;


                } else {

                    week_5_7_fullBody_set_3[i] = week_5_7_fullBody_set_2[iSetTwo];
                    week_5_7_fullBodyNameString_set_3[i] = week_5_7_fullBodyNameString_set_2[iSetTwo];
                    week_5_7_fullBodyDescriptionNameString_set_3[i] = week_5_7_fullBodyDescriptionNameString_set_2[iSetTwo];
                    week_5_7_fullBodyRepeats_set_3[i] = week_5_7_fullBodyRepeats_set_2[iSetTwo];
                    week_5_7_fullBodyKindOfRepeat_set_3[i] = week_5_7_fullBodyKindOfRepeat_set_2[iSetTwo];
                    iSetTwo++;

                }

            }


            this.week_5_7_fullBody_set_3_list = new ArrayList<>(Arrays.asList(week_5_7_fullBody_set_3, week_5_7_fullBodyNameString_set_3, week_5_7_fullBodyDescriptionNameString_set_3, week_5_7_fullBodyRepeats_set_3, week_5_7_fullBodyKindOfRepeat_set_3));




            lists.add(this.week_5_7_fullBody_set_1_list);
            lists.add(this.week_5_7_fullBody_set_2_list);
            lists.add(this.week_5_7_fullBody_set_3_list);

        } else if (week == 5 || week == 7) {

            this.week_6_8_fullBody_set_1_list = new ArrayList<>(Arrays.asList(this.week_6_8_fullBody_set_1, this.week_6_8_fullBodyNameString_set_1, this.week_6_8_fullBodyDescriptionNameString_set_1, this.week_6_8_fullBodyRepeats_set_1, this.week_6_8_fullBodyKindOfRepeat_set_1));
            this.week_6_8_fullBody_set_2_list = new ArrayList<>(Arrays.asList(this.week_6_8_fullBody_set_2, this.week_6_8_fullBodyNameString_set_2, this.week_6_8_fullBodyDescriptionNameString_set_2, this.week_6_8_fullBodyRepeats_set_2, this.week_6_8_fullBodyKindOfRepeat_set_2));



            int[] week_6_8_fullBody_set_3 = new int[week_6_8_fullBody_set_1.length + week_6_8_fullBody_set_2.length];
            int[] week_6_8_fullBodyNameString_set_3 = new int[week_6_8_fullBodyNameString_set_1.length + week_6_8_fullBodyNameString_set_2.length];
            int[] week_6_8_fullBodyDescriptionNameString_set_3 = new int[week_6_8_fullBodyDescriptionNameString_set_1.length + week_6_8_fullBodyDescriptionNameString_set_2.length];
            int[] week_6_8_fullBodyRepeats_set_3 = new int[week_6_8_fullBodyRepeats_set_1.length + week_6_8_fullBodyRepeats_set_2.length];
            int[] week_6_8_fullBodyKindOfRepeat_set_3 = new int[week_6_8_fullBodyKindOfRepeat_set_1.length + week_6_8_fullBodyKindOfRepeat_set_2.length];


            week_6_8_fullBody_set_3[0] = week_6_8_fullBody_set_1[0];
            week_6_8_fullBody_set_3[1] = week_6_8_fullBody_set_2[0];
            week_6_8_fullBodyNameString_set_3[0] = week_6_8_fullBody_set_1[0];
            week_6_8_fullBodyNameString_set_3[1] = week_6_8_fullBody_set_2[0];
            week_6_8_fullBodyDescriptionNameString_set_3[0] = week_6_8_fullBody_set_1[0];
            week_6_8_fullBodyDescriptionNameString_set_3[1] = week_6_8_fullBody_set_2[0];
            week_6_8_fullBodyRepeats_set_3[0] = week_6_8_fullBodyRepeats_set_1[0];
            week_6_8_fullBodyRepeats_set_3[1] = week_6_8_fullBodyRepeats_set_2[0];
            week_6_8_fullBodyKindOfRepeat_set_3[0] = week_6_8_fullBodyKindOfRepeat_set_1[0];
            week_6_8_fullBodyKindOfRepeat_set_3[1] = week_6_8_fullBodyKindOfRepeat_set_2[0];

            int iSetOne = 1;
            int iSetTwo = 1;

            for (int i = 2; i < week_6_8_fullBody_set_3.length ; i++) {

                if (i % 2 == 0){

                    week_6_8_fullBody_set_3[i] = week_6_8_fullBody_set_1[iSetOne];
                    week_6_8_fullBodyNameString_set_3[i] = week_6_8_fullBodyNameString_set_1[iSetOne];
                    week_6_8_fullBodyDescriptionNameString_set_3[i] = week_6_8_fullBodyDescriptionNameString_set_1[iSetOne];
                    week_6_8_fullBodyRepeats_set_3[i] = week_6_8_fullBodyRepeats_set_1[iSetOne];
                    week_6_8_fullBodyKindOfRepeat_set_3[i] = week_6_8_fullBodyKindOfRepeat_set_1[iSetOne];
                    iSetOne++;


                } else {

                    week_6_8_fullBody_set_3[i] = week_6_8_fullBody_set_2[iSetTwo];
                    week_6_8_fullBodyNameString_set_3[i] = week_6_8_fullBodyNameString_set_2[iSetTwo];
                    week_6_8_fullBodyDescriptionNameString_set_3[i] = week_6_8_fullBodyDescriptionNameString_set_2[iSetTwo];
                    week_6_8_fullBodyRepeats_set_3[i] = week_6_8_fullBodyRepeats_set_2[iSetTwo];
                    week_6_8_fullBodyKindOfRepeat_set_3[i] = week_6_8_fullBodyKindOfRepeat_set_2[iSetTwo];
                    iSetTwo++;

                }

            }


            this.week_6_8_fullBody_set_3_list = new ArrayList<>(Arrays.asList(week_6_8_fullBody_set_3, week_6_8_fullBodyNameString_set_3, week_6_8_fullBodyDescriptionNameString_set_3, week_6_8_fullBodyRepeats_set_3, week_6_8_fullBodyKindOfRepeat_set_3));



            lists.add(this.week_6_8_fullBody_set_1_list);
            lists.add(this.week_6_8_fullBody_set_2_list);
            lists.add(this.week_6_8_fullBody_set_3_list);



        } else if (week == 8 || week == 10) {


            this.week_9_11_fullBody_set_1_list = new ArrayList<>(Arrays.asList(this.week_9_11_fullBody_set_1, this.week_9_11_fullBodyNameString_set_1, this.week_9_11_fullBodyDescriptionNameString_set_1, this.week_9_11_fullBodyRepeats_set_1, this.week_9_11_fullBodyKindOfRepeat_set_1));
            this.week_9_11_fullBody_set_2_list = new ArrayList<>(Arrays.asList(this.week_9_11_fullBody_set_2, this.week_9_11_fullBodyNameString_set_2, this.week_9_11_fullBodyDescriptionNameString_set_2, this.week_9_11_fullBodyRepeats_set_2, this.week_9_11_fullBodyKindOfRepeat_set_2));


            this.week_9_11_fullBody_set_3_list = getSetThreeArray(week_9_11_fullBody_set_2, week_9_11_fullBody_set_1, week_9_11_fullBodyNameString_set_2, week_9_11_fullBodyNameString_set_1,
                    week_9_11_fullBodyDescriptionNameString_set_2, week_9_11_fullBodyDescriptionNameString_set_1
                    , this.week_9_11_fullBodyRepeats_set_2, this.week_9_11_fullBodyRepeats_set_1, this.week_9_11_fullBodyKindOfRepeat_set_2, this.week_9_11_fullBodyKindOfRepeat_set_1);



            lists.add(this.week_9_11_fullBody_set_1_list);
            lists.add(this.week_9_11_fullBody_set_2_list);
            lists.add(this.week_9_11_fullBody_set_3_list);



        } else if (week == 9) {



            this.week_10_fullBody_set_1_list = new ArrayList<>(Arrays.asList(this.week_10_fullBody_set_1, this.week_10_fullBodyNameString_set_1, this.week_10_fullBodyDescriptionNameString_set_1, this.week_10_fullBodyRepeats_set_1, this.week_10_fullBodyKindOfRepeat_set_1));
            this.week_10_fullBody_set_2_list = new ArrayList<>(Arrays.asList(this.week_10_fullBody_set_2, this.week_10_fullBodyNameString_set_2, this.week_10_fullBodyDescriptionNameString_set_2, this.week_10_fullBodyRepeats_set_2, this.week_10_fullBodyKindOfRepeat_set_2));


            this.week_10_fullBody_set_3_list = getSetThreeArray(week_10_fullBody_set_2, week_10_fullBody_set_1, week_10_fullBodyNameString_set_2, week_10_fullBodyNameString_set_1,
                    week_10_fullBodyDescriptionNameString_set_2, week_10_fullBodyDescriptionNameString_set_1,
                    this.week_10_fullBodyRepeats_set_2, this.week_10_fullBodyRepeats_set_1, this.week_10_fullBodyKindOfRepeat_set_2, this.week_10_fullBodyKindOfRepeat_set_1);



            lists.add(this.week_10_fullBody_set_1_list);
            lists.add(this.week_10_fullBody_set_2_list);
            lists.add(this.week_10_fullBody_set_3_list);




        } else if (week == 11) {



            this.week_12_fullBody_set_1_list = new ArrayList<>(Arrays.asList(this.week_12_fullBody_set_1, this.week_12_fullBodyNameString_set_1, this.week_12_fullBodyDescriptionNameString_set_1, this.week_12_fullBodyRepeats_set_1, this.week_12_fullBodyKindOfRepeat_set_1));
            this.week_12_fullBody_set_2_list = new ArrayList<>(Arrays.asList(this.week_12_fullBody_set_2, this.week_12_fullBodyNameString_set_2, this.week_12_fullBodyDescriptionNameString_set_2, this.week_12_fullBodyRepeats_set_2, this.week_12_fullBodyKindOfRepeat_set_2));

            this.week_12_fullBody_set_3_list = getSetThreeArray(week_12_fullBody_set_2, week_12_fullBody_set_1, week_12_fullBodyNameString_set_2, week_12_fullBodyNameString_set_1,
                    week_12_fullBodyDescriptionNameString_set_2, week_12_fullBodyDescriptionNameString_set_1,
                    week_12_fullBodyRepeats_set_2, week_12_fullBodyRepeats_set_1, week_12_fullBodyKindOfRepeat_set_2, week_12_fullBodyKindOfRepeat_set_1);


            lists.add(this.week_12_fullBody_set_1_list);
            lists.add(this.week_12_fullBody_set_2_list);
            lists.add(this.week_12_fullBody_set_3_list);


        }

        return lists;

    }





    public List<int[]> getExerciseItemFullBodyListByWeek(int week){

        List<int[]> exerciseItemList = new ArrayList<>();

        if (week == 0 || week == 1){

            exerciseItemList.add(week_1_2_fullBodyItems);
            exerciseItemList.add(week_1_2_fullBodyItemsString);

        } else if (week == 2 || week == 3){

            exerciseItemList.add(week_3_4_fullBodyItems);
            exerciseItemList.add(week_3_4_fullBodyItemsString);

        } else if (week == 4 || week == 6){

            exerciseItemList.add(week_5_7_fullBodyItems);
            exerciseItemList.add(week_5_7_fullBodyItemsString);

        } else if (week == 5 || week == 7){

            exerciseItemList.add(week_6_8_fullBodyItems);
            exerciseItemList.add(week_6_8_fullBodyItemsString);

        } else if (week == 8 || week == 10){

            exerciseItemList.add(week_9_11_fullBodyItems);
            exerciseItemList.add(week_9_11_fullBodyItemsString);

        } else if (week == 9){

            exerciseItemList.add(week_10_fullBodyItems);
            exerciseItemList.add(week_10_fullBodyItemsString);

        } else if (week == 11){

            exerciseItemList.add(week_12_fullBodyItems);
            exerciseItemList.add(week_12_fullBodyItemsString);

        }

        return exerciseItemList;
    }







    //////////////////////////////////
    ////////FLEXIBILITY

                                        //0                     //2                 //4
    private int[] flexibility_set = {R.raw.e97, R.raw.e98, R.raw.e99, R.raw.e100, R.raw.e101, R.raw.e102, R.raw.e103, R.raw.e104,
                                                                                        //14        //15
            R.raw.e105, R.raw.e106, R.raw.e107, R.raw.e108, R.raw.e109, R.raw.e110, R.raw.e111, R.raw.e112, R.raw.e114};
    private int[] flexibility_name_set = {R.string.NAME_EXERCISE_97, R.string.NAME_EXERCISE_98, R.string.NAME_EXERCISE_99, R.string.NAME_EXERCISE_100,
            R.string.NAME_EXERCISE_101, R.string.NAME_EXERCISE_102, R.string.NAME_EXERCISE_103, R.string.NAME_EXERCISE_104, R.string.NAME_EXERCISE_105, R.string.NAME_EXERCISE_106,
            R.string.NAME_EXERCISE_107, R.string.NAME_EXERCISE_108, R.string.NAME_EXERCISE_109, R.string.NAME_EXERCISE_110, R.string.NAME_EXERCISE_111, R.string.NAME_EXERCISE_112, R.string.NAME_EXERCISE_114};
    private int[] flexibility_description = {R.string.EXERCISE_97, R.string.EXERCISE_98, R.string.EXERCISE_99, R.string.EXERCISE_100,
            R.string.EXERCISE_101, R.string.EXERCISE_102, R.string.EXERCISE_103, R.string.EXERCISE_104, R.string.EXERCISE_105, R.string.EXERCISE_106,
            R.string.EXERCISE_107, R.string.EXERCISE_108, R.string.EXERCISE_109, R.string.EXERCISE_110, R.string.EXERCISE_111, R.string.EXERCISE_112, R.string.EXERCISE_114};


    private List<int[]> flexibility_set_list;



    public List<int[]> getListFlexibility(){

        this.flexibility_set_list = new ArrayList<>(Arrays.asList(this.flexibility_set, this.flexibility_name_set, this.flexibility_description));

        return this.flexibility_set_list;

    }


    private int[] flexibility_completion_set = {R.raw.e97, R.raw.e99, R.raw.e101, R.raw.e111, R.raw.e112};
    private int[] flexibility_name_completion_set = {R.string.NAME_EXERCISE_97, R.string.NAME_EXERCISE_99, R.string.NAME_EXERCISE_101, R.string.NAME_EXERCISE_111, R.string.NAME_EXERCISE_112};
    private int[] flexibility_description_completion = {R.string.EXERCISE_97, R.string.EXERCISE_99, R.string.EXERCISE_101, R.string.EXERCISE_111, R.string.EXERCISE_112};


    private List<int[]> flexibility_completion_set_list;

    public List<int[]> getCompletionListFlexibility(){

        this.flexibility_completion_set_list = new ArrayList<>(Arrays.asList(this.flexibility_completion_set, this.flexibility_name_completion_set, this.flexibility_description_completion));

        return this.flexibility_completion_set_list;

    }

}
