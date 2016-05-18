package br.com.mdi.br.quizxm;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity implements  Runnable{

    ImageView logo;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Handler splashHandler = new Handler();
        splashHandler.postDelayed(this,5000);


        logo    =   (ImageView) findViewById(R.id.mylogo);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in_animation);

        logo.setAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

                logo.startAnimation(animation);

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });



    }

    @Override
    public void run() {

        Intent it = new Intent(Splash.this,MainActivity.class);
        startActivity(it);
        finish();

    }
}
