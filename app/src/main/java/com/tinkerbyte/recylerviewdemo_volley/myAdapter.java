package com.tinkerbyte.recylerviewdemo_volley;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder> {

     private UserList [] data;
     private Context context;
    public myAdapter(Context context,UserList[] data)
    {
        this.context= context;
        this.data = data;

    }
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater myInflator = LayoutInflater.from(parent.getContext());
        View view = myInflator.inflate(R.layout.myrecycler_view,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
       UserList User_data= data[position];
        holder.userName.setText(User_data.getLogin());
        Glide.with(holder.userpic.getContext()).load(User_data.getAvatarUrl()).into(holder.userpic);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        ImageView userpic;
        TextView userName;
        public myViewHolder(View itemView) {
            super(itemView);
            userpic = (ImageView) itemView.findViewById(R.id.img);
            userName= (TextView) itemView.findViewById(R.id.User_name);

        }
    }
}
