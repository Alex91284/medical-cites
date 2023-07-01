package com.example.medicalcites;


import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Register extends AppCompatActivity {
    private EditText txtName;
    private EditText txtID;
    private Spinner combo_type_cite;
    private EditText txtDate;
    private ImageButton btnDate;
    private EditText txtTime;
    private ImageButton btnTime;
    private int dia,mes,anio,hora,minuto;
    private EditText txtDoctor;
    private Button btnRegister;
    private DataBase_Admin obj_base;
    private ModelCite obj_cite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initialize();
    }

    private void initialize(){
        txtName = (EditText) findViewById(R.id.txtName);
        txtID = (EditText) findViewById(R.id.txtID);
        combo_type_cite = (Spinner) findViewById(R.id.type_cite);
        txtDate = (EditText) findViewById(R.id.txtDate);
        btnDate = (ImageButton) findViewById(R.id.btnDate);
        txtTime = (EditText) findViewById(R.id.txtTime);
        btnTime = (ImageButton) findViewById(R.id.btnTime);
        txtDoctor = (EditText) findViewById(R.id.txtDoctor);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        obj_base = new DataBase_Admin();
        obj_cite = new ModelCite();



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.combo_type_cites, android.R.layout.simple_spinner_item);

        combo_type_cite.setAdapter(adapter);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v==btnDate){
                    final Calendar c= Calendar.getInstance();
                    dia = c.get(Calendar.DAY_OF_MONTH);
                    mes = c.get(Calendar.MONTH);
                    anio = c.get(Calendar.YEAR);

                    DatePickerDialog datePickerDialog = new DatePickerDialog(Register.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            txtDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                        }
                    }
                    , dia, mes, anio);
                    datePickerDialog.show();
                }
            }
        });

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v==btnTime){
                    final Calendar c = Calendar.getInstance();
                    hora = c.get(Calendar.HOUR_OF_DAY);
                    minuto = c.get(Calendar.MINUTE);

                    TimePickerDialog timePickerDialog = new TimePickerDialog(Register.this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            if (minute < 10){
                                txtTime.setText(hourOfDay + " : 0" + minute);
                            }else {
                                txtTime.setText(hourOfDay + " : " + minute);
                            }
                        }
                    }
                    , hora, minuto,false);
                    timePickerDialog.show();
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean confirm = obj_base.connectSQL();
                if(confirm){
                    Toast.makeText(Register.this, "Successful Connection", Toast.LENGTH_LONG).show();
                    set_data();
                    boolean confirm2 = obj_base.insert_record(obj_cite.getName(), obj_cite.getIdentification(),
                            obj_cite.getType_cite(), obj_cite.getDate(), obj_cite.getTime(), obj_cite.getProfetional());
                    if(confirm2){
                        Toast.makeText(Register.this, "Cite Registered", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(Register.this, "Failed Register", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(Register.this, "Failed Connection", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void set_data (){
        obj_cite.setName(txtName.getText().toString());
        obj_cite.setIdentification(Integer.parseInt(txtID.getText().toString()));
        obj_cite.setType_cite(combo_type_cite.getSelectedItem().toString());
        obj_cite.setDate(txtDate.getText().toString());
        obj_cite.setTime(txtTime.getText().toString());
        obj_cite.setProfetional(txtDoctor.getText().toString());
    }
}
