package firstbelajar.duatujuh.manpowermanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class JobDetails2Act extends AppCompatActivity {

    LinearLayout btn_back;
    Button btn_grabjob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_details2);

        btn_back = findViewById(R.id.btn_back);
        btn_grabjob = findViewById(R.id.btn_grabjob);


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backtojobpreview2 = new Intent(JobDetails2Act.this,JobPreview2Act.class);
                startActivity(backtojobpreview2);
            }
        });

        btn_grabjob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotojobcheckout2 = new Intent(JobDetails2Act.this,JobCheckout2Act.class);
                startActivity(gotojobcheckout2);
            }
        });


    }
}