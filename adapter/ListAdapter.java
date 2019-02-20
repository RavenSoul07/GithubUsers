package com.ravensoul.githubusers.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ravensoul.githubusers.R;
import com.ravensoul.githubusers.model.UserData;
import com.ravensoul.githubusers.view.UserInfoActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private List<UserData> mData;
    private Context mContext;


    public ListAdapter(List<UserData> data, Context context) {
        mData = data;
        mContext = context;
    }

    @NonNull
    @Override
    public ListAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_list, viewGroup, false);
        RecyclerView.ViewHolder holder = new ListViewHolder(view);
        return (ListViewHolder) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ListAdapter.ListViewHolder listViewHolder, int i) {
        final UserData data = mData.get(i);
        Picasso.get().load(data.getAvatarUrl())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(listViewHolder.imageView);

        listViewHolder.listText.setText(data.getLogin());

        listViewHolder.listText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = listViewHolder.listText.getContext();
                Intent intent = new Intent(context, UserInfoActivity.class);
                intent.putExtra("login", data.getLogin());
                context.startActivity(intent);
            }
        });

        listViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = listViewHolder.imageView.getContext();
                Intent intent = new Intent(context, UserInfoActivity.class);
                intent.putExtra("login", data.getLogin());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (mData != null && mData.size() != 0) {
            return mData.size();
        } else {
            return 0;
        }
    }

    public void loadNewData(List<UserData> list) {
        mData = list;
        notifyDataSetChanged();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView listText;
        ImageView imageView;

        public ListViewHolder(View itemView) {
            super(itemView);
            this.listText = itemView.findViewById(R.id.list);
            this.imageView = itemView.findViewById(R.id.avatar);
        }
    }


}
