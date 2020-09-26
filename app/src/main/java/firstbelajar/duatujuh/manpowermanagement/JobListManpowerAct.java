package firstbelajar.duatujuh.manpowermanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class JobListManpowerAct extends AppCompatActivity {

    LinearLayout btn_jobevent1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_list_manpower);

        btn_jobevent1 = findViewById(R.id.btn_jobevent1);

        btn_jobevent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotojobevent1 = new Intent(JobListManpowerAct.this,JobPreview2Act.class);
                startActivity(gotojobevent1);
            }
        });




    }
}