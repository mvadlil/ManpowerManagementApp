package firstbelajar.duatujuh.manpowermanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TourLeaderViewAct extends AppCompatActivity {

    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_leader_view);

        final WebView tourleader = (WebView) findViewById(R.id.tourleader);

        //mengambil data dari firebase berdasarkan intent
        reference = FirebaseDatabase.getInstance().getReference().child("ListJob").child("previewtour");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                //mengambil link dari database
                tourleader.loadUrl(dataSnapshot.child("tourleader_link").getValue().toString());
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        });

        tourleader.getSettings().setJavaScriptEnabled(true);

    }
}