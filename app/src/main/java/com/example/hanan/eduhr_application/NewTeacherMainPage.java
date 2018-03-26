package com.example.hanan.eduhr_application;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

public class NewTeacherMainPage extends AppCompatActivity {

    String teacher_id ;
    String json_string;
    TextView name, id, email, dob, phone, code;
    String sName, sID, sEmail, sDob, sPhone, sCode;
    JSONObject jsonObject;
    JSONArray jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_teacher_main_page);

        BackgroundNewTeacher background = new BackgroundNewTeacher();
        background.execute();

        name = findViewById(R.id.display_newName);
        id = findViewById(R.id.display_newId);
        email = findViewById(R.id.display_newEmail);
        //dob = findViewById(R.id.display_newDate);
        phone = findViewById(R.id.display_newPhone);
        code = findViewById(R.id.display_newCode);

        Intent intent = getIntent();
        teacher_id = intent.getStringExtra("teacher_id");


        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("mysql_response");
            int count = 0 ;

            while (count < jsonObject.length()){
                JSONObject jo = jsonArray.getJSONObject(count);
                sName = jo.getString("teacher_name").trim();
                sID = jo.getString("teacher_id").trim();
                sEmail = jo.getString("email").trim();
                //sDob = jo.getString("dateOfBirth").trim();
                sPhone = jo.getString("phone").trim();
                sCode = jo.getString("code").trim();
            }
            name.setText(sName);
            id.setText(sID);
            email.setText(sEmail);
            //dob.setText(sDob);
            phone.setText(sPhone);
            code.setText(sCode);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public void onApplyNew(View view) {

        Intent intent2 = new Intent(this, PersonalityQuestions.class);
        intent2.putExtra("teacher_id",teacher_id);

        startActivity(intent2);

    }
    public void onUploadBtn(View view) {

        Toast.makeText(this, "Clicked .... ", Toast.LENGTH_SHORT).show();

    }



    class BackgroundNewTeacher extends AsyncTask<Void,Void,String> {
        String displayNewTeacher_url;
        Context ctx;


        @Override
        protected void onPreExecute() {
            displayNewTeacher_url = "http://10.0.2.2/eduHR/displayNewTeacher.php";
        }
        @Override
        protected String doInBackground(Void... params) {

             {
                try {
                    URL url = new URL(displayNewTeacher_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    OutputStream OS = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                    String data = URLEncoder.encode("teacher_id", "UTF-8") + "=" + URLEncoder.encode(teacher_id, "UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();

                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((json_string = bufferedReader.readLine()) != null) {
                        stringBuilder.append(json_string+"\n");
                    }

                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();

                    return stringBuilder.toString().trim();

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
        @Override
        protected void onPostExecute(String result) {
            json_string = result;
        }

    }
}

