package br.com.mdi.br.quizxm;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class Screen2 extends AppCompatActivity implements GestureDetector.OnGestureListener{

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
        setContentView(R.layout.activity_screen2);
        Bundle bundle = getIntent().getExtras();

        if(bundle.containsKey("statuspoint")) {
            this.statuspoint=bundle.getInt("statuspoint");

        }

        this.detector = new GestureDetector(this);
        final Switch switch1 = (Switch)findViewById(R.id.switch1);
        final Switch switch2 = (Switch)findViewById(R.id.switch2);
        final Switch switch3 = (Switch)findViewById(R.id.switch3);
        final Switch switch4 = (Switch)findViewById(R.id.switch4);
        final TextView textview = (TextView)findViewById(R.id.txtPontos2);
        textview.setText("Points:" + this.statuspoint);



        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switch1.isChecked()) {
                    switch1.setText("WRONG!");
                    statuspoint -= 1;
                    textview.setText(getStatistics());
                } else {
                    switch1.setText(R.string.question2_r1);
                    statuspoint += 1;
                    textview.setText(getStatistics());
                }

            }
        });

        switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switch2.isChecked()) {
                    switch2.setText("OK!");
                    setStatistics(1);
                    textview.setText(getStatistics());

                } else {
                    setStatistics(-1);
                    textview.setText(getStatistics());
                    switch2.setText(R.string.question2_r2);
                }

            }
        });

//
        switch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switch3.isChecked()) {
                    switch3.setText("WRONG!!");
                    setStatistics(-1);
                    textview.setText(getStatistics());
                } else {
                    setStatistics(-1);
                    textview.setText(getStatistics());
                    switch3.setText(R.string.question2_r3);
                }

            }
        });

        switch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switch4.isChecked()){
                    switch4.setText("WRONG!");
                    setStatistics(-1);
                    textview.setText(getStatistics());
                }
                else{
                    setStatistics(1);
                    textview.setText(getStatistics());
                    switch4.setText(R.string.question2_r4);
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
    public void onLongPress(MotionEvent e) {

    }

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

            Intent intent = new Intent(this,Screen3.class);
            intent.putExtra("statuspoint",statuspoint);
            startActivity(intent);
        }
        return false;
    }
}
