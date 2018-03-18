package com.espoir.broadcastrceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {
 
    public static final String ACTION = "android.provider.Telephony.SMS_RECEIVED";
 
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        if (intent.getAction().equals(ACTION)){ 
            Bundle bundle = intent.getExtras();
            if (bundle != null){
                Object[] pdus = (Object[]) bundle.get("pdus");
                SmsMessage[] messages = new SmsMessage[pdus.length];
                for (int i = 0; i < pdus.length; i++){
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                }
                for (SmsMessage message : messages){
                     
                    String strMessageFrom = message.getDisplayOriginatingAddress();
                    String strMessageBody = message.getDisplayMessageBody();
 
                    Toast.makeText(context, "SMS Message received from:" +strMessageFrom, Toast.LENGTH_LONG).show();
                    Toast.makeText(context, "SMS Message content" +strMessageBody, Toast.LENGTH_LONG).show();
 
                }
            }    
        } 
    }
 
}