package com.example.myfirebase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText nimsiswa,namasiswa;
    Button btnsave,btnview;
    DatabaseReference   reference;
    Mahasiswa mahasiswa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nimsiswa=findViewById(R.id.nimmhs);
        namasiswa=findViewById(R.id.nmmhs);
        btnsave=findViewById(R.id.tblsave);
        btnview=findViewById(R.id.tblview);
        mahasiswa=new Mahasiswa();

        reference= FirebaseDatabase.getInstance().getReference().child("Siswa");

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mahasiswa.setNim(nimsiswa.getText().toString().trim());
                mahasiswa.setNim(namasiswa.getText().toString().trim());
                reference.push().setValue(mahasiswa);
                Toast.makeText(MainActivity.this, "Data tersimpan", Toast.LENGTH_SHORT).show();
            }
        });

        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,tampil_semua_data.class);
                startActivity(intent);
            }
        });
    }
}