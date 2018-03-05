package srb.com.shreyaghoshal_melodyqueen;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

public class TwitterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TwitterConfig config = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig("bxrhPcPF4dzauG6McVUjynSqz", "TatJXboP3Z1eXixVTIs3nGi52VCKJCeI1mSJylQTbluPChpSpf"))
                .debug(true)
                .build();
        Twitter.initialize(config);

        setContentView(R.layout.activity_twitter);

        ActionBar actionBar=getSupportActionBar();

        actionBar.setTitle("Tweets by ShreyaGhoshal");

        ListView listView=findViewById(R.id.listView);
        final UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName("shreyaghoshal")
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(this)
                .setTimeline(userTimeline)
                .build();
        listView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.back_left_to_right, R.anim.back_right_to_left);
    }
}
