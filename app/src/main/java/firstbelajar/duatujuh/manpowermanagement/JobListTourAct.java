package firstbelajar.duatujuh.manpowermanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class JobListTourAct extends AppCompatActivity {

    LinearLayout btn_jobtour1, btn_jobtour2, btn_jobtour3, btn_jobtour4,
            btn_jobtour5, btn_jobtour6, btn_jobtour7;
    TextView nama_tour1, nama_tour2, nama_tour3, nama_tour4,
            nama_tour5, nama_tour6, nama_tour7,
            periode_tour1, periode_tour2, periode_tour3, periode_tour4,
            periode_tour5, periode_tour6, periode_tour7;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_list_tour);

        //load button tour
        btn_jobtour1 = findViewById(R.id.btn_jobtour1);
        btn_jobtour2 = findViewById(R.id.btn_jobtour2);
        btn_jobtour3 = findViewById(R.id.btn_jobtour3);
        btn_jobtour4 = findViewById(R.id.btn_jobtour4);
        btn_jobtour5 = findViewById(R.id.btn_jobtour5);
        btn_jobtour6 = findViewById(R.id.btn_jobtour6);
        btn_jobtour7 = findViewById(R.id.btn_jobtour7);

        //load element tour
        nama_tour1 = findViewById(R.id.nama_tour1);
        nama_tour2 = findViewById(R.id.nama_tour2);
        nama_tour3 = findViewById(R.id.nama_tour3);
        nama_tour4 = findViewById(R.id.nama_tour4);
        nama_tour5 = findViewById(R.id.nama_tour5);
        nama_tour6 = findViewById(R.id.nama_tour6);
        nama_tour7 = findViewById(R.id.nama_tour7);
        periode_tour1 = findViewById(R.id.periode_tour1);
        periode_tour2 = findViewById(R.id.periode_tour2);
        periode_tour3 = findViewById(R.id.periode_tour3);
        periode_tour4 = findViewById(R.id.periode_tour4);
        periode_tour5 = findViewById(R.id.periode_tour5);
        periode_tour6 = findViewById(R.id.periode_tour6);
        periode_tour7 = findViewById(R.id.periode_tour7);

        //mengambil data dari intent tombol yang di klik di activity sebelumnya
        Bundle bundle = getIntent().getExtras();
        String jenis_job_baru = bundle.getString("jenis_job");

        //mengambil data dari firebase berdasarkan intent
        reference = FirebaseDatabase.getInstance().getReference().child("ListJob").child(jenis_job_baru);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                //menimpa data yang ada dengan data yang baru
                nama_tour1.setText(dataSnapshot.child("nama_tour1").getValue().toString());
                nama_tour2.setText(dataSnapshot.child("nama_tour2").getValue().toString());
                nama_tour3.setText(dataSnapshot.child("nama_tour3").getValue().toString());
                nama_tour4.setText(dataSnapshot.child("nama_tour4").getValue().toString());
                nama_tour5.setText(dataSnapshot.child("nama_tour5").getValue().toString());
                nama_tour6.setText(dataSnapshot.child("nama_tour6").getValue().toString());
                nama_tour7.setText(dataSnapshot.child("nama_tour7").getValue().toString());
                periode_tour1.setText(dataSnapshot.child("periode_tour1").getValue().toString());
                periode_tour2.setText(dataSnapshot.child("periode_tour2").getValue().toString());
                periode_tour3.setText(dataSnapshot.child("periode_tour3").getValue().toString());
                periode_tour4.setText(dataSnapshot.child("periode_tour4").getValue().toString());
                periode_tour5.setText(dataSnapshot.child("periode_tour5").getValue().toString());
                periode_tour6.setText(dataSnapshot.child("periode_tour6").getValue().toString());
                periode_tour7.setText(dataSnapshot.child("periode_tour7").getValue().toString());

            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        });



        btn_jobtour1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotojobtour1 = new Intent(JobListTourAct.this,JobPreviewAct.class);
                //ambil intent untuk next activity
                gotojobtour1.putExtra("nomor_tour", "tour1");
                startActivity(gotojobtour1);
            }
        });
        btn_jobtour2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotojobtour2 = new Intent(JobListTourAct.this,JobPreviewAct.class);
                //ambil intent untuk next activity
                gotojobtour2.putExtra("nomor_tour", "tour2");
                startActivity(gotojobtour2);
            }
        });
        btn_jobtour3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotojobtour3 = new Intent(JobListTourAct.this,JobPreviewAct.class);
                //ambil intent untuk next activity
                gotojobtour3.putExtra("nomor_tour", "tour3");
                startActivity(gotojobtour3);
            }
        });
        btn_jobtour4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotojobtour4 = new Intent(JobListTourAct.this,JobPreviewAct.class);
                //ambil intent untuk next activity
                gotojobtour4.putExtra("nomor_tour", "tour4");
                startActivity(gotojobtour4);
            }
        });
        btn_jobtour5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotojobtour5 = new Intent(JobListTourAct.this,JobPreviewAct.class);
                //ambil intent untuk next activity
                gotojobtour5.putExtra("nomor_tour", "tour5");
                startActivity(gotojobtour5);
            }
        });
        btn_jobtour6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotojobtour6 = new Intent(JobListTourAct.this,JobPreviewAct.class);
                //ambil intent untuk next activity
                gotojobtour6.putExtra("nomor_tour", "tour6");
                startActivity(gotojobtour6);
            }
        });
        btn_jobtour7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotojobtour7 = new Intent(JobListTourAct.this,JobPreviewAct.class);
                //ambil intent untuk next activity
                gotojobtour7.putExtra("nomor_tour", "tour7");
                startActivity(gotojobtour7);
            }
        });


    }
}