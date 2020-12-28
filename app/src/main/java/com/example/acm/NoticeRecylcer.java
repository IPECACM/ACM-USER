package com.example.acm;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class NoticeRecylcer extends RecyclerView.Adapter<NoticeRecylcer.ViewHolder> {

    private Context context;
    private List<noticemodel> MainImageUploadInfoList;

    public NoticeRecylcer(Context context, List<noticemodel> TempList) {

        this.MainImageUploadInfoList = TempList;

        this.context = context;
    }


    @Override
    public NoticeRecylcer.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notice_layout, parent, false);

        NoticeRecylcer.ViewHolder viewHolder = new NoticeRecylcer.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final NoticeRecylcer.ViewHolder holder, int position) {
        final noticemodel UploadInfo = MainImageUploadInfoList.get(position);

        holder.Title.setText(UploadInfo.getPdfTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,UploadInfo.getPdfTitle(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.Download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i = new Intent(Intent.ACTION_VIEW);
               i.setData(Uri.parse(UploadInfo.pdfUrl));
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                context.startActivity(i);
                Toast.makeText(context,"Downloaded",Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {

        return MainImageUploadInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        public TextView Title;
//        public TextView Email;
//        public TextView Post;
       public ImageView Download;
//        public Button Show;
//        public CardView cardView;
//        public TextView UserID;

        public ViewHolder(View itemView) {
            super(itemView);

            Title = (TextView) itemView.findViewById(R.id.pdf);
           Download=(ImageView)itemView.findViewById(R.id.download);

        }
    }
}

