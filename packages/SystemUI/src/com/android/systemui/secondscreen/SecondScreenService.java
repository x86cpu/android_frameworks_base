package com.android.systemui.secondscreen;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class SecondScreenService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Intent viewIntent = new Intent(this, SecondScreenActivity.class);
        viewIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(viewIntent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
