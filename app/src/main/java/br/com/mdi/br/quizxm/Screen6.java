package br.com.mdi.br.quizxm;
import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GestureOverlayView;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class Screen6 extends AppCompatActivity implements View.OnClickListener, GestureDetector.OnGestureListener{

    private GestureDetector detector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen6);
        Bundle bundle = getIntent().getExtras();
        Button botaoNext6 = (Button)findViewById(R.id.ButtonNext6);
        botaoNext6.setOnClickListener(this);
        this.detector = new GestureDetector(this);

        final Switch switch1 = (Switch)findViewById(R.id.switch1);
        final Switch switch2 = (Switch)findViewById(R.id.switch2);
        final Switch switch3 = (Switch)findViewById(R.id.switch3);
        final Switch switch4 = (Switch)findViewById(R.id.switch4);
        final GestureDetector gestureDetector = null;

        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switch1.isChecked()){
                    switch1.setText("WRONG!");
                }
                else{
                    switch1.setText(R.string.question6_r1);
                }

            }
        });

        switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switch2.isChecked()) {
                    switch2.setText("WRONG!");
                } else {
                    switch2.setText(R.string.question6_r2);
                }

            }
        });

//
        switch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switch3.isChecked()) {
                    switch3.setText("OK!");
                } else {
                    switch3.setText(R.string.question6_r3);
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
                    switch4.setText(R.string.question6_r4);
                }

            }
        });

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,Screen4.class);
        startActivity(intent);
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
            Log.i("TESTANDO","########## TESTANDO ###########");
        }else if(e1.getX() -e2.getX()>100&&Math.abs(velocityX)>200){
            Log.i("SWIP ATIVADO","WooooooHooooo!!!!");
        }


        return false;
    }
}
