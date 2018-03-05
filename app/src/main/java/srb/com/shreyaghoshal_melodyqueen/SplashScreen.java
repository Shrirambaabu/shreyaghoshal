package srb.com.shreyaghoshal_melodyqueen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_scree);


        ImageView circleImage=findViewById(R.id.splash_image);

        Glide.with(getApplicationContext())
                .load(R.drawable.ss_splash)
                .into(new GlideDrawableImageViewTarget(circleImage));

        int SPLASH_TIME_OUT = 5000;
        new  Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                // close this activity
                finish();
            }
        },SPLASH_TIME_OUT);


    }
}
