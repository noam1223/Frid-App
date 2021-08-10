package com.example.fridapp.activities.fragments.profile;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fridapp.R;
import com.example.fridapp.adapter.UserPicturesAdapter;
import com.example.fridapp.helpers.DecimalDigitsInputFilter;
import com.example.fridapp.helpers.interfaces.OnCheckNotificationListiener;
import com.example.fridapp.helpers.interfaces.OnDownloadFinishVideo;
import com.example.fridapp.helpers.singleton.UserSingleton;
import com.example.fridapp.model.User;

import java.text.DecimalFormat;
import java.util.Calendar;

public class ProfileFragment extends Fragment implements OnDownloadFinishVideo {

    RelativeLayout parentRelativeLayout;
    TextView weekTitleTextView, nameTitleTextView, currentWeightUser, startWeightUser, differenceStartAndCurrentWeightTextView, percentTextView;
    ProgressBar userArcProgressFullExercise;
    RecyclerView userPicturesRecyclerView;
    RecyclerView.Adapter pictureRecyclerViewAdapter;
    ImageButton editCurrentWeightImgBtn;

    User user;
    Uri imageUri = null;
    private boolean[] openedPic;
    boolean takePhoto = false;
    OnCheckNotificationListiener onCheckNotificationListiener;

    int imagePositionChange = 0, numOfOpenedPosition = 0;

    private static final int TAKE_PHOTO_CODE = 1000;


    public ProfileFragment(boolean takePhoto, OnCheckNotificationListiener onCheckNotificationListiener) {
        this.takePhoto = takePhoto;
        this.onCheckNotificationListiener = onCheckNotificationListiener;
    }


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

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        parentRelativeLayout = view.findViewById(R.id.parent_relative_layout_profile_fragment);

        UserSingleton.getInstance().getUser().setExercise(false);

        weekTitleTextView = view.findViewById(R.id.week_text_view_nav_profile);
        nameTitleTextView = view.findViewById(R.id.user_name_text_view_nav_profile);
        currentWeightUser = view.findViewById(R.id.week_weight_user_nav_profile);
        startWeightUser = view.findViewById(R.id.start_weight_user_nav_profile);
        percentTextView = view.findViewById(R.id.precents_progress_nav_profile);

