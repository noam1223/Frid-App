package com.example.fridapp.activities.fragments.signinfragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.fridapp.R;

public class SexFragment extends Fragment implements View.OnClickListener {

    Button maleBtn, femaleBtn;
    SignInCallBack signInCallBack;

    public SexFragment(SignInCallBack signInCallBack) {
        this.signInCallBack = signInCallBack;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_sex,container,false);

        maleBtn = view.findViewById(R.id.male_sex_btn_sex_fragment);
        femaleBtn = view.findViewById(R.id.female_sex_btn_sex_fragment);

        maleBtn.setOnClickListener(this);
        femaleBtn.setOnClickListener(this);

        if (getArguments() != null){
            if (getArguments().getString("sex") != null){
                if (getArguments().getString("sex").equals("זכר")){
                    setMaleClicked();
                }else setFemaleClicked();
            }
        }


        return view;
    }


    private void setMaleClicked() {
        maleBtn.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.custom_sex_button_clicked));
        maleBtn.setTextColor(ContextCompat.getColor(requireContext(), R.color.buttonColor));

        femaleBtn.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.custom_sex_button));
        femaleBtn.setTextColor(Color.BLACK);

        signInCallBack.sexTypeCallBack(maleBtn.getText().toString());
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.male_sex_btn_sex_fragment:
                setMaleClicked();
                break;


            case R.id.female_sex_btn_sex_fragment:
                setFemaleClicked();
                break;

        }

    }


    private void setFemaleClicked() {
        femaleBtn.setBackground(ContextCompat.getDrawable(requireContext(), (R.drawable.custom_sex_button_clicked)));
        femaleBtn.setTextColor(ContextCompat.getColor(requireContext(), R.color.buttonColor));

        maleBtn.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.custom_sex_button));
        maleBtn.setTextColor(Color.BLACK);

        signInCallBack.sexTypeCallBack(femaleBtn.getText().toString());
    }

}
