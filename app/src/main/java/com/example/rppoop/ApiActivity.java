package com.example.rppoop;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.daimajia.androidanimations.library.sliders.SlideInUpAnimator;
import com.example.rppoop.adapters.QuestionAdapter;
import com.example.rppoop.model1.User;
import com.example.rppoop.models.QuestionModel;
import com.example.rppoop.viewmodel.ApiActivityViewModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import jp.wasabeef.recyclerview.animators.FadeInAnimator;
import jp.wasabeef.recyclerview.animators.OvershootInLeftAnimator;

public class ApiActivity extends AppCompatActivity {
    CircleImageView profileImage;
    TextView username;

    FirebaseUser firebaseUser;
    DatabaseReference reference;


//    public ApiActivity(String companyName){
//        this.companyName = companyName;
//    }

    private ArrayList<QuestionModel> questionList;
    private RecyclerView recyclerView;
    private QuestionAdapter questionAdapter;
    private ApiActivityViewModel apiActivityViewModel;
//    private String companyName = "adobe";
    private String companyName;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_api);
        profileImage = findViewById(R.id.profile_image);
        username = findViewById(R.id.username);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());
//        button = findViewById(R.id.button2);
        Bundle bundle = getIntent().getExtras();
        String companyName = bundle.getString("companyName");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                username.setText(user.getUsername());
                if (user.getProfilePic().equals("ProfilePicURL")){
                    profileImage.setImageResource(R.mipmap.ic_launcher);
                }else{
                    Glide.with(ApiActivity.this).load(user.getProfilePic()).into(profileImage);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(ApiActivity.this, QuestionUploadActivity.class);
//                startActivity(i);
//            }
//        });7
        apiActivityViewModel = new ViewModelProvider(this).get(ApiActivityViewModel.class);
        LoadQuestions(companyName);
    }

    public void LoadQuestions(String companyName){
        apiActivityViewModel.getQuestions(companyName).observe(this, new Observer<List<QuestionModel>>() {
            @Override
            public void onChanged(List<QuestionModel> questionModels) {
                questionList =(ArrayList<QuestionModel>)questionModels;
                showOnRecyclerView();
            }
        });
    }

    public void showOnRecyclerView(){
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setItemAnimator(new FadeInAnimator());
        questionAdapter = new QuestionAdapter(this, questionList);
        recyclerView.setLayoutManager(new LinearLayoutManager(ApiActivity.this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(questionAdapter);
        questionAdapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(ApiActivity.this, LoginActivity.class));
                finish();
                return true;
            case R.id.upload:
                Intent i = new Intent(this, QuestionUploadActivity.class);
                startActivity(i);
                return true;
        }
        return false;
    }
}