package com.example.medicalcites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnRegisterCites;
    private Button btnConsultCites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

        btnRegisterCites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_register = new Intent(MainActivity.this, Register.class);
                startActivity(intent_register);
            }
        });

        btnConsultCites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_consult = new Intent(MainActivity.this, Consult.class);
                startActivity(intent_consult);
            }
        });
    }

    private void initialize(){
        btnRegisterCites = (Button) findViewById(R.id.btnRegisterCites);
        btnConsultCites = (Button) findViewById(R.id.btnConsultCites);
    }
}