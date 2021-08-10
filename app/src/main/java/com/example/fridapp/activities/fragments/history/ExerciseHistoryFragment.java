package com.example.fridapp.activities.fragments.history;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fridapp.R;
import com.example.fridapp.adapter.ExerciseTrainingAdapter;
import com.example.fridapp.adapter.SpinnerWeekAdapter;
import com.example.fridapp.helpers.DefaultExerciseWeek;
import com.example.fridapp.helpers.UserProgressHelper;
import com.example.fridapp.helpers.interfaces.FragmentListener;
import com.example.fridapp.helpers.singleton.UserSingleton;
import com.example.fridapp.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;


public class ExerciseHistoryFragment extends Fragment implements FragmentListener {

    TextView weekNumTextView;
    RecyclerView weeklyExerciseListView;
    Spinner weeklySpinner;

    String[] weekStrings = {"שבוע 1", "שבוע 2", "שבוע 3", "שבוע 4", "שבוע 5", "שבוע 6", "שבוע 7","שבוע 8", "שבוע 9", "שבוע 10", "שבוע 11", "שבוע 12"};

    User user;
    UserProgressHelper userProgressHelper;



    @Override
    public void onResume() {
        super.onResume();

        requireView().setFocusableInTouchMode(true);
        requireView().requestFocus();
        requireView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {

                if (keyEvent.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {

                    if (getActivity() != null)
                        getActivity().finish();

                    return true;
                }


                return false;
            }
        });
    }




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercise_history,container,false);


        weeklyExerciseListView = view.findViewById(R.id.weekly_exercise_list_view_nav_exercise_history);
        weeklySpinner = view.findViewById(R.id.choose_week_spinner_exercise_history);


        weeklySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                weeklyExerciseListView.setAdapter(new ExerciseTrainingAdapter(getContext(), UserSingleton.getInstance().getUser(), ExerciseHistoryFragment.this, new DefaultExerciseWeek().getFitItExerciseForWeek(), new UserProgressHelper(), true , i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        int numOfWeek = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR) - UserSingleton.getInstance().getUser().getWeekOfSigned();

        List<String> strings = new ArrayList<>(Arrays.asList(weekStrings).subList(0, numOfWeek + 1));

        weeklySpinner.setAdapter(new SpinnerWeekAdapter(getContext(), R.layout.weekly_spinner_item, strings));

        weekNumTextView = view.findViewById(R.id.head_text_view_nav_exercise_history);
        weeklyExerciseListView.setNestedScrollingEnabled(false);
        weeklyExerciseListView.setHasFixedSize(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        weeklyExerciseListView.setLayoutManager(layoutManager);

        return view;
    }


    @Override
    public void onTransactionFragmentListener(Fragment fragment) {
        getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }


}
