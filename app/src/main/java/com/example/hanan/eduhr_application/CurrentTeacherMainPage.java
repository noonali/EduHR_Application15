package com.example.hanan.eduhr_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CurrentTeacherMainPage extends AppCompatActivity {

    String teacher_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_teacher_main_page);
    }
    public void onUpdate(View view) {

        startActivity(new Intent(this, UpdatePersonal_Info.class));


    }
    public void onApply(View view) {
        Intent intent = getIntent();
        teacher_id = intent.getStringExtra("teacher_id");

        Intent intent2 = new Intent(this, PersonalityQuestions.class);
        intent2.putExtra("teacher_id",teacher_id);

        startActivity(intent2);

    }
}
