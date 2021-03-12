package com.example.acm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class galleryAdapter extends RecyclerView.Adapter<galleryAdapter.ViewHolder> {

    private Context context;
    private List<gallerymodel> MainImageUploadInfoList;

    public galleryAdapter(Context context, List<gallerymodel> TempList) {

        this.MainImageUploadInfoList = TempList;

        this.context = context;
    }


    @Override
    public galleryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallerylayout, parent, false);

        galleryAdapter.ViewHolder viewHolder = new galleryAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final galleryAdapter.ViewHolder holder, int position) {
        final gallerymodel UploadInfo = MainImageUploadInfoList.get(position);


        Glide.with(context).load(UploadInfo.getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {

        return MainImageUploadInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {



        public ImageView image;


        public ViewHolder(View itemView) {
            super(itemView);


            image=(ImageView)itemView.findViewById(R.id.galleryimage);

        }
    }
}

