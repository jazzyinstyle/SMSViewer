package com.example.smsviewer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {
	
	// Get the object of SmsManager
    final SmsManager sms = SmsManager.getDefault();
     
    public void onReceive(Context context, Intent intent) {
     
        // Retrieves a map of extended data from the intent.
        final Bundle bundle = intent.getExtras();             
        
        SMSObject smsObj = new SMSObject();
        
        try {             
            if (bundle != null) {
                 
                final Object[] pdusObj = (Object[]) bundle.get("pdus");
                 
                for (int i = 0; i < pdusObj.length; i++) {
                     
                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    
                    smsObj.setSender(currentMessage.getDisplayOriginatingAddress());
                    smsObj.setContents(currentMessage.getDisplayMessageBody());
                    smsObj.setTimestamp(currentMessage.getTimestampMillis());
 
                    Log.i("SmsReceiver", "senderNum: "+ smsObj.getSender() + 
                    		"; message: " + smsObj.getContents());
                     
                   // Show Alert
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, 
                                 "senderNum: "+ smsObj.getSender() + 
                                 ", message: " + smsObj.getContents(), duration);
                    toast.show();
                    
                } // end for loop
            } // bundle is null
	    } 
        catch (Exception e) {
        	Log.e("SmsReceiver", "Exception smsReceiver" +e);             
        }
    }  

}
