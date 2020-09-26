package firstbelajar.duatujuh.manpowermanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterOneAct extends AppCompatActivity {

    LinearLayout btn_back;
    Button btn_continue;
    EditText username, password, email_address, nama_lengkap,bio, motivasi, skill;
    DatabaseReference reference;

    String USERNAME_KEY = "usernamekey";
    String username_key = "";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register_one);

            //load button
            btn_continue = findViewById(R.id.btn_continue);
            btn_back = findViewById(R.id.btn_back);

            //load element
            username = findViewById(R.id.username);
            password = findViewById(R.id.password);
            email_address = findViewById(R.id.email_address);
            nama_lengkap = findViewById(R.id.nama_lengkap);
            bio = findViewById(R.id.bio);
            motivasi = findViewById(R.id.motivasi);
            skill = findViewById(R.id.skill);



            btn_continue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //ubah state menjadi loading
                    btn_continue.setEnabled(false);
                    btn_continue.setText("Loading...");


                    // menyimpan data kepada local storage (handphone)
                    SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(username_key, username.getText().toString());
                    editor.apply();

                    // simpan kepada database
                    reference = FirebaseDatabase.getInstance().getReference()
                            .child("Users").child(username.getText().toString());
                    reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            dataSnapshot.getRef().child("username").setValue(username.getText().toString());
                            dataSnapshot.getRef().child("password").setValue(password.getText().toString());
                            dataSnapshot.getRef().child("email_address").setValue(email_address.getText().toString());
                            dataSnapshot.getRef().child("nama_lengkap").setValue(nama_lengkap.getText().toString());
                            dataSnapshot.getRef().child("bio").setValue(bio.getText().toString());
                            dataSnapshot.getRef().child("motivasi").setValue(motivasi.getText().toString());
                            dataSnapshot.getRef().child("skill").setValue(skill.getText().toString());

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    //berpindah activity
                    Intent gotoregistersuccess = new Intent(RegisterOneAct.this,RegisterSuccessAct.class);
                    startActivity(gotoregistersuccess);
                }
            });

            btn_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent backtosignin = new Intent(RegisterOneAct.this,SigninAct.class);
                    startActivity(backtosignin);
                }
            });

    }


}