        differenceStartAndCurrentWeightTextView = view.findViewById(R.id.difference_start_weight_to_current_weight_nav_profile);
        editCurrentWeightImgBtn = view.findViewById(R.id.edit_current_weight_image_btn_nav_profile);
        editCurrentWeightImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showEditCurrentWeightDialog();
            }
        });


        userArcProgressFullExercise = view.findViewById(R.id.arc_progress_nav_profile);
        userPicturesRecyclerView = view.findViewById(R.id.pictures_user_recycler_view_nav_profile);

        user = UserSingleton.getInstance().getUser();


        int week = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR) - user.getWeekOfSigned() + 1;
        weekTitleTextView.setText("שבוע " + week);
        nameTitleTextView.setText(user.getName() + " " + user.getLastName());
        startWeightUser.setText(user.getWeight() + " ק״ג");

        if (user.getCurrentWeight() > 0)
            currentWeightUser.setText(user.getCurrentWeight() + " ק״ג");
        else currentWeightUser.setText("");


        int sumOfExercisesUntilNow = user.getUserProgress().getTotalOfExerciseDoneByNow() + user.getSetHaveDoneByWeek().size();

        double avgFl = (double) sumOfExercisesUntilNow / user.getUserProgress().getTotalExerciseTobeDone();

        int avg = (int) (avgFl * 100);

        percentTextView.setText(avg + "");
        userArcProgressFullExercise.setProgress(sumOfExercisesUntilNow);

        openedPic = picThatOpenByWeek(week);
        initializeUserPicturesRecyclerView(week, openedPic);

        if (takePhoto)
            showTakePicDialog();

        for (boolean b : openedPic) {
            if (b) {
                numOfOpenedPosition++;
            }
        }


        return view;
    }


    private void showTakePicDialog() {

        final Dialog dialog = new Dialog(getContext());
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.take_photo_dialog, null);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(dialogView);


        Button goToTakePicBtn = dialog.findViewById(R.id.go_to_profile_activity_btn_take_photo_dialog);
        TextView cancelDialogTextView = dialog.findViewById(R.id.cancel_text_view_take_photo_dialog);

        goToTakePicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                imagePositionChange = numOfOpenedPosition;
                selectImage();
                dialog.dismiss();

            }
        });


        cancelDialogTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }


    private void showEditCurrentWeightDialog() {
        final Dialog dialog = new Dialog(getContext());
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.edit_current_weight_dialog, null);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(dialogView);


        final EditText editText = dialog.findViewById(R.id.edit_current_weight_dialog_edit_text);
        editText.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(10, 1)});
        TextView textView = dialog.findViewById(R.id.close_edit_current_weight_dialog_text_view);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.dismiss();

            }
        });


        Button button = dialog.findViewById(R.id.save_edit_current_weight_dialog_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!editText.getText().toString().isEmpty()) {


                    user.setCurrentWeight(Float.parseFloat(editText.getText().toString()));

                    workOnEditCurrentTextView(Float.parseFloat(editText.getText().toString()));

                    dialog.dismiss();
                } else
                    Toast.makeText(getContext(), "אנא הכנס ערך רלוונטי", Toast.LENGTH_SHORT).show();

            }
        });

        dialog.show();
    }


    private void initializeUserPicturesRecyclerView(int week, boolean[] openedPic) {

        userPicturesRecyclerView.setHasFixedSize(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, true);
        userPicturesRecyclerView.setLayoutManager(layoutManager);
        pictureRecyclerViewAdapter = new UserPicturesAdapter(getContext(), user, this, openedPic);
        userPicturesRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                outRect.left = 16;
                outRect.right = 16;
            }
        });
        userPicturesRecyclerView.setAdapter(pictureRecyclerViewAdapter);

    }


    @Override
    public void onFinishDownload(int position) {

        this.imagePositionChange = position;
        selectImage();
    }


    private void selectImage() {
        if (isStoragePermissionGranted()) {

            Intent pickPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            mStartForResult.launch(pickPhoto);

        } else
            Toast.makeText(getContext(), "אין הרשאה לגלרייה", Toast.LENGTH_SHORT).show();
    }


    public boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(requireActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                requestPermissionLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            return true;
        }
    }


    private final ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
                @Override
                public void onActivityResult(Boolean result) {

                    if (result)
                        selectImage();

                }
            });


    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {


                        if (imageUri == null) {
                            imageUri = result.getData().getData();
                        }

                        String path = savingPicPath(imageUri);

                        int numOfTrue = 0;

                        for (boolean what :
                                openedPic) {

                            if (what) {
                                numOfTrue++;
                            }

                        }


                        if (user.getImageUrl().size() == 0) {
                            user.getImageUrl().add(path);
                        } else if (numOfTrue == user.getImageUrl().size()) {
                            user.getImageUrl().set(imagePositionChange, path);
                        } else user.getImageUrl().add(path);
                        pictureRecyclerViewAdapter.notifyDataSetChanged();
                        onCheckNotificationListiener.onCheckNotification(false);

                        UserSingleton.getInstance().setUser(user);
//
                    }
                }
            });


    //WORKING ON THE DIFFERENCE BETWEEN CURRENT AND START WEIGHT
    private void workOnEditCurrentTextView(float currentWeight) {

        float startWeight = user.getWeight();
        float differenceWeight = currentWeight - startWeight;

        DecimalFormat form = new DecimalFormat("0.0");
        StringBuilder stringBuilder = new StringBuilder();

        if (differenceWeight >= 0.1f) {


            stringBuilder.append("+");
            stringBuilder.append(form.format(differenceWeight));


            differenceStartAndCurrentWeightTextView.setVisibility(View.VISIBLE);
            differenceStartAndCurrentWeightTextView.setText("(" + stringBuilder + ")");

        } else if (differenceWeight <= -0.1f) {

            stringBuilder.append(form.format(differenceWeight));

            differenceStartAndCurrentWeightTextView.setVisibility(View.VISIBLE);
            differenceStartAndCurrentWeightTextView.setText("(" + stringBuilder + ")");
        }


        currentWeightUser.setText(user.getCurrentWeight() + " ק״ג");

    }


    //CHECKING THE NUMBER OF OPENING PICTURES
    private boolean[] picThatOpenByWeek(int week) {

        boolean[] openedPic;

        if (week >= 1 && week < 4) {
            openedPic = new boolean[]{true, false, false, false};
        } else if (week >= 4 && week < 8) {
            openedPic = new boolean[]{true, true, false, false};
        } else if (week >= 8 && week < 12) {
            openedPic = new boolean[]{true, true, true, false};
        } else openedPic = new boolean[]{true, true, true, true};


        return openedPic;
    }


    @Override
    public void onDestroy() {

        UserSingleton.getInstance().setUser(user);

        super.onDestroy();

    }


    public String savingPicPath(Uri selectedImage) {
        String[] filePathColumn = {MediaStore.Images.Media.DATA};

        Cursor cursor = requireActivity().getContentResolver().query(selectedImage,
                filePathColumn, null, null, null);
        cursor.moveToFirst();

        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        return cursor.getString(columnIndex);
    }

}
