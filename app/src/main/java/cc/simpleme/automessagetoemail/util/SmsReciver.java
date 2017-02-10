package cc.simpleme.automessagetoemail.util;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.telephony.SmsMessage;

import java.util.Date;

/**
 * Created by dark_ on 2017-02-10.
 */

public class SmsReciver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        SmsMessage msg = null;
        if (null != bundle) {
            Object[] smsObj = (Object[]) bundle.get("pdus");
            for (Object object : smsObj) {
                msg = SmsMessage.createFromPdu((byte[]) object);
                Date date = new Date(msg.getTimestampMillis());//时间
                SimpleDateFormat format = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                }
                if (format != null) {
                    @SuppressLint({"NewApi", "LocalSuppress"}) String receiveTime = format.format(date);
                }
                System.out.println("number:" + msg.getOriginatingAddress()
                        + "   body:" + msg.getDisplayMessageBody() + "  time:"
                        + msg.getTimestampMillis());

                //在这里写自己的逻辑
                if (msg.getOriginatingAddress().equals("10086")) {
                    //TODO

                }

            }
        }
    }

}
