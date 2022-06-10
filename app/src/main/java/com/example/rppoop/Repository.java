package com.example.rppoop;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.rppoop.models.QuestionModel;
import com.example.rppoop.models.ResultsModel;
import com.example.rppoop.service.QuestionDataService;
import com.example.rppoop.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    private ArrayList<QuestionModel> questionsArray = new ArrayList<>();
    private MutableLiveData<List<QuestionModel>> QuestionModelMutableLiveData = new MutableLiveData<>();
    private Application application;

    public Repository(Application application){
        this.application = application;
    }

    public MutableLiveData<List<QuestionModel>> getQuestionModelMutableLiveData(String companyName){
        QuestionDataService QuestionDataService = RetrofitInstance.getService();

        Call<ResultsModel> call =
                QuestionDataService.getQuestions(companyName);
        call.enqueue(new Callback<ResultsModel>() {
            @Override
            public void onResponse(Call<ResultsModel> call, Response<ResultsModel> response) {
                ResultsModel resultsModel = response.body();
                if(resultsModel != null && resultsModel.getQuestions() != null){
                    questionsArray = (ArrayList<QuestionModel>) resultsModel.getQuestions();
                    QuestionModelMutableLiveData.setValue(questionsArray);
                    Toast.makeText(application.getApplicationContext(), "response was successful", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResultsModel> call, Throwable t) {
                Toast.makeText(application.getApplicationContext(), "response failed", Toast.LENGTH_SHORT).show();
            }
        });
        return QuestionModelMutableLiveData;
    }

    public void uploadQuestion(String question, String questionLink, String companyName){
        QuestionDataService QuestionDataService = RetrofitInstance.getService();
        QuestionModel toUpload = new QuestionModel(question, questionLink, companyName);
        Call<QuestionModel> call =
                QuestionDataService.uploadQuestion(toUpload);
        call.enqueue(new Callback<QuestionModel>() {
            @Override
            public void onResponse(Call<QuestionModel> call, Response<QuestionModel> response) {
                QuestionModel uploadedObj = response.body();
                String a = Integer.toString(response.code());
//                String a = uploadedObj.getQuestion();
                Toast.makeText(application.getApplicationContext(), "Question Uploaded Successfully" , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<QuestionModel> call, Throwable t) {
                Toast.makeText(application.getApplicationContext(), "upload failed", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
