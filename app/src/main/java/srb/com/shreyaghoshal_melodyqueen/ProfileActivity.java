package srb.com.shreyaghoshal_melodyqueen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class ProfileActivity extends AppCompatActivity {


    private RelativeLayout relativeLayout;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        relativeLayout = findViewById(R.id.relative_birthday);
        textView = findViewById(R.id.text_des);


        birthdayDisplay();


    }

    private void birthdayDisplay() {

        Date c = Calendar.getInstance().getTime();

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM");
        String formattedDate = df.format(c);


        if (formattedDate.equals("12-Mar")) {
            relativeLayout.setVisibility(View.VISIBLE);
            textView.setText(R.string.birthday);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    relativeLayout.setVisibility(View.GONE);

                }
            }, 5000);

        } else if (formattedDate.equals("26-Jun")) {

            relativeLayout.setVisibility(View.VISIBLE);
            textView.setText(R.string.sg_day_prof);


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    relativeLayout.setVisibility(View.GONE);

                }
            }, 5000);

        } else {
            relativeLayout.setVisibility(View.GONE);

        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        AppManager.activityResumed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        AppManager.activityPaused();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        overridePendingTransition(R.anim.back_left_to_right, R.anim.back_right_to_left);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.back_left_to_right, R.anim.back_right_to_left);
    }
}
