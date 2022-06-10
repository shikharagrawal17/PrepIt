package com.example.rppoop;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.rppoop.viewmodel.ApiActivityViewModel;

import java.util.ArrayList;

public class QuestionUploadActivity extends AppCompatActivity {
    EditText question;
    EditText questionLink;
    String companyName;
    Button submit;
    ApiActivityViewModel viewModel;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_upload);

        question = (EditText)findViewById(R.id.question);
        questionLink = (EditText)findViewById(R.id.questionLink);
//        companyName = (EditText)findViewById(R.id.companyName);
        submit = findViewById(R.id.button);
        Spinner spinner = findViewById(R.id.companyName);
//        spinner.setPrompt("Select Company");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Google");
        arrayList.add("Apple");
        arrayList.add("Abobe");
        arrayList.add("Arcesium");
        arrayList.add("DE Shaw");
        arrayList.add("Credit Suisse");
        arrayList.add("TCS");
        arrayList.add("Tech Mahindra");
        arrayList.add("Microsoft");
        arrayList.add("UBS");
        arrayList.add("Amazon");
        arrayList.add("BYJUS'S");
        arrayList.add("Nvidia");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,                         android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                companyName = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        viewModel =new  ViewModelProvider(this).get(ApiActivityViewModel.class);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.uploadQuestion( companyName, question.getText().toString(), questionLink.getText().toString());
                finish();
            }
        });
    }
}