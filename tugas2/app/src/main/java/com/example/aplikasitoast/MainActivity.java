package com.example.aplikasitoas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView angkakounter;
    int angka=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout.activity_main);
        angkakounter=findViewById(R.id.kounter);
    }

    public void toastklick(View view) {
        Toast.makeText(this,"ini adalah toast", Toast.LENGTH_SHORT).show();
    }

    public void tblcounter(View view) {
        angka=angka+1;
        angkakounter.setText(Integer.toString(angka));

    }
}