package com.example.hanan.eduhr_application;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.UploadNotificationConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UpdatePersonal_Info extends AppCompatActivity {

    EditText ET_PHONE, ET_EMAIL;
    String teacher_phone, teacher_email,  teacher_id;
    String sName, sDob;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_personal__info);

        ET_PHONE = findViewById(R.id.update_phone);
        ET_EMAIL = findViewById(R.id.update_email);

        listView = (ListView) findViewById(R.id.listView);
        getJSON("https://appwebhost2018.000webhostapp.com/update2.php");

        Intent intent = getIntent();
        teacher_id = intent.getStringExtra("teacher_id");
    }

    private void getJSON(final String urlWebService) {

        class GetJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                try {
                    loadIntoListView(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
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





                    StringBuilder sb = new StringBuilder();
                    //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();



                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }

    private void loadIntoListView(String json) throws JSONException {
        List  kk=new ArrayList();
        int i = 0;
        JSONArray jsonArray1 = new JSONArray(json);
        String[] heroes = new String[jsonArray1.length()];

        while (i  < jsonArray1.length()) {
            JSONObject obj = jsonArray1.getJSONObject(i);
            sName = obj.getString("teacher_name");
            kk.add("Name: "+sName);
            sDob=obj.getString("dateOfBirth");
            kk.add("dateOfBirth: "+sDob);
            i++;





        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, kk);
        listView.setAdapter(arrayAdapter);
    }

    public void on_update(View view) {
        teacher_phone = ET_PHONE.getText().toString();
        teacher_email = ET_EMAIL.getText().toString();


        Intent intent = getIntent();
        teacher_id = intent.getStringExtra("teacher_id");


        String method = "update_info";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, teacher_id, teacher_phone, teacher_email);
        Intent intent2 = new Intent(this, CurrentTeacherMainPage.class);
        intent2.putExtra("teacher_id",teacher_id);
        startActivity(intent2);

    }


}
