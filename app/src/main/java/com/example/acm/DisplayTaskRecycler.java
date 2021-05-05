package com.example.acm;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Option;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.List;

public class DisplayTaskRecycler extends FirebaseRecyclerAdapter<choicemodel,DisplayTaskRecycler.ViewHolder> {

    private Context context;
    private List<choicemodel> MainImageUploadInfoList;

//    public DisplayTaskRecycler(Context context, List<choicemodel> TempList) {
//
//        this.MainImageUploadInfoList = TempList;
//
//        this.context = context;
//    }



    public DisplayTaskRecycler(FirebaseRecyclerOptions<choicemodel> options, Test displayTask) {

        super(options);
        this.context = context;
    }

    @Override
    public DisplayTaskRecycler.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.displaytasklayout, parent, false);

        DisplayTaskRecycler.ViewHolder viewHolder = new DisplayTaskRecycler.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final DisplayTaskRecycler.ViewHolder holder, int position,@NonNull final choicemodel UploadInfo) {
//        final choicemodel UploadInfo = MainImageUploadInfoList.get(position);

        holder.Name.setText(UploadInfo.getName());
        holder.Download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(UploadInfo.getPdfUrl()));
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                context.startActivity(i);
                Toast.makeText(context,"Downloaded",Toast.LENGTH_SHORT).show();
            }
        });



    }

//    @Override
//    public int getItemCount() {
//
//        return MainImageUploadInfoList.size();
//    }

    class ViewHolder extends RecyclerView.ViewHolder {


        public TextView Name;
       // public TextView Choice2;
        public RelativeLayout Layout;
        public ImageView Download;


        public ViewHolder(View itemView) {
            super(itemView);

            Name = (TextView) itemView.findViewById(R.id.name);
            Layout=itemView.findViewById(R.id.layout);
            Download=itemView.findViewById(R.id.download);

        }
    }
}

