package firstbelajar.duatujuh.manpowermanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class JobCheckout2Act extends AppCompatActivity {

    LinearLayout btn_back;
    Button btn_grabnow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_checkout2);

        btn_back = findViewById(R.id.btn_back);
        btn_grabnow = findViewById(R.id.btn_grabnow);


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backtojobpreview2 = new Intent(JobCheckout2Act.this,JobPreview2Act.class);
                startActivity(backtojobpreview2);
            }
        });

        btn_grabnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotocheckoutsuccess = new Intent(JobCheckout2Act.this,JobCheckoutSuccess.class);
                startActivity(gotocheckoutsuccess);
            }
        });


    }
}