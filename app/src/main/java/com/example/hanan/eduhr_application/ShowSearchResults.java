package com.example.hanan.eduhr_application;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

public class ShowSearchResults extends AppCompatActivity {
    ListView listView;
    String sName,  sEmail, sDob, sPhone, sCode ,answer_one ,answer_two,answer_three;
    String teacher_id ,opp,agg,con,ext,Nuw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_search_results);
        listView = (ListView) findViewById(R.id.listView);
        getJSON("https://appwebhost2018.000webhostapp.com/show.php");

        Intent intent = getIntent();
        teacher_id = intent.getStringExtra("teacher_id");

    }

    public void viewcv(View view) {
        Intent intent = getIntent();
        teacher_id = intent.getStringExtra("teacher_id");

        Intent intent2 = new Intent(this, ViewCV.class);
        intent2.putExtra("teacher_id",teacher_id);


        startActivity(intent2);

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
        JSONArray jsonArray = new JSONArray(json);
        String[] heroes = new String[jsonArray.length()];

        while (i  < jsonArray.length()) {
            JSONObject obj = jsonArray.getJSONObject(i);
            sName = obj.getString("teacher_name");
            kk.add("Name: "+sName);
            sCode=obj.getString("code");
            kk.add("code: "+sCode);
            sDob=obj.getString("dateOfBirth");
            kk.add("dateOfBirth: "+sDob);
            sPhone=obj.getString("phone");
            kk.add("phone: "+sPhone);
            sEmail=obj.getString("email");
            kk.add("email: "+sEmail);
            kk.add("Personality analysis results:  \n");
            answer_one=obj.getString("answer_one");
            kk.add("1. In 100 words or less, give an example of a situation where you overcame obstacles and worked under pressure?\n "+answer_one);
            answer_two=obj.getString("answer_two");
            kk.add("2. In 100 words or less, give an example of how you made a positive contribution to a team, and its outcome? \n "+answer_two);
            answer_three=obj.getString("answer_three");
            kk.add("3. In 50 words or less, name one of your greatest strengths and weakness?\n "+answer_three);
            //kk.add("Personality analysis results:  \n");
            //kk.add("Personality Traits: \n");
            //agg = obj.getString("teacher_name");
            //kk.add("Name: "+agg);
            //con=obj.getString("code");
            //kk.add("code: "+con);
            //ext=obj.getString("dateOfBirth");
            //kk.add("dateOfBirth: "+ext);
            //Nuw=obj.getString("phone");
            //kk.add("phone: "+Nuw);
            //opp=obj.getString("email");
            //kk.add("phone: "+opp);
            //kk.add("Possible jobs for given traits: \n");
            i++;





        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, kk);
        listView.setAdapter(arrayAdapter);
    }


}
