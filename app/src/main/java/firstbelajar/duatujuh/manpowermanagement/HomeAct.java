package firstbelajar.duatujuh.manpowermanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Pattern;

public class HomeAct extends AppCompatActivity {

    ImageView btn_tour_leader;
    ImageView btn_joblist_tourleader;
    ImageView btn_myprofile;
    TextView nama_lengkap, bio, apa_itu_tourleader;
    LinearLayout btn_support;

    DatabaseReference reference;
    DownloadManager downloadManager;

    String USERNAME_KEY = "usernamekey";
    String username_key = "";
    String username_key_new = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getUsernameLocal();

        btn_tour_leader = findViewById(R.id.btn_tour_leader);
        btn_joblist_tourleader = findViewById(R.id.btn_joblist_tourleader);
        btn_myprofile = findViewById(R.id.btn_myprofile);
        nama_lengkap = findViewById(R.id.nama_lengkap);
        bio = findViewById(R.id.bio);
        apa_itu_tourleader = findViewById(R.id.apa_itu_tourleader);
        btn_support = findViewById(R.id.btn_support);



        reference = FirebaseDatabase.getInstance().getReference()
                .child("Users").child(username_key_new);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                nama_lengkap.setText(dataSnapshot.child("nama_lengkap").getValue().toString());
                bio.setText(dataSnapshot.child("bio").getValue().toString());

            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        });


        btn_joblist_tourleader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gototourleaderjoblist = new Intent(HomeAct.this,JobListTourAct.class);
                //ambil intent untuk next activity
                gototourleaderjoblist.putExtra("jenis_job", "previewtour");
                startActivity(gototourleaderjoblist);
            }
        });

        btn_myprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotomyprofile = new Intent(HomeAct.this,MyProfileAct.class);
                startActivity(gotomyprofile);
            }
        });

        btn_tour_leader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotomyprofile = new Intent(HomeAct.this,TourLeaderViewAct.class);
                startActivity(gotomyprofile);
            }
        });

        btn_support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotosupport = new Intent(HomeAct.this,SupportAct.class);
                startActivity(gotosupport);
            }
        });




    }

    public void getUsernameLocal(){
        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
        username_key_new = sharedPreferences.getString(username_key, "");

    }
}
