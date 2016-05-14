package br.com.mdi.br.quizxm;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class Screen4 extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen4);
        Bundle bundle = getIntent().getExtras();

        Button botaoNext4 = (Button)findViewById(R.id.ButtonNext4);
        botaoNext4.setOnClickListener(this);

        final Switch switch1 = (Switch)findViewById(R.id.switch1);
        final Switch switch2 = (Switch)findViewById(R.id.switch2);
        final Switch switch3 = (Switch)findViewById(R.id.switch3);
        final Switch switch4 = (Switch)findViewById(R.id.switch4);




        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switch1.isChecked()){
                    switch1.setText("WRONG!");
                }
                else{
                    switch1.setText(R.string.question4_r1);
                }

            }
        });

        switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switch2.isChecked()) {
                    switch2.setText("OK!");
                } else {
                    switch2.setText(R.string.question4_r2);
                }

            }
        });

//
        switch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switch3.isChecked()) {
                    switch3.setText("WRONG!!");
                } else {
                    switch3.setText(R.string.question4_r3);
                }

            }
        });

        switch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switch4.isChecked()){
                    switch4.setText("OK!");
                }
                else{
                    switch4.setText(R.string.question4_r4);
                }

            }
        });




    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,Screen4.class);
        startActivity(intent);
    }



}
