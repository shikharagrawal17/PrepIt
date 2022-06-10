package com.example.rppoop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

public class descFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    String Name, AverageSalary, Logo, Placements, Rounds;
    private String mParam1;
    private String mParam2;

    public descFragment(String Name, String AverageSalary, String Logo, String Placements, String Rounds) {
        this.Name = Name;
        this.AverageSalary = AverageSalary;
        this.Logo = Logo;
        this.Placements = Placements;
        this.Rounds = Rounds;

    }

    public descFragment() {

    }


    public static descFragment newInstance(String param1, String param2) {
        descFragment fragment = new descFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_desc, container, false);

        ImageView imageholder = view.findViewById(R.id.imageholder);
        TextView nameholder = view.findViewById(R.id.nameholder);
        TextView placements = view.findViewById(R.id.placements);
        TextView rounds = view.findViewById(R.id.rounds);
        TextView AQues = view.findViewById(R.id.AQues);
        String companyName = Name.toString();
        Activity activity = (Activity)container.getContext();

        AQues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getBaseContext(), ApiActivity.class);
                i.putExtra("companyName", companyName);
                startActivity(i);
            }
        });

        nameholder.setText(Name);
        placements.setText(Placements);
        rounds.setText(Rounds);
        Glide.with(getContext()).load(Logo).into(imageholder);
//        AQues.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String companyName = nameholder.getText().toString();
//                Intent intent = new Intent(activity, ApiActivity.class);
//                intent.putExtra("companyName", companyName);
//                startActivity(intent);
////                startActivity(new Intent(fragment.getActivity(), ApiActivity.class));
//            }
//        });
        return view;
    }

//    public void Api(View view, Context context){
//        TextView nameholder = view.findViewById(R.id.nameholder);
//        TextView AQues = view.findViewById(R.id.AQues);
//        String companyName = nameholder.getText().toString();
//        Activity activity = (Activity)context;
//        Intent intent = new Intent(activity, ApiActivity.class);
//        intent.putExtra("companyName", companyName);
//        startActivity(intent);
//    }


    public void onBackPressed(){
        AppCompatActivity activity = (AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper, new MainFragment()).addToBackStack(null).commit();

    }
}