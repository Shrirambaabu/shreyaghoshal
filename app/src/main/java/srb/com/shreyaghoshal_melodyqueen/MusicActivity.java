package srb.com.shreyaghoshal_melodyqueen;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MusicActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView dkImage, tereImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }


        dkImage = findViewById(R.id.dk_image);
        tereImage = findViewById(R.id.teri_image);
        Button hindi = findViewById(R.id.hindi_button);
        Button tamil = findViewById(R.id.tamil_button);
        Button telugu = findViewById(R.id.telugu_button);
        Button malayalam = findViewById(R.id.malayalam_button);


        dkImage.setOnClickListener(this);
        tereImage.setOnClickListener(this);
        hindi.setOnClickListener(this);
        tamil.setOnClickListener(this);
        telugu.setOnClickListener(this);
        malayalam.setOnClickListener(this);


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
            case R.id.dk_image:


                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://youtu.be/V9RKsog3NA4"));
                startActivity(intent);

                break;

            case R.id.teri_image:


                Intent intentTeri = new Intent();
                intentTeri.setAction(Intent.ACTION_VIEW);
                intentTeri.addCategory(Intent.CATEGORY_BROWSABLE);
                intentTeri.setData(Uri.parse("https://youtu.be/2dosEvcBt7c"));
                startActivity(intentTeri);

                break;

            case R.id.hindi_button:


               /* Intent hindiIntent = new Intent();
                hindiIntent.setAction(Intent.ACTION_VIEW);
                hindiIntent.addCategory(Intent.CATEGORY_BROWSABLE);
                hindiIntent.setData(Uri.parse("http://mymp3song.me/singer/Shreya+Ghoshal/new2old/1"));
                startActivity(hindiIntent);*/

                Intent browserHindiIntent = new Intent(MusicActivity.this,WebViewActivity.class);
                browserHindiIntent.putExtra("add","https://gaana.com/playlist/gaana-dj-surilee-shreya-radio");
                browserHindiIntent.putExtra("title","Hindi Songs");
                startActivity(browserHindiIntent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                break;

            case R.id.tamil_button:

/*
                Intent tamilIntent = new Intent();
                tamilIntent.setAction(Intent.ACTION_VIEW);
                tamilIntent.addCategory(Intent.CATEGORY_BROWSABLE);
                tamilIntent.setData(Uri.parse("http://tamiltunes.live/voice-shreya-ghoshal-41-tamil-mp3-songs.html"));
                startActivity(tamilIntent);*/
                Intent browserIntent = new Intent(MusicActivity.this,WebViewActivity.class);
                browserIntent.putExtra("add","https://gaana.com/playlist/gaana-dj-shreya-ghoshals-tamil-hits");
                browserIntent.putExtra("title","Tamil Songs");
                startActivity(browserIntent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;

            case R.id.telugu_button:


               /* Intent teluguIntent = new Intent();
                teluguIntent.setAction(Intent.ACTION_VIEW);
                teluguIntent.addCategory(Intent.CATEGORY_BROWSABLE);
                teluguIntent.setData(Uri.parse("http://mp3tj.net/mp3/shreya-ghoshal-telugu-mp3-songs-free-download.html"));
                startActivity(teluguIntent);*/

                Intent browserTeluguIntent = new Intent(MusicActivity.this,WebViewActivity.class);
                browserTeluguIntent.putExtra("add","https://gaana.com/playlist/ks-raju-1-shreya-ghoshaltelugu");
                browserTeluguIntent.putExtra("title","Telugu Songs");
                startActivity(browserTeluguIntent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                break;

            case R.id.malayalam_button:


               /* Intent malayalamIntent = new Intent();
                malayalamIntent.setAction(Intent.ACTION_VIEW);
                malayalamIntent.addCategory(Intent.CATEGORY_BROWSABLE);
                malayalamIntent.setData(Uri.parse("http://kuttynet.in/index.php?dir=Mp3%20Songs/Other%20Language%20Songs/Malayalam%20Mp3%20Songs/Shreya%20Ghoshal%20Malayalam%20Hit%20Songs&p=1&sort=0"));
                startActivity(malayalamIntent);*/

                Intent browserMalayalamIntent = new Intent(MusicActivity.this,WebViewActivity.class);
                browserMalayalamIntent.putExtra("add","https://gaana.com/playlist/gaana-dj-shreya-ghoshal-malayalam-romantic-songs");
                browserMalayalamIntent.putExtra("title","Malayalam Songs");
                startActivity(browserMalayalamIntent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                break;
        }

    }
}
