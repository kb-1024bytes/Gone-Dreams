package org.tensorflow.lite.examples.posenet;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
public class AlarmReceiver2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            Toast.makeText(context, "Ho gaya", Toast.LENGTH_LONG).show();
            Log.d("AlarrReceiver2", "fired inside if");
        }
        Log.d("AlarrReceiver2", "fired outside if");
    }
}