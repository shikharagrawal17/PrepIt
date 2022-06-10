package com.example.rppoop.models;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("questions_model")
public class QuestionModel implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("questionLink")
    @Expose
    private String questionLink;

    public QuestionModel(){};
    public QuestionModel(String question, String questionLink, String company){
        this.questionLink = questionLink;
        this.question = question;
        this.company = company;
    }
    public QuestionModel(Parcel in) {
        this.id =(Integer) in.readValue(Integer.class.getClassLoader());
        this.company = (String) in.readValue(String.class.getClassLoader());
        this.question = (String) in.readValue(String.class.getClassLoader());
        this.questionLink = (String) in.readValue(String.class.getClassLoader());
    }

    public static final Creator<QuestionModel> CREATOR = new Creator<QuestionModel>() {
        @Override
        public QuestionModel createFromParcel(Parcel in) {
            return new QuestionModel(in);
        }

        @Override
        public QuestionModel[] newArray(int size) {
            return new QuestionModel[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestionLink() {
        return questionLink;
    }

    public void setQuestionLink(String questionLink) {
        this.questionLink = questionLink;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(id);
        parcel.writeValue(company);
        parcel.writeValue(questionLink);
        parcel.writeValue(question);
    }
}
