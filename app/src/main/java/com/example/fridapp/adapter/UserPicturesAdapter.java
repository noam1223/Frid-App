package com.example.fridapp.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fridapp.R;
import com.example.fridapp.helpers.interfaces.OnDownloadFinishVideo;
import com.example.fridapp.model.User;

import java.io.ByteArrayOutputStream;

public class UserPicturesAdapter extends RecyclerView.Adapter<UserPicturesAdapter.UserPicturesViewHoler>{


    Context context;
    User user;
    OnDownloadFinishVideo onDownloadFinishVideo;
    private boolean[] openedPic;
    private String[] weeks = {"שבוע 1", "שבוע 4", "שבוע 8", "שבוע 12"};



    public UserPicturesAdapter(Context context, User user, OnDownloadFinishVideo onDownloadFinishVideo, boolean[] openedPic) {
        this.context = context;
        this.user = user;
        this.onDownloadFinishVideo = onDownloadFinishVideo;
        this.openedPic = openedPic;
    }



    @NonNull
    @Override
    public UserPicturesViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.pictures_user_item, null, false);
        return new UserPicturesViewHoler(layoutView);
    }



    @Override
    public void onBindViewHolder(@NonNull final UserPicturesViewHoler holder, int position) {

        if (openedPic[holder.getAdapterPosition()]) {

            holder.pictureImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onDownloadFinishVideo.onFinishDownload(holder.getAdapterPosition());
                }
            });

            holder.addPictureImageBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onDownloadFinishVideo.onFinishDownload(holder.getAdapterPosition());
                }
            });

            if (user.getImageUrl().size() > position) {

                if (user.getImageUrl().get(holder.getAdapterPosition()) != null) {


                    holder.pictureImageView.setBackground(null);

                    holder.pictureImageView.setImageBitmap(BitmapFactory.decodeFile(user.getImageUrl().get(holder.getAdapterPosition())));

                    holder.addPictureImageBtn.setVisibility(View.GONE);
                    holder.waitingForPictureTextView.setVisibility(View.GONE);
                }
            }

        }else {
            holder.pictureImageView.setBackground(ContextCompat.getDrawable(context, R.drawable.custom_image_view2));
            holder.addPictureImageBtn.setBackground(ContextCompat.getDrawable(context, R.drawable.ic_icon_lock));
            holder.waitingForPictureTextView.setText("ממש בקרוב");
        }



        holder.weekNumOfPicTextView.setText(weeks[holder.getAdapterPosition()]);

    }



    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }


    @Override
    public int getItemCount() {
        return openedPic.length;
    }


    class UserPicturesViewHoler extends RecyclerView.ViewHolder{

        ImageView pictureImageView;
        ImageButton addPictureImageBtn;
        TextView weekNumOfPicTextView, waitingForPictureTextView;

        public UserPicturesViewHoler(@NonNull View itemView) {
            super(itemView);

           pictureImageView = itemView.findViewById(R.id.image_view_picture_item);
           addPictureImageBtn = itemView.findViewById(R.id.add_picture_image_btn_item);
           weekNumOfPicTextView = itemView.findViewById(R.id.week_num_picture_nav_profile);
           waitingForPictureTextView = itemView.findViewById(R.id.waiting_for_picture_text_view_pictures_user_item);

        }
    }
}
