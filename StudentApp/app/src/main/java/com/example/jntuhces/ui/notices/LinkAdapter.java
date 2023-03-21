package com.example.jntuhces.ui.notices;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jntuhces.R;


import java.util.ArrayList;
import java.util.List;

public class LinkAdapter extends RecyclerView.Adapter<LinkAdapter.LinkViewAdapter> {

    private Context context;
    private List<LinksData> list;

    public LinkAdapter(Context context, List<LinksData> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public LinkViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.linkfeed_item_layout,parent,false);

        return new LinkViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LinkViewAdapter holder, int position) {

        final LinksData currentItem=list.get(position);

        holder.title.setText(currentItem.getTitle());
        holder.date.setText(currentItem.getDate());
        holder.time.setText(currentItem.getTime());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(list.get(position).getUrl()));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class LinkViewAdapter extends RecyclerView.ViewHolder {


        private TextView title,date,time;

        public LinkViewAdapter(@NonNull View itemView) {
            super(itemView);
            title= itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
        }
    }
}
