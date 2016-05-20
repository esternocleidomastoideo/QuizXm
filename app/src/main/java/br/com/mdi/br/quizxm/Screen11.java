package br.com.mdi.br.quizxm;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Iterator;
import java.util.List;

public class Screen11 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen11);

        MyDbHelper mydb = new MyDbHelper(this);

        //Screen will be created for add questions
        Question question = new Question();
        question.setQuestion("Identify three properties required by the domain Configuration Wizard when creating a new domain");
        question.setAlternative1("machine name");
        question.setAlternativeOpt1(0);
        question.setAlternative2("Managed Server name");
        question.setAlternativeOpt2(0);
        question.setAlternative3("domain startup mode");
        question.setAlternativeOpt3(1);
        question.setAlternative4("domain name");
        question.setAlternativeOpt4(1);
        question.setAlternative5("administrator username and password");
        question.setAlternativeOpt5(1);


        mydb.addQuestion(question);
        List<Question> listall =  mydb.listAll();

        for(Iterator iterator = listall.iterator();iterator.hasNext();){
            Question questionI = (Question)iterator.next();
            Log.i("ITERATOR: ",questionI.toString());

        }

    }

}
