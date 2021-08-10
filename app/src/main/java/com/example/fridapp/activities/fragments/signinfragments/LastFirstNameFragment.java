package com.example.fridapp.activities.fragments.signinfragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fridapp.R;

public class LastFirstNameFragment extends Fragment implements TextWatcher {

    EditText firstNameEditText, lastNameEditText;
    SignInCallBack signInCallBack;

    public LastFirstNameFragment(SignInCallBack signInCallBack) {
        this.signInCallBack = signInCallBack;
    }


    @Override
    public void onResume() {
        super.onResume();


//
//
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_last_first_name, container, false);


        firstNameEditText = view.findViewById(R.id.first_name_edit_text_last_first_name_fragment);
        lastNameEditText = view.findViewById(R.id.last_name_edit_text_last_first_name_fragment);

        firstNameEditText.addTextChangedListener(this);
        lastNameEditText.addTextChangedListener(this);


        return view;
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

        signInCallBack.firstLastNameCallBack(firstNameEditText.getText().toString(), lastNameEditText.getText().toString());

    }


}
