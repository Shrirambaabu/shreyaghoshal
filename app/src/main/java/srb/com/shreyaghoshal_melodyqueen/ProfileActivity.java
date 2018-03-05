package srb.com.shreyaghoshal_melodyqueen;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.jackandphantom.circularimageview.CircleImage;

public class ProfileActivity extends AppCompatActivity {

    CircleImage circleImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ActionBar actionBar=getSupportActionBar();

        actionBar.setTitle("A Little About Shreya");
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        circleImage=findViewById(R.id.circleImage);

        Glide.with(getApplicationContext())
                .load("https://130513-375933-1-raikfcquaxqncofqfm.stackpathdns.com/wp-content/uploads/2016/10/Shreya-Ghoshal-2.jpg")
                .into(circleImage);

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
