package firstbelajar.duatujuh.manpowermanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Animation app_splash, btt;
    ImageView app_logo;
    TextView app_subtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //load animation
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);
        btt = AnimationUtils.loadAnimation(this, R.anim.btt);


        //load element
        app_logo = findViewById(R.id.app_logo);
        app_subtitle = findViewById(R.id.app_subtitle);

        //run animation
        app_logo.startAnimation(app_splash);
        app_subtitle.startAnimation(btt);



        //setting timer untuk delay 2 detik
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //merubah activity ke activity lain
                Intent gogetstarted = new Intent( MainActivity.this,GetStartedAct.class);
                startActivity(gogetstarted);
                finish();
            }
        }, 2000); // 2000 ms = 2s (2 detik_)
    }
}
