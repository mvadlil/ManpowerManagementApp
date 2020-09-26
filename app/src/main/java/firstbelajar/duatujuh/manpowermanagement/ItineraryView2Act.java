package firstbelajar.duatujuh.manpowermanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ItineraryView2Act extends AppCompatActivity {

    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_view2);

        final WebView itineraryview = (WebView) findViewById(R.id.itineraryview);

        //mengambil data dari intent tombol yang di klik di activity sebelumnya
        Bundle bundle = getIntent().getExtras();
        final String nama_tour_baru = bundle.getString("nama_tour");

        //mengambil data dari firebase berdasarkan intent
        reference = FirebaseDatabase.getInstance().getReference().child("JobTourNext").child(nama_tour_baru);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                //mengambil link dari database
                itineraryview.loadUrl(dataSnapshot.child("itin_link").getValue().toString());
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        });

        itineraryview.getSettings().setJavaScriptEnabled(true);

    }
}