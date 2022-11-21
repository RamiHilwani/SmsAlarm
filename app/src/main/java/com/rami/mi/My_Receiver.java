package com.rami.mi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.AlarmClock;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class My_Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        SmsMessage[] smsMessages = Telephony.Sms.Intents.getMessagesFromIntent(intent);
        String body = smsMessages[0].getMessageBody();
        String caller_number = smsMessages[0].getDisplayOriginatingAddress();
        Log.e("phone", caller_number);
        Toast.makeText(context, "received", Toast.LENGTH_SHORT).show();
//        Intent intent1= new Intent(context,MainActivity.class);
//        intent1.putExtra("body",body);
//        intent1.putExtra("phone",caller_number);
//        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(intent1);
        Intent timer = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "HACE EL CAFE POR FAVOR")
                .putExtra(AlarmClock.EXTRA_LENGTH, 20)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            timer.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(timer);
        }

    }

}
