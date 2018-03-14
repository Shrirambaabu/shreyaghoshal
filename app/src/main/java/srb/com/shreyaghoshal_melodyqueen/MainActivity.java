package srb.com.shreyaghoshal_melodyqueen;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RelativeLayout relativeProfile = findViewById(R.id.relative_profile);
        RelativeLayout relativeTweet = findViewById(R.id.relative_tweet);
        RelativeLayout relativeFamily = findViewById(R.id.relative_three);
        RelativeLayout relativeSgDay = findViewById(R.id.relative_four);
        RelativeLayout relativeStatue = findViewById(R.id.relative_five);
        RelativeLayout relativeBio = findViewById(R.id.relative_six);
        RelativeLayout relativeCareer = findViewById(R.id.relative_seven);
        RelativeLayout relativeAwards = findViewById(R.id.relative_eight);
        RelativeLayout relativeMusic = findViewById(R.id.relative_nine);
        RelativeLayout relativeConnect = findViewById(R.id.relative_ten);

        relativeProfile.setOnClickListener(this);
        relativeTweet.setOnClickListener(this);
        relativeFamily.setOnClickListener(this);
        relativeSgDay.setOnClickListener(this);
        relativeStatue.setOnClickListener(this);
        relativeBio.setOnClickListener(this);
        relativeCareer.setOnClickListener(this);
        relativeAwards.setOnClickListener(this);
        relativeMusic.setOnClickListener(this);
        relativeConnect.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sign_out: {
                // do your sign-out stuff

                new AlertDialog.Builder(this)
                        .setIcon(R.drawable.ic_exit_to_app_black_24dp)
                        .setTitle("Exit")
                        .setMessage("Are you sure you want to close this App ?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                MainActivity.super.onBackPressed();
                                overridePendingTransition(R.anim.back_left_to_right, R.anim.back_right_to_left);
                            }

                        })
                        .setNegativeButton("No", null)
                        .show();
                break;


            }


            case R.id.action_about:

                Intent sgConnectIntent = new Intent(MainActivity.this, MyDetailsActivity.class);
                startActivity(sgConnectIntent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                break;


            case R.id.action_share:

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "Hey check out the first Android app of Shreya Ghoshal by a SG fan at: https://play.google.com/store/apps/details?id=srb.com.shreyaghoshal_melodyqueen");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);

                break;

        }
        return false;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.relative_profile:

                Intent profileIntent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(profileIntent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;

            case R.id.relative_tweet:

                Intent tweetIntent = new Intent(MainActivity.this, TwitterActivity.class);
                startActivity(tweetIntent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;

            case R.id.relative_three:

                Intent familyIntent = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(familyIntent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;

            case R.id.relative_four:

                Intent sgDayIntent = new Intent(MainActivity.this, SgDay.class);
                startActivity(sgDayIntent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;

            case R.id.relative_five:

                Intent sgWaxIntent = new Intent(MainActivity.this, StatueActivity.class);
                startActivity(sgWaxIntent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;

            case R.id.relative_six:

                Intent sgBioIntent = new Intent(MainActivity.this, BiographyActivity.class);
                startActivity(sgBioIntent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;

            case R.id.relative_seven:

                Intent sgCareerIntent = new Intent(MainActivity.this, CareerActivity.class);
                startActivity(sgCareerIntent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;

            case R.id.relative_eight:

                Intent sgAwardIntent = new Intent(MainActivity.this, AwardsActivity.class);
                startActivity(sgAwardIntent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;

            case R.id.relative_nine:

                Intent sgMusicIntent = new Intent(MainActivity.this, MusicActivity.class);
                startActivity(sgMusicIntent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;

            case R.id.relative_ten:

                Intent sgConnectIntent = new Intent(MainActivity.this, ConectActivity.class);
                startActivity(sgConnectIntent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        overridePendingTransition(R.anim.back_left_to_right, R.anim.back_right_to_left);
        return true;
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
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_exit_to_app_black_24dp)
                .setTitle("Exit")
                .setMessage("Are you sure you want to close this App ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        MainActivity.super.onBackPressed();
                        overridePendingTransition(R.anim.back_left_to_right, R.anim.back_right_to_left);
                    }

                })
                .setNegativeButton("No", null)
                .show();

    }
}
