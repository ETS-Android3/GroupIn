package com.example.groupin;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewholder>{
   ArrayList<model> dataholder;
   Context context;

    public myAdapter(ArrayList<model> dataholder, Context context) {

        this.dataholder = dataholder;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_project_row,parent,false);
        return  new myViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewholder holder, int position) {

        final model temp= dataholder.get(position);
        String p=temp.getPid();

        holder.dname.setText(dataholder.get(position).getPname());
        holder.ddue.setText(dataholder.get(position).getPdue());
        holder.dstatus.setText(dataholder.get(position).getPstatus());

        holder.dname.setOnClickListener(v -> {
            Intent intent = new Intent(context,Tasks.class);
            Log.d(p, "passed value");
            intent.putExtra("pid",p);

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });


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
