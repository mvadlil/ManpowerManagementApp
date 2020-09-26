package firstbelajar.duatujuh.manpowermanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class JobCheckoutSuccess extends AppCompatActivity {

    Button btn_mydashboard;
    Button btn_view_myjob;
    ImageView icon_success;
    TextView app_title, app_subtitle;
    Animation app_splash, btt, ttb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_checkout_success);

        btn_mydashboard = findViewById(R.id.btn_mydashboard);
        btn_view_myjob = findViewById(R.id.btn_view_myjob);

        //load animation
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);
        btt = AnimationUtils.loadAnimation(this, R.anim.btt);
        ttb = AnimationUtils.loadAnimation(this, R.anim.ttb);

        //load element
        icon_success = findViewById(R.id.icon_success);
        app_title = findViewById(R.id.app_title);
        app_subtitle = findViewById(R.id.app_subtitle);

        //run animation
        btn_mydashboard.startAnimation(btt);
        btn_view_myjob.startAnimation(btt);
        icon_success.startAnimation(app_splash);
        app_title.startAnimation(ttb);
        app_subtitle.startAnimation(ttb);


        btn_mydashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotomydashboard = new Intent(JobCheckoutSuccess.this,HomeAct.class);
                startActivity(gotomydashboard);
            }
        });

        btn_view_myjob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotomyprofile = new Intent(JobCheckoutSuccess.this,MyProfileAct.class);
                startActivity(gotomyprofile);
            }
        });



    }
}