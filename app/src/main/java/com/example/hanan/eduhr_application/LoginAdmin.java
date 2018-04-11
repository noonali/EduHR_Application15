package com.example.hanan.eduhr_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginAdmin extends AppCompatActivity {

    EditText ET_ID, ET_pass;
    String login_id,login_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        ET_ID = findViewById(R.id.login_text);
        ET_pass =  findViewById(R.id.login_password);
    }

    public void onLogin(View view) {
        login_id = ET_ID.getText().toString();
        login_pass = ET_pass.getText().toString();
        String method = "login";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        if(login_id != null & login_id.length()<= 10  & login_pass != null & login_pass.length()<= 10) {

            backgroundTask.execute(method, login_id, login_pass);
            startActivity(new Intent(this, SearchTeacherByID.class));
        }else{
            Toast.makeText(this, "Incorrect Entries ", Toast.LENGTH_SHORT).show();

        }


    }
}
