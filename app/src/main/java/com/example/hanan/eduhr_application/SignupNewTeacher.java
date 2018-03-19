package com.example.hanan.eduhr_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class SignupNewTeacher extends AppCompatActivity {

    EditText ET_ID, ET_Email;
    String sign_up_id,sign_up_Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_new_teacher);

        ET_ID = findViewById(R.id.new_id);
        ET_Email =  findViewById(R.id.new_email);
    }
    public void onSend(View view) {
            sign_up_id = ET_ID.getText().toString();
            sign_up_Email = ET_Email.getText().toString();
            String method = "signUp";
            BackgroundTask backgroundTask = new BackgroundTask(this);
            if(sign_up_id != null & sign_up_id.length() == 10 & sign_up_Email != null) {
                backgroundTask.execute(method, sign_up_id, sign_up_Email);
                startActivity(new Intent(this, LoginAdmin.class));
            }
            else{
                Toast.makeText(this, "Incorrect Entries ", Toast.LENGTH_SHORT).show();
            }
    }
}
