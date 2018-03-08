package srb.com.shreyaghoshal_melodyqueen.Utils;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import srb.com.shreyaghoshal_melodyqueen.R;

public class MyDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_my_dialog);

        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        this.setFinishOnTouchOutside(false);

        Button button = findViewById(R.id.okay);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(isNetworkAvailable(MyDialog.this)){
                   finish();
               }else {
                   Toast.makeText(MyDialog.this, "No Internet !!! Please make sure you have an active internet connection", Toast.LENGTH_SHORT).show();
               }
           }
       });
    }

    private boolean isNetworkAvailable(MyDialog context) {
        boolean network = false;
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            Log.e("active", "" + activeNetwork);
            if (activeNetwork != null && activeNetwork.isConnected()) {
                Log.e("tagUTIL ", "Internet available");
                network = true;
            } else {
                Log.e("tag UTIL", "no Internet available");
            }
        } catch (Exception e) {
            Log.e("tag", "no Internet available " + e);
            network = false;
        }
        return network;
    }

    @Override
    public void onBackPressed() {
        //disabling backPress
    }
}
