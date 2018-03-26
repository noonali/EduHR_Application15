package com.example.hanan.eduhr_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SigninCurrentTeacher extends AppCompatActivity {

    EditText ET_ID, ET_code;
    String teacher_id,teacher_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_current_teacher);

        ET_ID = findViewById(R.id.current_id);
        ET_code =  findViewById(R.id.current_code);
    }
    public void onSignin(View view) {
        teacher_id = ET_ID.getText().toString();
        teacher_code = ET_code.getText().toString();

        String method = "SignIn";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, teacher_id, teacher_code);

        Intent intent = new Intent(this, CurrentTeacherMainPage.class);
        intent.putExtra("teacher_id",teacher_id);
        startActivity(intent);
    }
}
