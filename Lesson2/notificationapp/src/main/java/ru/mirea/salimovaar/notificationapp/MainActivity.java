package ru.mirea.salimovaar.notificationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "com.mirea.asd.notification.ANDROID";

    private int PermissionCode = 200;
    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this, POST_NOTIFICATIONS) == Pack-
                ageManager.PERMISSION_GRANTED) {

            Log.d(MainActivity.class.getSimpleName().toString(), "Разрешения получены");

        } else {
            Log.d(MainActivity.class.getSimpleName().toString(), "Нет разрешений!");

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permis-
                    sion.POST_NOTIFICATIONS}, PermissionCode);

        }
    }

    public void onClickSendNotification (View view) (View view) {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permis-
                sion.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {

            return;
        }

        NotificationCompat.Builder builder = new NotificationCom-
                pat.Builder(this, CHANNEL_ID)

                        .setContentText("Congratulation!")
                        .setSmallIcon(R.drawable.baseline_1x_mobiledata_24)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setStyle(new NotificationCompat.BigTextStyle()

                                .bigText("Much longer text that cannot fit one
                                        line..."))
                .setContentTitle("Mirea");
        int importance = NotificationManager.IMPORTANCE_DEFAULT;

        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Stu-
                dent FIO Notification", importance);

                channel.setDescription("MIREA Channel");

        NotificationManagerCompat notificationManager = NotificationManagerCom-
                pat.from(this);

        notificationManager.createNotificationChannel(channel);
        notificationManager.notify(1, builder.build());
    }
}