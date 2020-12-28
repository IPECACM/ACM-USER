package com.example.acm;

import android.content.Context;
import android.content.Intent;
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

public class AddfacultyRecycler extends RecyclerView.Adapter<AddfacultyRecycler.ViewHolder> {

    private Context context;
    private List<facultymodel> MainImageUploadInfoList;

    public AddfacultyRecycler(Context context, List<facultymodel> TempList) {

        this.MainImageUploadInfoList = TempList;

        this.context = context;
    }


    @Override
    public AddfacultyRecycler.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.faculty_item_layout, parent, false);

        AddfacultyRecycler.ViewHolder viewHolder = new AddfacultyRecycler.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final AddfacultyRecycler.ViewHolder holder, int position) {
        final facultymodel UploadInfo = MainImageUploadInfoList.get(position);

        holder.Name.setText(UploadInfo.getF_Name());
        holder.Email.setText(UploadInfo.getF_Email());
        holder.Post.setText(UploadInfo.getF_Post());
        Glide.with(context).load(UploadInfo.getF_Image()).into(holder.image);
    }

    @Override
    public int getItemCount() {

        return MainImageUploadInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        public TextView Name;
        public TextView Email;
        public TextView Post;
        public ImageView image;
        public Button Show;
        public CardView cardView;
        public TextView UserID;

        public ViewHolder(View itemView) {
            super(itemView);

            Name = (TextView) itemView.findViewById(R.id.fname);
            Email = (TextView) itemView.findViewById(R.id.femail);
            // Show=(Button)itemView.findViewById(R.id.show);
            Post = (TextView) itemView.findViewById(R.id.fpost);
            image=(ImageView)itemView.findViewById(R.id.fimage);
            //  UserID = (TextView) itemView.findViewById(R.id.uid);
            //cardView = (CardView) itemView.findViewById(R.id.cardview2);
//            Show.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent i=new Intent(context,AdminUserProductsDisplay.class);
//                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//                    context.startActivity(i);
//                }
//            });
        }
    }
}

