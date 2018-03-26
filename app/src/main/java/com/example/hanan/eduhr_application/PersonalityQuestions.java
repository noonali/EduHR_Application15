package com.example.hanan.eduhr_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PersonalityQuestions extends AppCompatActivity {

    EditText ET_QONE, ET_QTWO, ET_QTHREE;
    String q_one,q_two, q_three, teacher_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personality_questions);

        ET_QONE = findViewById(R.id.answerOne);
        ET_QTWO =  findViewById(R.id.answerTwo);
        ET_QTHREE =  findViewById(R.id.answerThree);

    }
    public void onSave_answers(View view) {
        q_one = ET_QONE.getText().toString();
        q_two = ET_QTWO.getText().toString();
        q_three = ET_QTHREE.getText().toString();

        Intent intent = getIntent();
        teacher_id = intent.getStringExtra("teacher_id");

        String method = "save_answers";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, teacher_id, q_one, q_two, q_three);

        startActivity(new Intent(this, NewTeacherMainPage.class));

    }
}
