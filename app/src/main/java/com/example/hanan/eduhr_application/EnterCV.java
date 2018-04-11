package com.example.hanan.eduhr_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EnterCV extends AppCompatActivity {
    EditText ET_ONE, ET_TWO, ET_THREE ;
    String answer1,answer2, answer3,teacher_id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_cv);

        ET_ONE = findViewById(R.id.answer1);
        ET_TWO =  findViewById(R.id.answer2);
        ET_THREE =  findViewById(R.id.answer3);





    }
    public void on_save(View view) {
        answer1 = ET_ONE.getText().toString();
        answer2 = ET_TWO.getText().toString();
        answer3 = ET_THREE.getText().toString();

        Intent intent = getIntent();
        teacher_id = intent.getStringExtra("teacher_id");

        String method = "save_answer1";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, teacher_id, answer1,answer2, answer3 );
        Intent intent2 = new Intent(this, NewTeacherMainPage.class);
        intent2.putExtra("teacher_id",teacher_id);
        startActivity(intent2);

    }

}
