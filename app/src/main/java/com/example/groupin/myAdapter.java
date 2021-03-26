package com.example.groupin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewholder>{
   ArrayList<model> dataholder;

    public myAdapter(ArrayList<model> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_project_row,parent,false);
        return  new myViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewholder holder, int position) {
        holder.dname.setText(dataholder.get(position).getPname());
        holder.ddue.setText(dataholder.get(position).getPdue());
        holder.dstatus.setText(dataholder.get(position).getPstatus());
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myViewholder extends RecyclerView.ViewHolder{
        TextView dname,ddue,dstatus;
        public myViewholder(@NonNull View itemView) {
            super(itemView);
            dname=itemView.findViewById(R.id.displayname);
            ddue=itemView.findViewById(R.id.displaydue);
            dstatus=itemView.findViewById(R.id.status);
        }
    }
}
