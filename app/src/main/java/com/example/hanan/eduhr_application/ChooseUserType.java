package com.example.hanan.eduhr_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChooseUserType extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_user_type);
    }
    public void on_admin(View view)
    {
        startActivity(new Intent(this,LoginAdmin.class));
    }
    public void on_new(View view)
    {
        startActivity(new Intent(this,SignupNewTeacher.class));
    }
    public void on_curr(View view)
    {
        startActivity(new Intent(this,SigninCurrentTeacher.class));
    }
}
