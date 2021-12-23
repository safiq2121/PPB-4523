package com.example.tugas5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TampiLisview extends AppCompatActivity {
    BantuDatabase bd;
    public static ListView listView;
    public static EditText editText;
    Button tblTambah;

    ArrayAdapter adapter;
    ArrayList<String> lisviewku;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampi_lisview);

        listView=findViewById(R.id.listdatabuah);
        editText=findViewById(R.id.databuah);
        tblTambah=findViewById(R.id.tbltambah);
        bd=new BantuDatabase(this);
        lisviewku=new ArrayList<>();
        tampilkan_buah();

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                final String noid=lisviewku.get(position);
                final String nomer=noid.substring(0,2);
                //editText.setText(nomer.());
                new AlertDialog.Builder(TampiLisview.this)
                        .setTitle("Perhatian !")
                        .setMessage("hapus?")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                bd.hapusRecord(Integer.parseInt(nomer));
                                lisviewku.remove(position);
                                listView.invalidateViews();

                            }
                        })
                        .setNegativeButton("no",null)
                        .show();
                return false;
            }
        });
        tblTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bd.tambahData(editText.getText().toString());
                Toast.makeText( TampiLisview.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                lisviewku.clear();
                tampilkan_buah();
            }
        });

    }

    private void tampilkan_buah() {
        Cursor cursor=bd.tampilBuah();
        if (cursor.getCount()==0)
        {
            Toast.makeText(this, "Record kosong coy!", Toast.LENGTH_SHORT).show();

        }else {
            while (cursor.moveToNext())
            {
                lisviewku.add(String.valueOf(cursor.getInt (0))+" "+ cursor.getString(1) );
            }
            adapter=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,lisviewku);
            listView.setAdapter(adapter);
        }
    }
}