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

public class PrimeCoreRecycler extends RecyclerView.Adapter<PrimeCoreRecycler.ViewHolder> {

    private Context context;
     List<facultymodel> MainImageUploadInfoList;

    public PrimeCoreRecycler(Context context, List<facultymodel> TempList) {

        this.MainImageUploadInfoList = TempList;

        this.context = context;
    }


    @Override
    public PrimeCoreRecycler.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.primecorelayout, parent, false);

        PrimeCoreRecycler.ViewHolder viewHolder = new PrimeCoreRecycler.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final PrimeCoreRecycler.ViewHolder holder, int position) {
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

        public ViewHolder(View itemView) {
            super(itemView);

            Name = (TextView) itemView.findViewById(R.id.pname);
            Email = (TextView) itemView.findViewById(R.id.pemail);
            // Show=(Button)itemView.findViewById(R.id.show);
            Post = (TextView) itemView.findViewById(R.id.ppost);
            image=(ImageView)itemView.findViewById(R.id.pimage);
                            }
//            });
        }
    }

