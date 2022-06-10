package com.example.rppoop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class Adapter extends FirebaseRecyclerAdapter<model, Adapter.viewholder> {


    public Adapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewholder holder, int position, @NonNull model model) {
        holder.name.setText(model.getName());
//        holder.avr_sal.setText(model.getAverageSalary());
//        holder.placements.setText(model.getPlacements());
//        holder.rounds.setText(model.getRounds());
        Glide.with(holder.logo.getContext()).load(model.getLogo()).into(holder.logo);

            holder.logo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    AppCompatActivity activity = (AppCompatActivity)view.getContext();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper, new descFragment(model.getName(), model.getAverageSalary(),model.getLogo(), model.getPlacements(), model.getRounds())).addToBackStack(null).commit();

            }
        });
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_design,parent,false);
        return new viewholder(view);
    }

    public class viewholder extends RecyclerView.ViewHolder
    {
        ImageView logo;
        TextView name, avr_sal, placements, rounds;
        public viewholder(@NonNull View itemView) {
            super(itemView);

            logo = itemView.findViewById(R.id.logo);
            name = itemView.findViewById(R.id.name);
//            avr_sal = itemView.findViewById(R.id.avr_sal);
//            placements = itemView.findViewById(R.id.placements);
//            rounds = itemView.findViewById(R.id.rounds);
        }
    }

}
