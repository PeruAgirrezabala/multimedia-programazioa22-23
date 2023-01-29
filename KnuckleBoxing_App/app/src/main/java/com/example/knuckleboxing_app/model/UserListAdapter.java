package com.example.knuckleboxing_app.model;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.knuckleboxing_app.R;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder> {

    private Context context;
    private List<User> userList;
    public UserListAdapter(Context context) {
        this.context = context;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListAdapter.MyViewHolder holder, int position) {
        holder.userTV.setText("NOMBRE:"+this.userList.get(position).usuario);
        holder.generoTV.setText("SEXO:"+this.userList.get(position).sexo);
        if (this.userList.get(position).experiencia) {
            holder.experienciaTV.setText("EXPERIENCIA:SI");
        } else {
            holder.experienciaTV.setText("EXPERIENCIA:NO");
        }
    }

    @Override
    public int getItemCount() {
        return  this.userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView userTV;
        TextView generoTV;
        TextView experienciaTV;

        public MyViewHolder(View view) {
            super(view);
            userTV = view.findViewById(R.id.userTV);
            generoTV = view.findViewById(R.id.genreTV);
            experienciaTV = view.findViewById(R.id.experienceTV);

        }
    }
}
