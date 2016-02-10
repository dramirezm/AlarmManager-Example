package pixzelle.example;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by diego.ramirez on 10/02/2016.
 */
public class AlarmReceiver extends BroadcastReceiver {

    NotificationManager notificationManager;
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent service1 = new Intent(context, AlarmService.class);
        context.startService(service1);

    }
}
