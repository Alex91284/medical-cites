package com.example.medicalcites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Consult extends AppCompatActivity {
    private ListView listCites;
    private Button btnConsult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);
        initialize();

        btnConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Consult.this, "Consult", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initialize(){
        listCites = (ListView) findViewById(R.id.listCites);
        btnConsult = (Button) findViewById(R.id.btnConsult);
    }
}