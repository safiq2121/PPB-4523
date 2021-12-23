package com.example.projek3;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.le.AdvertiseData;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.sql.Array;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    public String bhs_program[] ={"prolog","c+","pascal","cobol","perl","Algol L","java","php","phyton"};

    Spinner combo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView) findViewById(R.id.listdata);
        combo=(Spinner) findViewById(R.id.combodata);

        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,bhs_program);
        listView.setAdapter(adapter);
        combo.setAdapter(adapter);
    }
}