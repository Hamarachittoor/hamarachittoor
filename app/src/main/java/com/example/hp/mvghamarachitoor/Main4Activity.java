package com.example.hp.mvghamarachitoor;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;


import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Main4Activity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        final EditText et1=(EditText)findViewById(R.id.C3);
        final EditText et2= (EditText)findViewById(R.id.C4);
        final EditText et3= (EditText)findViewById(R.id.C5);
        Button submitbutton1 = (Button) findViewById(R.id.Q1);
        submitbutton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(et1.getText().toString().trim().length() == 0){
                    et1.setError("Cannot be empty");
                }else if(et2.getText().toString().trim().length() == 0){
                    et2.setError("Cannot be empty");
                }else if(et3.getText().toString().trim().length() == 0){
                    et3.setError("Cannot be empty");
                }
                else{
                    // WHEN THERE ARE NO EMPTY FIELDS,EXECUTE AS REQUIRED
                    String s1 = et1.getText().toString()+'\n';
                    String s2 = et2.getText().toString()+'\n';
                    String s3 = et3.getText().toString()+'\n';

                    Session session = null;
                    Context context = null;

                    String loc,subject,textMessage;

                    String rec = "hello@hamarachittoor.com";



                    subject = "Event Management Request";
                    textMessage = "This is "+s1+" and my Mobile Number is"+s2+". "+s3;

                    Properties props = new Properties();
                    props.put("mail.smtp.host","smtp.gmail.com");
                    props.put("mail.smtp.socketFactory.port","465");
                    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
                    props.put("mail.smtp.auth","true");
                    props.put("mail.smtp.port","465");


                    session = Session.getDefaultInstance(props, new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication(){
                            return new PasswordAuthentication("hamarachitoor@gmail.com","hamarachitoor1");

                        }
                    });
                    RetrieveFeedTask task = new RetrieveFeedTask(session,rec,subject,textMessage);
                    task.execute();
                }

                }

        });

    }


    public class RetrieveFeedTask extends AsyncTask<String,Void,String> {
        Session session;
        String subject;
        String textMessage;
        String rec;
        RetrieveFeedTask(Session s1,String r1,String s3,String t3){
             session=s1;
            subject=s3;
            textMessage=t3;
            rec=r1;
        }
        @Override
        protected String doInBackground(String... params) {
            try{
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("hamarachitoor@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(rec));
                message.setSubject(subject);
                message.setContent(textMessage,"text/html; charset=utf-8");

                Transport.send(message);

            } catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            Toast.makeText(getApplicationContext(),"Your Request has been recieved! We will get back to you shortly!",Toast.LENGTH_LONG).show();
        }
    }


}
