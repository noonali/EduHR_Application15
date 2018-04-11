package com.example.hanan.eduhr_application;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
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
import java.util.Calendar;

public class EnterPersonalInfo extends AppCompatActivity {
    EditText ET_NAME, ET_PHONE,  ET_CODE;
    String teacher_name,teacher_phone, teacher_date, teacher_code, teacher_id;
    private static final String TAG = "EnterPersonalInfo";
     TextView ET_DATE;
    private DatePickerDialog.OnDateSetListener mDateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_personal_info);

        ET_NAME = findViewById(R.id.teacher_name);
        ET_PHONE =  findViewById(R.id.teacher_Phone);
        ET_DATE =  findViewById(R.id.teacher_dof);
        ET_CODE =  findViewById(R.id.teacher_code);

        ET_DATE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        EnterPersonalInfo.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                ET_DATE.setText(date);
            }
        };
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

        String method = "save_info";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, teacher_id, teacher_name, teacher_phone, teacher_date, teacher_code);
        Intent intent2 = new Intent(this, NewTeacherMainPage.class);
        intent2.putExtra("teacher_id",teacher_id);

        startActivity(intent2);

    }



}
