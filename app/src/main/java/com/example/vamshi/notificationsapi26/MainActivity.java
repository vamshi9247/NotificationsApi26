package com.example.vamshi.notificationsapi26;

import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText message;
    Button sc1;
    Button sc2;
    Notificationcontroller notiController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editText);
        message= findViewById(R.id.editText1);
        sc1 = findViewById(R.id.button);
        sc2=findViewById(R.id.button2);
        notiController = new Notificationcontroller(this);

        sc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder nc1 = notiController.
                        getchannel1Notification(name.getText().toString(),message.getText().toString());
                NotificationManager nmc1 = notiController.getManager();
                //getting notified by the notificationManger with the builder on channel1
                     nmc1.notify(1,nc1.build());
            }
        });


        sc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder nc2 = notiController.
                        getchannel2Notification(name.getText().toString(),message.getText().toString());
                NotificationManager nmc2 = notiController.getManager();
               //getting notified by the notificationManger with the builder on channel2
                nmc2.notify(1,nc2.build());

            }
        });





    }
}
