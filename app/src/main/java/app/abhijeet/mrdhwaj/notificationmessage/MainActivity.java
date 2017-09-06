package app.abhijeet.mrdhwaj.notificationmessage;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= (Button) findViewById(R.id.send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                PendingIntent pendingIntent=PendingIntent.getActivity(MainActivity.this,0,intent,0);
                Notification notification=new Notification.Builder(MainActivity.this)
                        .setTicker("Ticker Hello !!")
                        .setContentTitle("Notification bar")
                        .setContentText("This is notification")
                        .addAction(R.mipmap.ic_launcher,"Action 1",pendingIntent)
                        .addAction(R.mipmap.ic_launcher,"Action 2",pendingIntent)
                        .addAction(R.mipmap.ic_launcher,"Action 3",pendingIntent)
                        .setSmallIcon(R.mipmap.ic_launcher).setContentIntent(pendingIntent).getNotification();
                notification.flags=Notification.FLAG_AUTO_CANCEL;
                NotificationManager nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                nm.notify(0,notification);


            }
        });
    }
}
