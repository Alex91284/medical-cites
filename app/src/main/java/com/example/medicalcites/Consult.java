package com.example.medicalcites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Consult extends AppCompatActivity {
    private ListView listCites;
    private Button btnConsult;
    private DataBase_Admin obj_base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);
        initialize();

        btnConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obj_base.connectSQL();
                ArrayList<String> data =  obj_base.consultRecords();
                ArrayAdapter adapter = new ArrayAdapter(Consult.this,
                        com.google.android.material.R.layout.support_simple_spinner_dropdown_item,
                        data);
                listCites.setAdapter(adapter);
            }
        });
    }

    private void initialize(){
        listCites = (ListView) findViewById(R.id.listCites);
        btnConsult = (Button) findViewById(R.id.btnConsult);
        obj_base = new DataBase_Admin();
    }
}