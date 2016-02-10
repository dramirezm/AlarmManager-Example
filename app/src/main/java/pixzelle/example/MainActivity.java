package pixzelle.example;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Calendar;

import pixzelle.example.R;

public class MainActivity extends Activity
{

    private PendingIntent pendingIntent;
    AlarmManager alarmManager;
    Intent alarmIntent;
    Calendar alarmStartTime;
    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setAlarm(17, 0, 0);
        setAlarm(18, 0, 0);
        setAlarm(19, 0, 0);
        setAlarm(20, 0, 0);
        setAlarm(21, 0, 0);
        setAlarm(22, 0, 0);
        setAlarm(23, 0, 0);
        setAlarm(24, 0, 0);

    } //end onCreate



    public void setAlarm(int hora, int minuto, int segundos){
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmIntent = new Intent(MainActivity.this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(  MainActivity.this, 0, alarmIntent, 0);

        alarmStartTime =  Calendar.getInstance();


        alarmStartTime.set(Calendar.HOUR_OF_DAY, hora);
        alarmStartTime.set(Calendar.MINUTE, minuto);
        alarmStartTime.set(Calendar.SECOND, segundos);

        Log.e("Alarm Manager",alarmStartTime.toString());
        alarmManager.setRepeating(AlarmManager.RTC, alarmStartTime.getTimeInMillis(), getInterval(), pendingIntent);
    }
    private int getInterval(){
        int days = 1;
        int hours = 24;
        int minutes = 60;
        int seconds = 60;
        int milliseconds = 1000;
        int repeatMS = days * hours * minutes * seconds * milliseconds;
        return repeatMS;
    }
}