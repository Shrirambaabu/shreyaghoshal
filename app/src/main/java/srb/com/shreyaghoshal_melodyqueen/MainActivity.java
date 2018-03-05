package srb.com.shreyaghoshal_melodyqueen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout relativeProfile, relativeTweet,relativeFamily;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeProfile = findViewById(R.id.relative_profile);
        relativeTweet = findViewById(R.id.relative_tweet);
        relativeFamily = findViewById(R.id.relative_three);

        relativeProfile.setOnClickListener(this);
        relativeTweet.setOnClickListener(this);
        relativeFamily.setOnClickListener(this);

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

                Intent tweetIntent=new Intent(MainActivity.this,TwitterActivity.class);
                startActivity(tweetIntent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;

            case R.id.relative_three:

                Intent familyIntent=new Intent(MainActivity.this,FamilyActivity.class);
                startActivity(familyIntent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
        }

    }
}
