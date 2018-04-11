package com.example.hanan.eduhr_application;

/**
 * Created by Hanan on 3/19/2018.
 */


import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
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
        String signUp_url = "https://appwebhost2018.000webhostapp.com/signUp.php";
        String saveTeacherInfo_url = "https://appwebhost2018.000webhostapp.com/saveInfo.php";
        String updateTeacherInfo_url = "https://appwebhost2018.000webhostapp.com/updateInfo.php";
        String login_url = "https://appwebhost2018.000webhostapp.com/login.php";
        String signin_url = "https://appwebhost2018.000webhostapp.com/signIn.php";
        String saveAnswers_url = "https://appwebhost2018.000webhostapp.com/saveAnswers.php";
        String search = "https://appwebhost2018.000webhostapp.com/searchID.php";
        String saveAnswer1_url1 = "https://appwebhost2018.000webhostapp.com/EnterinfoCV.php";



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


            try {
                URL url = new URL(updateTeacherInfo_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("teacher_id", "UTF-8") + "=" + URLEncoder.encode(teacher_id, "UTF-8") + "&" +
                        URLEncoder.encode("teacher_phone", "UTF-8") + "=" + URLEncoder.encode(teacher_phone, "UTF-8") + "&" +
                        URLEncoder.encode("teacher_email", "UTF-8") + "=" + URLEncoder.encode(teacher_email, "UTF-8");
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

        else if (method.equals("search")) {
            String teacher_id = params[1];


            try {
                URL url = new URL(search);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("search_id", "UTF-8") + "=" + URLEncoder.encode(teacher_id, "UTF-8") ;

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
        }else if (method.equals("save_answers")) {
            String admin_id = params[1];
            String answer_one = params[2];
            String answer_two= params[3];
            String answer_three = params[4];

            try {
                URL url = new URL(saveAnswers_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("teacher_id", "UTF-8") + "=" + URLEncoder.encode(admin_id, "UTF-8") + "&" +
                        URLEncoder.encode("answer_one", "UTF-8") + "=" + URLEncoder.encode(answer_one, "UTF-8")+ "&" +
                        URLEncoder.encode("answer_two", "UTF-8") + "=" + URLEncoder.encode(answer_two, "UTF-8")+ "&" +
                        URLEncoder.encode("answer_three", "UTF-8") + "=" + URLEncoder.encode(answer_three, "UTF-8");
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
        else if (method.equals("save_answer")) {
            String admin_id = params[1];
            String answer_1 = params[2];
            String answer_2= params[3];
            String answer_3 = params[4];

            try {
                URL url = new URL(saveAnswer1_url1);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("teacher_id", "UTF-8") + "=" + URLEncoder.encode(admin_id, "UTF-8") + "&" +
                        URLEncoder.encode("answer_1", "UTF-8") + "=" + URLEncoder.encode(answer_1, "UTF-8")+ "&" +
                        URLEncoder.encode("answer_2", "UTF-8") + "=" + URLEncoder.encode(answer_2, "UTF-8")+ "&" +
                        URLEncoder.encode("answer_3", "UTF-8") + "=" + URLEncoder.encode(answer_3, "UTF-8");
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