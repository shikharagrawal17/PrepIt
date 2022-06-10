package com.example.rppoop.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("results_model")
public class ResultsModel implements Parcelable {

    @SerializedName("questions")
    @Expose
    private List<QuestionModel> questions = null;

    public ResultsModel(Parcel in) {
        in.readList(this.questions, com.example.rppoop.models.QuestionModel.class.getClassLoader());
    }

    public static final Creator<ResultsModel> CREATOR = new Creator<ResultsModel>() {
        @Override
        public ResultsModel createFromParcel(Parcel in) {
            return new ResultsModel(in);
        }

        @Override
        public ResultsModel[] newArray(int size) {
            return new ResultsModel[size];
        }
    };

    public List<QuestionModel> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionModel> questions) {
        this.questions = questions;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(questions);
    }
}
