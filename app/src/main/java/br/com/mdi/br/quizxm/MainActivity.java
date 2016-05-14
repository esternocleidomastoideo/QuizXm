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
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import static br.com.mdi.br.quizxm.R.style.QuizXm;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botaoNext1 = (Button)findViewById(R.id.ButtonNext1);
        botaoNext1.setOnClickListener(this);

        final Switch switch1 = (Switch)findViewById(R.id.switch1);
        final Switch switch2 = (Switch)findViewById(R.id.switch2);
        final Switch switch3 = (Switch)findViewById(R.id.switch3);
        final Switch switch4 = (Switch)findViewById(R.id.switch4);

        /*
        botaoNext1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(this,Screen2.class);
                startActivity(intent);
                //setContentView(R.layout.activity_screen2);
            }
        });
        */



        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if (switch1.isChecked()){
                   switch1.setText("OK!");
                }
               else{
                   switch1.setText(R.string.question1_r1);
               }

            }
        });

        switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switch2.isChecked()) {
                    switch2.setText("OK!");
                } else {
                    switch2.setText(R.string.question1_r2);
                }

            }
        });


        switch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switch3.isChecked()){
                    switch3.setText("WRONG!!");
                }
                else{
                    switch3.setText(R.string.question1_r3);
                }

            }
        });

        switch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switch4.isChecked()){
                    switch4.setText("WRONG!");
                }
                else{
                    switch4.setText(R.string.question1_r4);
                }

            }
        });
    }


    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this,Screen2.class);
        startActivity(intent);

    }
}
