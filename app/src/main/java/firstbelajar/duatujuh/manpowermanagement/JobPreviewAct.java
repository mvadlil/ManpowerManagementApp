package firstbelajar.duatujuh.manpowermanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.util.Linkify;
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

import java.util.regex.Pattern;

public class JobPreviewAct extends AppCompatActivity {

    Button btn_job_details;
    Button btn_grabjob;
    TextView nama_tour, tour_client, periode_tour, tour_location, maps;

    DatabaseReference reference;
    DownloadManager downloadManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_preview);

        //load element dan button
        btn_job_details = findViewById(R.id.btn_job_details);
        btn_grabjob = findViewById(R.id.btn_grabjob);
        nama_tour = findViewById(R.id.nama_tour);
        tour_client = findViewById(R.id.tour_client);
        periode_tour = findViewById(R.id.periode_tour);
        tour_location = findViewById(R.id.tour_location);
        maps = findViewById(R.id.maps);


        //mengambil data dari intent tombol yang di klik di activity sebelumnya
        Bundle bundle = getIntent().getExtras();
        final String nomor_tour_baru = bundle.getString("nomor_tour");

        //mengambil data dari firebase berdasarkan intent
        reference = FirebaseDatabase.getInstance().getReference().child("JobTour").child(nomor_tour_baru);
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

        Toast.makeText(getApplicationContext(),"nomor: "+ nomor_tour_baru, Toast.LENGTH_SHORT).show();


        btn_grabjob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotojobcheckout = new Intent(JobPreviewAct.this,JobCheckoutAct.class);
                //ambil intent untuk next activity
                gotojobcheckout.putExtra("nomor_tour", nomor_tour_baru);
                startActivity(gotojobcheckout);
            }
        });

        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tomaps = new Intent(JobPreviewAct.this,Maps1Act.class);
                //ambil intent untuk next activity
                tomaps.putExtra("nomor_tour", (nomor_tour_baru));
                startActivity(tomaps);
            }
        });

        btn_job_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tomaps = new Intent(JobPreviewAct.this,ItineraryViewAct.class);
                //ambil intent untuk next activity
                tomaps.putExtra("nomor_tour", (nomor_tour_baru));
                startActivity(tomaps);
            }
        });




    }
}