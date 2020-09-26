package firstbelajar.duatujuh.manpowermanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class JobCheckoutAct extends AppCompatActivity {

    LinearLayout btn_back;
    Button btn_grabnow;
    TextView nama_tour, tour_client, periode_tour, tour_leader_fee;

    DatabaseReference reference, reference2;

    String USERNAME_KEY = "usernamekey";
    String username_key = "";
    String username_key_new = "";

    String google_maps = "";
    String itin_link = "";
    String tour_location = "";
    String job_desc = "";

    //generate nomor integer secara random
    //karena ingin membuat transaksi secara unik
    Integer nomor_transaksi = new Random().nextInt();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_checkout);

        getUsernameLocal();

        //mengambil data dari intent tombol yang di klik di activity sebelumnya
        Bundle bundle = getIntent().getExtras();
        final String nomor_tour_baru = bundle.getString("nomor_tour");

        //load button
        btn_back = findViewById(R.id.btn_back);
        btn_grabnow = findViewById(R.id.btn_grabnow);

        //load element
        nama_tour = findViewById(R.id.nama_tour);
        tour_client = findViewById(R.id.tour_client);
        periode_tour = findViewById(R.id.periode_tour);
        tour_leader_fee = findViewById(R.id.tour_leader_fee);

        //mengambil data dari firebase berdasarkan intent
        reference = FirebaseDatabase.getInstance().getReference().child("JobTour").child(nomor_tour_baru);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                //menimpa data yang ada dengan data yang baru
                nama_tour.setText(dataSnapshot.child("nama_tour").getValue().toString());
                tour_client.setText(dataSnapshot.child("tour_client").getValue().toString());
                periode_tour.setText(dataSnapshot.child("periode_tour").getValue().toString());
                tour_leader_fee.setText(dataSnapshot.child("tour_leader_fee").getValue().toString());

                google_maps = dataSnapshot.child("google_maps").getValue().toString();
                itin_link = dataSnapshot.child("itin_link").getValue().toString();
                tour_location = dataSnapshot.child("tour_location").getValue().toString();
                job_desc = dataSnapshot.child("job_desc").getValue().toString();

            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        });


        btn_grabnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //menyimpan data user ke firebase dan membuat table baru "MyJob"
                reference2 = FirebaseDatabase.getInstance().getReference().
                        child("MyJob").child(username_key_new).child(nama_tour.getText().toString() + nomor_transaksi);
                reference2.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange( DataSnapshot dataSnapshot) {
                        reference2.getRef().child("id_job").setValue(nama_tour.getText().toString() + nomor_transaksi);
                        reference2.getRef().child("nama_tour").setValue(nama_tour.getText().toString());
                        reference2.getRef().child("periode_tour").setValue(periode_tour.getText().toString());
                        reference2.getRef().child("tour_client").setValue(tour_client.getText().toString());
                        reference2.getRef().child("tour_leader_fee").setValue(tour_leader_fee.getText().toString());
                        reference2.getRef().child("google_maps").setValue(google_maps);
                        reference2.getRef().child("itin_link").setValue(itin_link);
                        reference2.getRef().child("tour_location").setValue(tour_location);
                        reference2.getRef().child("job_desc").setValue(job_desc);

                        Intent gotocheckoutsuccess = new Intent(JobCheckoutAct.this,JobCheckoutSuccess.class);
                        startActivity(gotocheckoutsuccess);

                    }

                    @Override
                    public void onCancelled( DatabaseError databaseError) {

                    }
                });


            }
        });





    }
    public void getUsernameLocal(){
        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
        username_key_new = sharedPreferences.getString(username_key, "");

    }

}