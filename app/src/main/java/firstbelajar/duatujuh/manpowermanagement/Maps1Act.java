package firstbelajar.duatujuh.manpowermanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Maps1Act extends AppCompatActivity {

    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps1);

        final WebView mapsview = (WebView) findViewById(R.id.mapsview);

        //mengambil data dari intent tombol yang di klik di activity sebelumnya
        Bundle bundle = getIntent().getExtras();
        final String nomor_tour_baru = bundle.getString("nomor_tour");

        //mengambil data dari firebase berdasarkan intent
        reference = FirebaseDatabase.getInstance().getReference().child("JobTour").child(nomor_tour_baru);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                //mengambil link dari database
                mapsview.loadUrl(dataSnapshot.child("google_maps").getValue().toString());
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        });

        mapsview.getSettings().setJavaScriptEnabled(true);

    }
}