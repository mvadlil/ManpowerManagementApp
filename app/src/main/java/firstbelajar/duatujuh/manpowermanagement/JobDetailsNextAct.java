package firstbelajar.duatujuh.manpowermanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class JobDetailsNextAct extends AppCompatActivity {

    LinearLayout btn_back;
    Button btn_job_details;
    Button btn_cancel_job;
    TextView nama_tour, tour_client, periode_tour, tour_location, maps;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_preview);

        //load element dan button
        btn_back = findViewById(R.id.btn_back);
        btn_cancel_job = findViewById(R.id.btn_cancel_job);
        btn_job_details = findViewById(R.id.btn_job_details);
        nama_tour = findViewById(R.id.nama_tour);
        tour_client = findViewById(R.id.tour_client);
        periode_tour = findViewById(R.id.periode_tour);
        tour_location = findViewById(R.id.tour_location);
        maps = findViewById(R.id.maps);


        //mengambil data dari intent tombol yang di klik di activity sebelumnya
        Bundle bundle = getIntent().getExtras();
        final String nama_tour_baru = bundle.getString("nama_tour");

        //mengambil data dari firebase berdasarkan intent
        reference = FirebaseDatabase.getInstance().getReference().child("JobTourNext").child(nama_tour_baru);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                //menimpa data yang ada dengan data yang baru
                nama_tour.setText(dataSnapshot.child("nama_tour").getValue().toString());
                tour_client.setText(dataSnapshot.child("tour_client").getValue().toString());
                periode_tour.setText(dataSnapshot.child("periode_tour").getValue().toString());
                tour_location.setText(dataSnapshot.child("tour_location").getValue().toString());

            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        });

        Toast.makeText(getApplicationContext(),"nomor: "+ nama_tour_baru, Toast.LENGTH_SHORT).show();





        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tomaps = new Intent(JobDetailsNextAct.this,Maps2Act.class);
                //ambil intent untuk next activity
                tomaps.putExtra("nama_tour", (nama_tour_baru));
                startActivity(tomaps);
            }
        });

        btn_job_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tomaps = new Intent(JobDetailsNextAct.this,ItineraryView2Act.class);
                //ambil intent untuk next activity
                tomaps.putExtra("nama_tour", (nama_tour_baru));
                startActivity(tomaps);
            }
        });



    }
}