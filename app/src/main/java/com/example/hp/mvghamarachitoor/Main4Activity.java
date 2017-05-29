package com.example.hp.mvghamarachitoor;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
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

public class Main4Activity extends Activity implements View.OnClickListener {
    EditText et1;
    EditText et2;
    EditText et3;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

    }

    Session session = null;
    Context context = null;

    String loc,subject,textMessage;



    String s1,s2,s3;

    String rec = "mangalnathanvg@gmail.com";
    String sender = "mvbtestapplication@gmail.com";
    String password = "androidappmvb";


    String pass = "androidappmvb";


    @Override
    public void onClick(View view) {

        et1 = (EditText)findViewById(R.id.C3);
        et2 = (EditText)findViewById(R.id.C4);
        et3 = (EditText)findViewById(R.id.C5);

        s1 = et1.getText().toString()+'\n';
        s2 = et2.getText().toString()+'\n';
        s3 = et3.getText().toString()+'\n';




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
                return new PasswordAuthentication("mvbtestapplication@gmail.com","androidappmvb");

            }
        });


        RetrieveFeedTask task = new RetrieveFeedTask();
        task.execute();




    }

    public class RetrieveFeedTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... params) {
            try{
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("mvbtestapplication@gmail.com"));
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
