package com.example.groupin;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapterTask extends RecyclerView.Adapter<myAdapterTask.myViewholder>{
    ArrayList<modelTask> datahold;
    Context context;

    public myAdapterTask(ArrayList<modelTask> dataholder, Context context) {

        this.datahold = dataholder;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_task,parent,false);
        return  new myViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewholder tholder, int position) {

        final modelTask temp= datahold.get(position);
        String t=temp.ttaskid;

        tholder.tname.setText(datahold.get(position).getTtask());
        tholder.tdue.setText(datahold.get(position).getTdue());
        tholder.tmem.setText(datahold.get(position).getTmember());
        tholder.tstatus.setText(datahold.get(position).getTstatus());

        tholder.tname.setOnClickListener(v -> {
            Intent intent = new Intent(context,Tasks.class);
            intent.putExtra("tid",t);

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });


    }

    @Override
    public int getItemCount() {
        return datahold.size();
    }

    class myViewholder extends RecyclerView.ViewHolder{
        TextView tname,tdue,tmem,tstatus;
        public myViewholder(@NonNull View itemView) {
            super(itemView);
            tname=itemView.findViewById(R.id.displaytname);
            tdue=itemView.findViewById(R.id.displaytdue);
            tstatus=itemView.findViewById(R.id.sttatus);
            tmem = itemView.findViewById(R.id.tmember);
        }
    }
}
