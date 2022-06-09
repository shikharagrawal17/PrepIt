package com.example.rppoop.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;


import com.example.rppoop.R;
import com.example.rppoop.models.QuestionModel;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>{
    private Context context;
    private ArrayList<QuestionModel> QuestionArrayList;

    public QuestionAdapter(Context context, ArrayList<QuestionModel> QuestionArrayList) {
        this.context = context;
        this.QuestionArrayList = QuestionArrayList;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.question_item, parent, false);
        return new QuestionViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        QuestionModel Question = QuestionArrayList.get(position);
        holder.question.setText(Question.getQuestion());
        holder.questionLink.setText(Question.getQuestionLink());

    }

    @Override
    public int getItemCount() {
        return QuestionArrayList.size();
    }
    // View Holder Class
    public class QuestionViewHolder extends RecyclerView.ViewHolder{
        public TextView question;
        public TextView questionLink;
        public QuestionViewHolder(View view) {
            super(view);
            this.question = (TextView) view.findViewById(R.id.question);
            this.questionLink = (TextView) view.findViewById(R.id.questionLink);
        }
    }
}


