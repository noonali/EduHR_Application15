package com.example.hanan.eduhr_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UpdatePersonal_Info extends AppCompatActivity {

    EditText ET_PHONE, ET_EMAIL, ET_CODE;
    String teacher_phone, teacher_email, teacher_code, teacher_id ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_personal__info);

        ET_PHONE =  findViewById(R.id.update_phone);
        ET_EMAIL =  findViewById(R.id.update_email);
        ET_CODE =  findViewById(R.id.update_code);
    }
    public void on_update(View view) {
        teacher_phone = ET_PHONE.getText().toString();
        teacher_email = ET_EMAIL.getText().toString();
        teacher_code = ET_CODE.getText().toString();

        Intent intent = getIntent();
        teacher_id = intent.getStringExtra("teacher_id");

        Intent intent2 = new Intent(this, CurrentTeacherMainPage.class);
        intent2.putExtra("teacher_id",teacher_id);

        String method = "update_info";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, teacher_id, teacher_phone, teacher_email, teacher_code);

        startActivity(intent2);

    }
}
