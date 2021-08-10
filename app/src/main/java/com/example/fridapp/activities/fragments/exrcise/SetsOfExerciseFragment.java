package com.example.fridapp.activities.fragments.exrcise;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fridapp.R;
import com.example.fridapp.activities.HomePageActivity;
import com.example.fridapp.activities.fragments.home.HomeFragment;
import com.example.fridapp.adapter.PresentationExerciseAdapter;
import com.example.fridapp.helpers.UserProgressHelper;
import com.example.fridapp.model.SetsOfToday;
import com.example.fridapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class SetsOfExerciseFragment extends Fragment implements View.OnClickListener {

    LinearLayout equipmentAreaOneLinearLayout, equipmentAreaTwoLinearLayout, equipmentAreaThreeLinearLayout;
    ImageView equipmentImageViewOne, equipmentImageViewTwo, equipmentImageViewThree, firstArrowImgView, secondArrowImgView, thirdArrowImgView;
    TextView equipmentTextViewOne, equipmentTextViewTwo, equipmentTextViewThree;
    TextView headTextView, subHeadTextView, subHeadSumExerciseTextView,subHeadNumExerciseTextView, partBodyTextView;
    Button firstExerciseBtn, secondExerciseBtn, thirdExerciseBtn, startExerciseBtn;
    ImageButton backBtn;

    User user;
    UserProgressHelper userProgressHelper;

    RecyclerView firstPresentationRecyclerView, secondPresentationRecyclerView, thirdPresentationRecyclerView;
    View view;


    //WORKING ON BACK CLICKED (WHEN CLICKED RETURN TO HOME FRAGMENT)
    @Override
    public void onResume() {
        super.onResume();
        requireView().setFocusableInTouchMode(true);
        requireView().requestFocus();
        requireView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment((HomePageActivity) getActivity(), false)).commit();
                    return true;
                }
                return false;
            }
        });
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_sets_of_exercise, container, false);

        headTextView = view.findViewById(R.id.head_line_text_view_nav_sets_of_exercise);
        subHeadTextView = view.findViewById(R.id.sub_head_line_text_view_nav_sets_of_exercise);
        subHeadSumExerciseTextView = view.findViewById(R.id.sub_head_sum_of_exercise_text_view_nav_sets_of_exercise);
        subHeadNumExerciseTextView = view.findViewById(R.id.sub_head_num_of_exercise_text_view_nav_sets_of_exercise);
        partBodyTextView = view.findViewById(R.id.part_body_head_lind_text_view_nav_sets_of_exercise);


        firstExerciseBtn = view.findViewById(R.id.first_set_exercise_btn_nav_choose_exercise);
        secondExerciseBtn = view.findViewById(R.id.second_set_exercise_btn_nav_choose_exercise);
        thirdExerciseBtn = view.findViewById(R.id.third_set_exercise_btn_nav_choose_exercise);
        startExerciseBtn = view.findViewById(R.id.start_sets_exercise_btn_nav_choose_exercise);
        backBtn = view.findViewById(R.id.back_fragment_btn_nav_sets_of_exercise);

        firstArrowImgView = view.findViewById(R.id.first_arrow_img_view_sets_of_exercise_fragment);
        secondArrowImgView = view.findViewById(R.id.second_arrow_img_view_sets_of_exercise_fragment);
        thirdArrowImgView = view.findViewById(R.id.third_arrow_img_view_sets_of_exercise_fragment);

        firstPresentationRecyclerView = view.findViewById(R.id.first_set_list_view_nav_sets_of_exercise);
        secondPresentationRecyclerView = view.findViewById(R.id.second_set_list_view_nav_sets_of_exercise);
        thirdPresentationRecyclerView = view.findViewById(R.id.third_set_list_view_nav_sets_of_exercise);


        firstExerciseBtn.setOnClickListener(this);
        secondExerciseBtn.setOnClickListener(this);
        thirdExerciseBtn.setOnClickListener(this);
        startExerciseBtn.setOnClickListener(this);
        backBtn.setOnClickListener(this);



        if (getArguments() != null) {


            user = (User) getArguments().getSerializable("myObj");


            userProgressHelper = (UserProgressHelper) getArguments().getSerializable("list");


//            int week = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR) - user.getWeekOfSigned() + 1;

            int week = getArguments().getInt("week");

            headTextView.setText("שבוע " + (week + 1));

            subHeadTextView.setText(userProgressHelper.getExeTypeHeb());

            String numExerciseString = userProgressHelper.getExeNumOfActivitySet();

            String[] splitNum = numExerciseString.split("/");

            subHeadSumExerciseTextView.setText("/" + splitNum[1]);
            subHeadNumExerciseTextView.setText(splitNum[0]);

            partBodyTextView.setText(userProgressHelper.getExeSubStrengthHeb());


//            updateUserProgress();
            updateExerciseImages(view);




        }

        return view;
    }




    // PRODUCING THE EXERCISE ITEM BY THE WEEK AND THE EXERCISE TYPE (HAND, LEGS, FULL BODY)
    private void updateExerciseImages(View view) {

        equipmentAreaOneLinearLayout = view.findViewById(R.id.linear_layout_equipment_one_nav_sets_of_exercise);
        equipmentAreaTwoLinearLayout = view.findViewById(R.id.linear_layout_equipment_two_nav_sets_of_exercise);
        equipmentAreaThreeLinearLayout = view.findViewById(R.id.linear_layout_equipment_three_nav_sets_of_exercise);
        List<LinearLayout> equipmentArea = new ArrayList<>();
        equipmentArea.add(equipmentAreaOneLinearLayout);
        equipmentArea.add(equipmentAreaTwoLinearLayout);
        equipmentArea.add(equipmentAreaThreeLinearLayout);

        equipmentImageViewOne = view.findViewById(R.id.image_of_equipment_one_nav_sets_of_exercise);
        equipmentImageViewTwo = view.findViewById(R.id.image_of_equipment_two_nav_sets_of_exercise);
        equipmentImageViewThree = view.findViewById(R.id.image_of_equipment_three_nav_sets_of_exercise);
        List<ImageView> imageViewEquipmentList = new ArrayList<>();
        imageViewEquipmentList.add(equipmentImageViewOne);
        imageViewEquipmentList.add(equipmentImageViewTwo);
        imageViewEquipmentList.add(equipmentImageViewThree);

        equipmentTextViewOne = view.findViewById(R.id.text_view_of_equipment_one_nav_sets_of_exercise);
        equipmentTextViewTwo = view.findViewById(R.id.text_view_of_equipment_two_nav_sets_of_exercise);
        equipmentTextViewThree = view.findViewById(R.id.text_view_of_equipment_three_nav_sets_of_exercise);
        List<TextView> textViewEquipmentList = new ArrayList<>();
        textViewEquipmentList.add(equipmentTextViewOne);
        textViewEquipmentList.add(equipmentTextViewTwo);
        textViewEquipmentList.add(equipmentTextViewThree);


        for (int i = 0; i < userProgressHelper.getExercises_items().get(0).length; i++) {

            equipmentArea.get(i).setVisibility(View.VISIBLE);
            imageViewEquipmentList.get(i).setImageDrawable(ContextCompat.getDrawable(requireContext(), userProgressHelper.getExercises_items().get(0)[i]));
            textViewEquipmentList.get(i).setText(requireContext().getString(userProgressHelper.getExercises_items().get(1)[i]));

        }

    }




    private void updateUserProgress() {

        //TODO: FIND HOW MANY SETS DONE BY NOW - CLEAN THE ARRAY IF DAY PASS - OR 3 SETS HAVE DONE
        int size = 0;


        for (int i = 0; i < user.getSetsOfToday_24h().size(); i++) {

            if (user.getSetsOfToday_24h().get(i).getExerciseEnumHelper() == userProgressHelper.getExerciseEnumHelper()) {
                size++;
            }
        }


        if (size == 0) {




        } else if (size == 1) {

            firstExerciseBtn.setEnabled(false);


        } else {


            firstExerciseBtn.setEnabled(false);
            secondExerciseBtn.setEnabled(false);

        }

        userProgressHelper.setIndexSet(size);

    }



    private void initilaizeFirstExerciseTrainingRecyclerView() {

        firstPresentationRecyclerView.setHasFixedSize(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        firstPresentationRecyclerView.setLayoutManager(layoutManager);
        PresentationExerciseAdapter presentationExerciseAdapter = new PresentationExerciseAdapter(getContext(), userProgressHelper);
        presentationExerciseAdapter.setHasStableIds(true);
        firstPresentationRecyclerView.setAdapter(presentationExerciseAdapter);

    }



    private void initilaizeSecondExerciseTrainingRecyclerView() {

        secondPresentationRecyclerView.setHasFixedSize(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        secondPresentationRecyclerView.setLayoutManager(layoutManager);
        PresentationExerciseAdapter presentationExerciseAdapter = new PresentationExerciseAdapter(getContext(), userProgressHelper);
        presentationExerciseAdapter.setHasStableIds(true);
        secondPresentationRecyclerView.setAdapter(presentationExerciseAdapter);

    }



    private void initilaizeThirdExerciseTrainingRecyclerView() {

        thirdPresentationRecyclerView.setHasFixedSize(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        thirdPresentationRecyclerView.setLayoutManager(layoutManager);
        PresentationExerciseAdapter presentationExerciseAdapter = new PresentationExerciseAdapter(getContext(), userProgressHelper);
        presentationExerciseAdapter.setHasStableIds(true);
        thirdPresentationRecyclerView.setAdapter(presentationExerciseAdapter);

    }



    @Override
    public void onClick(View v) {

        disablePresentationBtns();

        switch (v.getId()) {


            case R.id.first_set_exercise_btn_nav_choose_exercise:

                if (firstPresentationRecyclerView.getVisibility() == View.VISIBLE){
                    animateTimeArea(firstPresentationRecyclerView, firstArrowImgView);
                }else {

                    initilaizeFirstExerciseTrainingRecyclerView();

                    userProgressHelper.setIndexSet(0);
//                    userProgressHelper.setNumOfExerciseHeb("סט ראשון");
                    animateTimeAreaOpen(firstPresentationRecyclerView, firstArrowImgView);


                    if (secondPresentationRecyclerView.getVisibility() == View.VISIBLE){
                        animateTimeArea(secondPresentationRecyclerView, secondArrowImgView);
                    }else if (thirdPresentationRecyclerView.getVisibility() == View.VISIBLE){
                        animateTimeArea(thirdPresentationRecyclerView, thirdArrowImgView);
                    }
                }


                break;


            case R.id.second_set_exercise_btn_nav_choose_exercise:

                if (secondPresentationRecyclerView.getVisibility() == View.VISIBLE){
                    animateTimeArea(secondPresentationRecyclerView, secondArrowImgView);
                }else {

                    initilaizeSecondExerciseTrainingRecyclerView();


                    userProgressHelper.setIndexSet(1);
//                    userProgressHelper.setNumOfExerciseHeb("סט שני");
                    animateTimeAreaOpen(secondPresentationRecyclerView, secondArrowImgView);



                    if (firstPresentationRecyclerView.getVisibility() == View.VISIBLE){
                        animateTimeArea(firstPresentationRecyclerView, firstArrowImgView);
                    }else if (thirdPresentationRecyclerView.getVisibility() == View.VISIBLE){
                        animateTimeArea(thirdPresentationRecyclerView, thirdArrowImgView);
                    }
                }


                break;


            case R.id.third_set_exercise_btn_nav_choose_exercise:

                if (thirdPresentationRecyclerView.getVisibility() == View.VISIBLE){
                    animateTimeArea(thirdPresentationRecyclerView, thirdArrowImgView);
                }else {

                    initilaizeThirdExerciseTrainingRecyclerView();


                    userProgressHelper.setIndexSet(2);
//                    userProgressHelper.setNumOfExerciseHeb("סט שלישי");
                    animateTimeAreaOpen(thirdPresentationRecyclerView, thirdArrowImgView);



                    if (firstPresentationRecyclerView.getVisibility() == View.VISIBLE){
                        animateTimeArea(firstPresentationRecyclerView, firstArrowImgView);
                    }else if (secondPresentationRecyclerView.getVisibility() == View.VISIBLE){
                        animateTimeArea(secondPresentationRecyclerView, secondArrowImgView);
                    }
                }

                break;


            case R.id.start_sets_exercise_btn_nav_choose_exercise:

                Fragment fragment = new ActivitySetFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("myObj", (User) getArguments().getSerializable("myObj"));
                bundle.putBoolean("nav_fragment", true);


                //TODO: SET INDEX BY SET NUMBER HAD DONE BY THE USER ALREADY
                userProgressHelper.setIndexSet(0);
                userProgressHelper.setSetsInProgressToday(new SetsOfToday(userProgressHelper.getExerciseEnumHelper(), 1,""));

                bundle.putSerializable("list", userProgressHelper);
                bundle.putSerializable("myObj", getArguments().getSerializable("myObj"));
                bundle.putSerializable("sets", getArguments().getSerializable("sets"));

                fragment.setArguments(bundle);
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();

                break;



            case R.id.back_fragment_btn_nav_sets_of_exercise:

                showExitExerciseDialog();

                break;
        }

        enablePresentationBtns();


    }


    private void animateTimeAreaOpen(final RecyclerView recyclerView, final ImageView imageView) {

//        ResizeAnimation resizeAnimation = new ResizeAnimation(recyclerView, recyclerView.getLayoutParams().width, recyclerView.getLayoutParams().width, 0, recyclerView.getLayoutParams().WRAP_CONTENT);
//        resizeAnimation.setDuration(750);
//        resizeAnimation.setFillEnabled(true);
//        resizeAnimation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//
//        recyclerView.startAnimation(resizeAnimation);

        recyclerView.setVisibility(View.VISIBLE);
        imageView.setRotation(-90);


    }


    private void animateTimeArea(final RecyclerView recyclerView, final ImageView imageView) {

//        ResizeAnimation resizeAnimation = new ResizeAnimation(recyclerView, recyclerView.getLayoutParams().width, recyclerView.getLayoutParams().width, recyclerView.getLayoutParams().height, 0);
//        resizeAnimation.setDuration(750);
//        resizeAnimation.setFillEnabled(true);
//        resizeAnimation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//
//        recyclerView.startAnimation(resizeAnimation);



        recyclerView.setVisibility(View.GONE);
        recyclerView.setAdapter(null);
        recyclerView.clearAnimation();
        imageView.setRotation(0);

    }



    public void showExitExerciseDialog() {


        final Dialog dialog = new Dialog(getContext());
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.exit_exercise_dialog, null);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(dialogView);

        TextView exitDialogBtn = dialog.findViewById(R.id.close_dialog_btn_exit_exercise_dialog);
        Button exitExerciseBtn = dialog.findViewById(R.id.exit_exercise_btn_exit_exercise_dialog);

        exitExerciseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment((HomePageActivity) getActivity(), false)).commit();
                dialog.dismiss();
            }
        });

        exitDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }


    public void disablePresentationBtns(){
        firstExerciseBtn.setEnabled(false);
        secondExerciseBtn.setEnabled(false);
        thirdExerciseBtn.setEnabled(false);
    }



    public void enablePresentationBtns(){
        firstExerciseBtn.setEnabled(true);
        secondExerciseBtn.setEnabled(true);
        thirdExerciseBtn.setEnabled(true);
    }

}
