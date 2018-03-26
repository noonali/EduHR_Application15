package com.example.hanan.eduhr_application;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EnterPersonalInfo extends AppCompatActivity {
    EditText ET_NAME, ET_PHONE, ET_DATE, ET_CODE;
    String teacher_name,teacher_phone, teacher_date, teacher_code, teacher_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_personal_info);

        ET_NAME = findViewById(R.id.teacher_name);
        ET_PHONE =  findViewById(R.id.teacher_Phone);
        ET_DATE =  findViewById(R.id.teacher_dof);
        ET_CODE =  findViewById(R.id.teacher_code);
    }
    public void on_save_info(View view) throws ParseException {
        teacher_name = ET_NAME.getText().toString();
        teacher_phone = ET_PHONE.getText().toString();
        teacher_date = ET_DATE.getText().toString();
        //Date dobDate = (Date) new SimpleDateFormat("MM-dd-yyyy").parse(teacher_date);
        //teacher_date = new SimpleDateFormat("yyyy-MM-dd").format(dobDate);
        teacher_code = ET_CODE.getText().toString();

        Intent intent = getIntent();
        teacher_id = intent.getStringExtra("teacher_id");

        Intent intent2 = new Intent(this, NewTeacherMainPage.class);
        intent2.putExtra("teacher_id",teacher_id);

        String method = "save_info";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, teacher_id, teacher_name, teacher_phone, teacher_date, teacher_code);

        startActivity(intent2);

    }



}
