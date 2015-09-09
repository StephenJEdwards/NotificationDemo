package sedwards90540.notificationdemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    // build the object that is going to be the notification itself

    NotificationCompat.Builder notification;

    private static final int uniqueID = 45123; // the notification has to be assigned a unique ID


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // build the noew notification
        notification = new NotificationCompat.Builder(this);
        // remove notification
        notification.setAutoCancel(true);
    }


    public void onNotificationClick(View view) {
        notification.setSmallIcon(R.mipmap.ic_launcher);
        notification.setTicker("This is the ticker");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Here is the title");
        notification.setContentText("Body of the notification");


        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        notification.setSound(alarmSound);

        // send the notification tot he homescreen
        Intent i = new Intent(this, MainActivity.class);
        // give the device access to perform this intent by calling PendingIntent
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
        // the '0' is the "requestCode"

        notification.setContentIntent(pendingIntent);

        // send out the notificaion
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID, notification.build());

    }


}

