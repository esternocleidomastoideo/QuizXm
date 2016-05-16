package br.com.mdi.br.quizxm;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import static br.com.mdi.br.quizxm.R.style.QuizXm;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private GestureDetector detector;
    private int statuspoint=0;

    public  void setStatistics(int valor){
        this.statuspoint+= valor;
    }

    public String getStatistics(){

        return "Points: "+this.statuspoint;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.detector = new GestureDetector(this);

        final Switch switch1 = (Switch)findViewById(R.id.switch1);
        final Switch switch2 = (Switch)findViewById(R.id.switch2);
        final Switch switch3 = (Switch)findViewById(R.id.switch3);
        final Switch switch4 = (Switch)findViewById(R.id.switch4);
        final TextView textview = (TextView)findViewById(R.id.txtPontos);
        textview.setText("Points: " + this.statuspoint);


        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if (switch1.isChecked()){
                   setStatistics(1);
                   switch1.setText("OK!");
                   textview.setText(getStatistics());

                }else{
                   setStatistics(-1);
                   switch1.setText(R.string.question1_r1);
                   textview.setText(getStatistics());
               }

            }
        });

        switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switch2.isChecked()) {
                    setStatistics(1);
                    switch2.setText("OK!");
                    textview.setText(getStatistics());
                }else{
                    setStatistics(-1);
                    switch2.setText(R.string.question1_r2);
                    textview.setText(getStatistics());
                }
            }
        });


        switch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switch3.isChecked()){
                    setStatistics(-1);
                    switch3.setText("WRONG!!");
                    textview.setText(getStatistics());
                }else{
                    setStatistics(1);
                    switch3.setText(R.string.question1_r3);
                    textview.setText(getStatistics());
                }

            }
        });

        switch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switch4.isChecked()){
                    setStatistics(-1);
                   switch4.setText("WRONG!");
                   textview.setText(getStatistics());

                }else{
                    setStatistics(1);
                    switch4.setText(R.string.question1_r4);
                    textview.setText(getStatistics());
                }

            }
        });
    }


    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {}

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if(this.detector.onTouchEvent(event)){
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        if(Math.abs(e1.getY()-e2.getY())>250){

            return false;
        }


        if(e1.getX()-e2.getX()>100 && Math.abs(velocityX)>200){

            Intent intent = new Intent(this,Screen2.class);
            intent.putExtra("statuspoint",statuspoint);
            startActivity(intent);
        }
        return false;
    }
}
