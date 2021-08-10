package com.example.fridapp.activities.fragments.signinfragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fridapp.R;
import com.example.fridapp.helpers.DecimalDigitsInputFilter;

public class WeightFragment extends Fragment {

    EditText weightEditText;
    SignInCallBack signInCallBack;

    public WeightFragment(SignInCallBack signInCallBack) {
        this.signInCallBack = signInCallBack;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weight,container,false);

        weightEditText = view.findViewById(R.id.weight_edit_text_weight_fragment);
        weightEditText.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 1)});

        weightEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                signInCallBack.weightCallBack(weightEditText.getText().toString());
            }
        });

        return view;
    }
    
}
