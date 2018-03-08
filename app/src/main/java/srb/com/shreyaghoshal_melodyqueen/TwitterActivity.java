package srb.com.shreyaghoshal_melodyqueen;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.TweetUi;
import com.twitter.sdk.android.tweetui.UserTimeline;
import com.wang.avi.AVLoadingIndicatorView;

public class TwitterActivity extends AppCompatActivity {

   // private ProgressDialog pDialog;

    private AVLoadingIndicatorView avLoadingIndicatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TwitterConfig config = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig("Ffbi364rFFONcf5mRHh8g6rHk", "hXruGqWr9IYGWplxmsqjlEjt7q0dPw1IDjOJdajFPI0IaudNAv"))
                .debug(true)
                .build();
        Twitter.initialize(config);
        TweetUi.getInstance();
        setContentView(R.layout.activity_twitter);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setTitle("Tweets by Shreya");
        }
        avLoadingIndicatorView=findViewById(R.id.avi);


        avLoadingIndicatorView.show();
        avLoadingIndicatorView.setVisibility(View.VISIBLE);
/*


        pDialog = new ProgressDialog(TwitterActivity.this, R.style.MyThemeProgress);
        pDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Large);
        pDialog.onBackPressed();
        pDialog.setCancelable(false);
        pDialog.setCanceledOnTouchOutside(false);
        pDialog.setMessage("Getting tweets for you...");
        pDialog.show();*/

        Runnable progressRunnable = new Runnable() {

            @Override
            public void run() {
              //  pDialog.dismiss();
                avLoadingIndicatorView.hide();
                avLoadingIndicatorView.setVisibility(View.GONE);
            }
        };

        Handler pdCanceller = new Handler();
        pdCanceller.postDelayed(progressRunnable, 5000);

        ListView listView = findViewById(R.id.listView);
        final UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName("shreyaghoshal")
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(this)
                .setTimeline(userTimeline)
                .build();
        listView.setAdapter(adapter);
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
        super.onBackPressed();
        overridePendingTransition(R.anim.back_left_to_right, R.anim.back_right_to_left);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        overridePendingTransition(R.anim.back_left_to_right, R.anim.back_right_to_left);
        return true;
    }

}
