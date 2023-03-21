package com.example.teachersapp.notice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teachersapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class LinkAdapter extends RecyclerView.Adapter<LinkAdapter.LinkViewAdapter> {

    private Context context;
    private ArrayList<LinksData> list;

    public LinkAdapter(Context context, ArrayList<LinksData> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public LinkViewAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.linkfeed_item_layout,parent,false);

        return new LinkAdapter.LinkViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(LinkAdapter.LinkViewAdapter holder, int position) {
        LinksData currentItem=list.get(position);

        holder.title.setText(currentItem.getTitle());

        holder.DeleteNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("Links");
                reference.child(currentItem.getKey()).removeValue()
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(Task<Void> task) {
                                Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                            }
                        }) .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(context, "Something went Wrong", Toast.LENGTH_SHORT).show();

                    }
                });
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class LinkViewAdapter extends RecyclerView.ViewHolder {

        private Button DeleteNotice;
        private TextView title;

        public LinkViewAdapter(View itemView) {
            super(itemView);
            DeleteNotice= itemView.findViewById(R.id.DeleteNotice);
            title= itemView.findViewById(R.id.title);
        }
    }
}
