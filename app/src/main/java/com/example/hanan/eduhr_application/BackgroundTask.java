package com.example.hanan.eduhr_application;

/**
 * Created by Hanan on 3/19/2018.
 */


import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
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
import java.util.ArrayList;


public class BackgroundTask extends AsyncTask<String,Void,String>{
    AlertDialog alertDialog;
    Context ctx;

    BackgroundTask(Context ctx)
    {
        this.ctx =ctx;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login Information....");
    }
    @Override
    protected String doInBackground(String... params) {
        String signUp_url = "http://10.0.2.2/eduHR/signUp.php";
        String saveTeacherInfo_url = "http://10.0.2.2/eduHR/saveInfo.php";
        String updateTeacherInfo_url = "http://10.0.2.2/eduHR/updateInfo.php";
        String login_url = "http://10.0.2.2/eduHR/login.php";
        String signin_url = "http://10.0.2.2/eduHR/signIn.php";
        String saveAnswers_url = "http://10.0.2.2/eduHR/saveAnswers.php";

        String method = params[0];

        if (method.equals("login")) {
            String admin_id = params[1];
            String admin_pass = params[2];

            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("admin_id", "UTF-8") + "=" + URLEncoder.encode(admin_id, "UTF-8") + "&" +
                        URLEncoder.encode("admin_pass", "UTF-8") + "=" + URLEncoder.encode(admin_pass, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (method.equals("signUp")) {
            String new_id = params[1];
            String new_email = params[2];
            try {
                URL url = new URL(signUp_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("new_id", "UTF-8") + "=" + URLEncoder.encode(new_id, "UTF-8") + "&" +
                        URLEncoder.encode("new_email", "UTF-8") + "=" + URLEncoder.encode(new_email, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (method.equals("SignIn")) {

            if (method.equals("SignIn")) {
                String teacher_id = params[1];
                String teacher_code = params[2];
                try {
                    URL url = new URL(signin_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    OutputStream OS = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                    String data = URLEncoder.encode("teacher_id", "UTF-8") + "=" + URLEncoder.encode(teacher_id, "UTF-8") + "&" +
                            URLEncoder.encode("teacher_code", "UTF-8") + "=" + URLEncoder.encode(teacher_code, "UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();

                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                    String result = "";
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        result += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();

                    return result;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else if (method.equals("save_info")) {
            String teacher_id = params[1];
            String teacher_name = params[2];
            String teacher_phone = params[3];
            String teacher_date = params[4];
            String teacher_code = params[5];

            try {
                URL url = new URL(saveTeacherInfo_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("teacher_id", "UTF-8") + "=" + URLEncoder.encode(teacher_id, "UTF-8") + "&" +
                        URLEncoder.encode("teacher_name", "UTF-8") + "=" + URLEncoder.encode(teacher_name, "UTF-8") + "&" +
                        URLEncoder.encode("teacher_phone", "UTF-8") + "=" + URLEncoder.encode(teacher_phone, "UTF-8")+ "&" +
                        URLEncoder.encode("teacher_date", "UTF-8") + "=" + URLEncoder.encode(teacher_date, "UTF-8")+ "&" +
                        URLEncoder.encode("teacher_code", "UTF-8") + "=" + URLEncoder.encode(teacher_code, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (method.equals("update_info")) {
            String teacher_id = params[1];
            String teacher_phone = params[2];
            String teacher_email = params[3];
            String teacher_code = params[4];

            try {
                URL url = new URL(updateTeacherInfo_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("teacher_id", "UTF-8") + "=" + URLEncoder.encode(teacher_id, "UTF-8") + "&" +
                        URLEncoder.encode("teacher_phone", "UTF-8") + "=" + URLEncoder.encode(teacher_phone, "UTF-8") + "&" +
                        URLEncoder.encode("teacher_email", "UTF-8") + "=" + URLEncoder.encode(teacher_email, "UTF-8")+ "&" +
                        URLEncoder.encode("teacher_code", "UTF-8") + "=" + URLEncoder.encode(teacher_code, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if (method.equals("save_answers")) {
            String teacher_id = params[1];
            String answerOne = params[2];
            String answerTwo = params[3];
            String answerThree = params[4];

            try {
                URL url = new URL(saveAnswers_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("teacher_id", "UTF-8") + "=" + URLEncoder.encode(teacher_id, "UTF-8") + "&" +
                        URLEncoder.encode("answer_one", "UTF-8") + "=" + URLEncoder.encode(answerOne, "UTF-8") + "&" +
                        URLEncoder.encode("answer_two", "UTF-8") + "=" + URLEncoder.encode(answerTwo, "UTF-8") + "&" +
                        URLEncoder.encode("answer_three", "UTF-8") + "=" + URLEncoder.encode(answerThree, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;

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
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Status");
    }
    @Override
    protected void onPostExecute(String result) {
        if (result != null){
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();

        }
    }

}