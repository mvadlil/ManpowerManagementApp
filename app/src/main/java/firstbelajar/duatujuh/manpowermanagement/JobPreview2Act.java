package firstbelajar.duatujuh.manpowermanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class JobPreview2Act extends AppCompatActivity {

    LinearLayout btn_back;
    Button btn_job_details;
    Button btn_grabjob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_preview2);

        btn_back = findViewById(R.id.btn_back);
        btn_job_details = findViewById(R.id.btn_job_details);
        btn_grabjob = findViewById(R.id.btn_grabjob);


        btn_job_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotojobdetails2 = new Intent(JobPreview2Act.this,JobDetails2Act.class);
                startActivity(gotojobdetails2);
            }
        });

        btn_grabjob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotojobcheckout2 = new Intent(JobPreview2Act.this,JobCheckout2Act.class);
                startActivity(gotojobcheckout2);
            }
        });


    }
}