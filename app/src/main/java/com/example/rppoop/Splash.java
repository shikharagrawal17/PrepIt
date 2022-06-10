package com.example.rppoop;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },4000);
    }
}

//public class Splash extends AppCompatActivity {
//    final int SPLASH_TIME_OUT = 3000;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_splash);
//        new Handler().postDelayed(new Runnable() {
//
//            /*
//             * Showing splash screen with a timer. This will be useful when you
//             * want to show case your app logo / company
//             */
//
//            @Override
//            public void run() {
//                // This method will be executed once the timer is over
//                // Start your app main activity
//                Intent i = new Intent(Splash.this, LoginActivity.class);
//                startActivity(i);
//                overridePendingTransition(0, 0);
//                // close this activity
//                finish();
//            }
//        }, SPLASH_TIME_OUT);
//    }
//}

//public class Splash extends Activity {
//    //This is the time it will take for the splash screen to be displayed
//    private static int SPLASH_TIME_OUT = 3000;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_splash);
//
//        //This is where we change our app name font to blacklist font
//        Typeface typeface = ResourcesCompat.getFont(this, R.font.blacklist);
//
//        TextView appname= findViewById(R.id.appname);
//        appname.setTypeface(typeface);
//
//        // We use the Yoyo to make our app logo to bounce app and down.
//        //There is a lot of Attension Techniques styles
//        // example Flash, Pulse, RubberBand, Shake, Swing, Wobble, Bounce, Tada, StandUp, Wave.
//        // Your can change the techniques to fit your liking.
//        YoYo.with(Techniques.Bounce)
//                .duration(7000)
//                .playOn(findViewById(R.id.logo));
//
//        //This is where we make our app name fade in as it moves up
//        // There are other Fade Techniques too
//        //example FadeIn, FadeInUp, FadeInDown, FadeInLeft, FadeInRight
//        //FadeOut, FadeOutDown, FadeOutLeft, FadeOutRight, FadeOutUp
//        YoYo.with(Techniques.FadeInUp)
//                .duration(5000)
//                .playOn(findViewById(R.id.appname));
//
//        new Handler().postDelayed(new Runnable() {
//
//            /*
//             * Showing splash screen with a timer. This will be useful when you
//             * want to show case your app logo / company
//             */
//
//            @Override
//            public void run() {
//                // This method will be executed once the timer is over
//                // Start your app main activity
//                startActivity(new Intent(Splash.this,LoginActivity.class));
//                finish();
//            }
//        }, SPLASH_TIME_OUT);
//    }
//}