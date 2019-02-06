/**
 * Copyright Teclib. All rights reserved.
 *
 * React Native Silent Ping SMS is used to send the sms and bring the delivery report.
 * ------------------------------------------------------------------------------
 * Created by yeyintkoko on 11/4/16.
 * @author    Erik Campos
 * @copyright Copyright Teclib. All rights reserved.
 * @version   1.2.0
 * @license   GPLv3 https://www.gnu.org/licenses/gpl-3.0.html
 * @link      https://github.com/CamposErik/React-Native-Silent-Ping-Sms
 * ------------------------------------------------------------------------------
 */

package com.reactlibrary;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.SmsManager;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.Date;

public class SendSilentSMS extends ReactContextBaseJavaModule {
    
    final byte[] payload = new byte[]{0x0A, 0x06, 0x03, (byte) 0xB0, (byte) 0xAF, (byte) 0x82, 0x03, 0x06, 0x6A, 0x00, 0x05};

    public String date;

    private final ReactApplicationContext reactContext;
    private Callback callback = null;

    /**
     * Constructor
     * @param reactContext
     */

    public SendSilentSMS(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    /**
     * Get the name of the activity
     * @return string the name
     */

    @Override
    public String getName() {
        return "SendSilentSMS";
    }

    /**
     * Send the callback to include in the sms.
     */

    private void sendCallback(Integer messageId, String message) {
        if (callback != null) {
            callback.invoke(messageId, message);
            callback = null;
        }
    }

    /**
     * Sends an SMS message to another device.
     * Generate the method that you can use in javascript.
     */

    @ReactMethod
    public void send(final Integer messageId, String phoneNumber, final Callback cb) {

        try {

            //Data about the day and hours
            Date hourdateFormat = new Date();
            final String date = ("Date" + hourdateFormat);

            System.out.println("Enviado");
            this.callback = cb;
            String SENT = "SMS_SENT";
            String DELIVERED = "SMS_DELIVERED";

            PendingIntent sentPI = PendingIntent.getBroadcast(reactContext, 0, new Intent(SENT), 0);

            PendingIntent deliveredPI = PendingIntent.getBroadcast(reactContext, 0, new Intent(DELIVERED), 0);

            SmsManager sms = SmsManager.getDefault();
            sms.sendDataMessage(phoneNumber, null, (short) 9200, payload, sentPI, deliveredPI);

            // ---when the SMS has been sent---
            reactContext.registerReceiver(new BroadcastReceiver() {
                @Override
                public void onReceive(Context arg0, Intent arg1) {
                    switch (getResultCode()) {
                    case Activity.RESULT_OK:
                        System.out.println("SMS sent");
                        sendCallback(messageId, "SMS sent");
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        System.out.println("SMS sent");
                        sendCallback(messageId, "Generic failure");
                        break;
                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        System.out.println("SMS sent");
                        sendCallback(messageId, "No service");
                        break;
                    case SmsManager.RESULT_ERROR_NULL_PDU:
                        System.out.println("SMS sent");
                        sendCallback(messageId, "Null PDU");
                        break;
                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                        System.out.println("SMS sent");
                        sendCallback(messageId, "Radio off");
                        break;
                    }
                }
            }, new IntentFilter(SENT));

            // ---when the SMS has been delivered---
            reactContext.registerReceiver(new BroadcastReceiver() {
                @Override
                public void onReceive(Context arg0, Intent arg1) {
                    switch (getResultCode()) {
                    case Activity.RESULT_OK:
                        System.out.println("SMS delivered");
                        System.out.println(date);
                        sendCallback(messageId, "SMS delivered");
                        break;
                    case Activity.RESULT_CANCELED:
                        System.out.println("SMS not delivered");
                        sendCallback(messageId, "SMS not delivered");
                        break;
                    }
                }
            }, new IntentFilter(DELIVERED));

        } catch (Exception e) {

            sendCallback(messageId, "Unknown error");
            throw e;

        }

    }

}
