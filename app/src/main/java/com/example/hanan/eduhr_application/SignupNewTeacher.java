package com.example.hanan.eduhr_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class SignupNewTeacher extends AppCompatActivity implements View.OnClickListener {

    EditText ET_ID;
    String sign_up_id,sign_up_Email;
    //Declaring EditText
    private EditText editTextEmail;


    //Send button
    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_new_teacher);

        ET_ID = findViewById(R.id.new_id);
        editTextEmail =  findViewById(R.id.new_email);
        buttonSend = (Button) findViewById(R.id.sign_new);
        buttonSend.setOnClickListener(this);


    }
    public void onSend() {
            sign_up_id = ET_ID.getText().toString();
            sign_up_Email = editTextEmail.getText().toString();

            String method = "signUp";
            BackgroundTask backgroundTask = new BackgroundTask(this);


            //Getting content for email
            int t = randomnumber();

            String email = editTextEmail.getText().toString();
            String subject = "EduHR";
            String message = "code Verification \n" + t;

            //Creating SendMail object
            SendMail sm = new SendMail(this, email, subject, message);
            //Executing sendmail to send email
            sm.execute();

            backgroundTask.execute(method, sign_up_id, sign_up_Email);

            Intent intent = new Intent(this, EnterPersonalInfo.class);
            intent.putExtra("teacher_id", sign_up_id);
            startActivity(intent);



        }



    public static int randomnumber(){

        int  n=0;
        Random rand = new Random();
        n = rand.nextInt(10000)  ;
        return n ;
    }

    @Override
    public void onClick(View view) {
        onSend();

    }
}
