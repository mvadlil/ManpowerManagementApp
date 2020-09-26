package firstbelajar.duatujuh.manpowermanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import java.util.ArrayList;

public class MyProfileAct extends AppCompatActivity {

    LinearLayout btn_jobtour1;
    LinearLayout btn_jobevent1;
    Button btn_edit_profile, btn_back_home, btn_sign_out;
    TextView nama_lengkap, bio;

    DatabaseReference reference, reference2;

    String USERNAME_KEY = "usernamekey";
    String username_key = "";
    String username_key_new = "";

    RecyclerView myjob_place;
    ArrayList<MyJob> list;
    JobAdapter jobAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        getUsernameLocal();

        //load button
        btn_jobtour1 = findViewById(R.id.btn_jobtour1);
        btn_jobevent1 = findViewById(R.id.btn_jobevent1);
        btn_edit_profile = findViewById(R.id.btn_edit_profile);
        btn_back_home = findViewById(R.id.btn_back_home);
        btn_sign_out = findViewById(R.id.btn_sign_out);



        //load element
        nama_lengkap = findViewById(R.id.nama_lengkap);
        bio = findViewById(R.id.bio);
        myjob_place = findViewById(R.id.myjob_place);
        myjob_place.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<MyJob>();

        reference = FirebaseDatabase.getInstance().getReference().child("Users").child(username_key_new);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                nama_lengkap.setText(dataSnapshot.child("nama_lengkap").getValue().toString());
                bio.setText(dataSnapshot.child("bio").getValue().toString());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btn_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoeditprofile = new Intent(MyProfileAct.this,EditProfileAct.class);
                startActivity(gotoeditprofile);
            }
        });

        reference2 = FirebaseDatabase.getInstance().
                getReference().child("MyJob").child(username_key_new);
        reference2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    MyJob p = dataSnapshot1.getValue(MyJob.class);
                    list.add(p);
                }
                jobAdapter = new JobAdapter(MyProfileAct.this, list);
                myjob_place.setAdapter(jobAdapter);
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        });
        btn_back_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoback = new Intent(MyProfileAct.this,HomeAct.class);
                startActivity(gotoback);
            }
        });
        btn_sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // menghapus isi / nilai / value dari username local
                SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(username_key, "");
                editor.apply();

                //berpindah activity
                Intent gotosignin = new Intent(MyProfileAct.this,SigninAct.class);
                startActivity(gotosignin);
                fileList();
            }
        });




    }
    public void getUsernameLocal(){
        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
        username_key_new = sharedPreferences.getString(username_key, "");

    }

}