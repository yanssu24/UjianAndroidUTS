package com.example.ujianandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView lvNama = findViewById(R.id.lvNama);

        ArrayList<String> daftar_nama = getIntent().getExtras().getStringArrayList("daftar_nama");

        if (daftar_nama.isEmpty()) {
            daftar_nama.add("data masih kosong");
        }


        ArrayList<String> repeatedNames = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            if ((i + 1) % 2 == 0) {
                for (String name : daftar_nama) {
                    repeatedNames.add((i + 1) + ". " + name);
                }
            }
        }

        ArrayAdapter<String> ad_nama = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, repeatedNames);

        lvNama.setAdapter(ad_nama);
    }
}