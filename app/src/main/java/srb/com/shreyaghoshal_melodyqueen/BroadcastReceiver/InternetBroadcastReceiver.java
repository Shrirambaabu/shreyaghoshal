package srb.com.shreyaghoshal_melodyqueen.BroadcastReceiver;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import srb.com.shreyaghoshal_melodyqueen.AppManager;

/**
 * Created by Shriram on 3/7/2018.
 */

public class InternetBroadcastReceiver extends BroadcastReceiver {

    private static boolean firstConnect = true;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (AppManager.isActivityVisible()) {
            try {
                ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                if (activeNetwork == null) {
                    if (firstConnect) {
                        Log.e("tag UTIL", "no Internet available");
                        firstConnect = false;
                        Intent i = new Intent();
                        i.setClassName("srb.com.shreyaghoshal_melodyqueen", "srb.com.shreyaghoshal_melodyqueen.Utils.MyDialog");
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(i);

                        //      context.startActivity(new Intent(context, MyDialog.class));
                    } else {
                        firstConnect = false;
                    }
                } else {
                    firstConnect = true;
                }

            } catch (Exception e) {
                Log.e("tag", "no Internet available " + e);
            }
        }

    }



}
