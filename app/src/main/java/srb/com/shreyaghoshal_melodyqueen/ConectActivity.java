package srb.com.shreyaghoshal_melodyqueen;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ConectActivity extends AppCompatActivity implements View.OnClickListener {


    RelativeLayout relativeLayout;

    RelativeLayout facebook, twitter, instagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conect);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        relativeLayout = findViewById(R.id.create);
        facebook = findViewById(R.id.sg_fb);
        twitter = findViewById(R.id.sg_twitter);
        instagram = findViewById(R.id.sg_insta);


        relativeLayout.setOnClickListener(this);
        facebook.setOnClickListener(this);
        twitter.setOnClickListener(this);
        instagram.setOnClickListener(this);


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
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.create:

                Intent sgConnectIntent = new Intent(ConectActivity.this, MyDetailsActivity.class);
                startActivity(sgConnectIntent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                break;

            case R.id.sg_fb:

                Intent fbIntent = new Intent();
                fbIntent.setAction(Intent.ACTION_VIEW);
                fbIntent.addCategory(Intent.CATEGORY_BROWSABLE);
                fbIntent.setData(Uri.parse("https://www.facebook.com/shreyaghoshal"));
                startActivity(fbIntent);

                break;

            case R.id.sg_twitter:

                Intent twIntent = new Intent();
                twIntent.setAction(Intent.ACTION_VIEW);
                twIntent.addCategory(Intent.CATEGORY_BROWSABLE);
                twIntent.setData(Uri.parse("https://twitter.com/shreyaghoshal"));
                startActivity(twIntent);

                break;

            case R.id.sg_insta:

                Intent instaIntent = new Intent();
                instaIntent.setAction(Intent.ACTION_VIEW);
                instaIntent.addCategory(Intent.CATEGORY_BROWSABLE);
                instaIntent.setData(Uri.parse("https://www.instagram.com/shreyaghoshal"));
                startActivity(instaIntent);

                break;

        }
    }
}
