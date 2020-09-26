package firstbelajar.duatujuh.manpowermanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class JobDetailsAct extends AppCompatActivity {

    LinearLayout btn_back;
    Button btn_grabjob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_details);

        btn_back = findViewById(R.id.btn_back);
        btn_grabjob = findViewById(R.id.btn_grabjob);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backtojobpreview = new Intent(JobDetailsAct.this,JobPreviewAct.class);
                startActivity(backtojobpreview);
            }
        });

        btn_grabjob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotojobcheckout = new Intent(JobDetailsAct.this,JobCheckoutAct.class);
                startActivity(gotojobcheckout);
            }
        });



    }
}