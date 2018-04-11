package com.example.hanan.eduhr_application;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SearchTeacherByID extends AppCompatActivity {
    EditText Teacher;
    String teacher_id1,teacher_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_teacher_by_id);
        Teacher= findViewById(R.id.teacher_id);

    }
    public void search(View view)
    {
        teacher_id = Teacher.getText().toString();
        Intent intent = getIntent();

        String method = "search";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, teacher_id );


        Intent intent1 = new Intent(this, ShowSearchResults.class);
        intent1.putExtra("teacher_id",  teacher_id);
        startActivity(intent1);
    }
}
