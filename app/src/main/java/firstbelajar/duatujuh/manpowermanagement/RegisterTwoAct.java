package firstbelajar.duatujuh.manpowermanagement;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class RegisterTwoAct<integer> extends AppCompatActivity {

    LinearLayout btn_back;
    Button btn_continue, btn_add_photo;
    ImageView pic_register;
    EditText bio, nama_lengkap;

    public Uri photo_location;
    Integer photo_max = 1;

    DatabaseReference reference;
    StorageReference storage;

    String USERNAME_KEY = "usernamekey";
    String username_key = "";
    String username_key_new = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_two);

        getUsernameLocal();

        //load button
        btn_continue = findViewById(R.id.btn_continue);
        btn_back = findViewById(R.id.btn_back);
        btn_add_photo = findViewById(R.id.btn_add_photo);

        //load element
        pic_register = findViewById(R.id.pic_register);
        bio = findViewById(R.id.bio);
        nama_lengkap = findViewById(R.id.nama_lengkap);


        btn_add_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findPhoto();
            }
        });

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //menyimpan ke firebase
                reference = FirebaseDatabase.getInstance().getReference()
                        .child("Users").child(username_key_new);
                storage = FirebaseStorage.getInstance().getReference().child("Photousers").child(username_key_new);

                //validasi untuk file (apakah ada?)
                if (photo_location != null){
                    StorageReference storageReference1 =
                            storage.child(System.currentTimeMillis() + "." +
                                    getFileExtension(photo_location));

                    storageReference1.putFile(photo_location)
                            .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        }
                    });
                }

                //berpindah activity
                Intent gotoregistersuccess = new Intent(RegisterTwoAct.this,RegisterSuccessAct.class);
                startActivity(gotoregistersuccess);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backtoregisterone = new Intent(RegisterTwoAct.this,RegisterOneAct.class);
                startActivity(backtoregisterone);
            }
        });
    }

    String getFileExtension(Uri uri){
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }


    public void findPhoto(){
        Intent pic = new Intent();
        pic.setType("image/*");
        pic.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(pic, photo_max);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == photo_max && requestCode == RESULT_OK && data != null && data.getData() !=null)
        {
            photo_location = data.getData();
            Picasso.with(this).load(photo_location).centerCrop().fit().into(pic_register);
        }

    }
    public void getUsernameLocal(){
        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
        username_key_new = sharedPreferences.getString(username_key, "");

    }
}
