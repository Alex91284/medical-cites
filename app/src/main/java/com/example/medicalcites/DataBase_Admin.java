package com.example.medicalcites;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DataBase_Admin {
    Connection connect;
    String url = "jdbc:mysql://35.225.240.246:3306/cites_db";
    String user = "root";
    String passw = "";

    public boolean connectSQL(){
        try{
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, passw);
            Log.i("MyTag", "Successful Connection");
            return true;
        }
        catch (Exception err){
            Log.i("MyTag", err.toString());
            return false;
        }
    }

    public boolean insert_record(String name, int identification, String type_cite, String date, String time, String doctor){
        try {
            String instructionSQL = "INSERT INTO cites values('"+name+"', '"+identification+"', '"+type_cite+"', '"+date+"', '"+time+"', '"+doctor+"')";
            connect.prepareStatement(instructionSQL).execute();
            Log.i("MyTag", "Cite Registered");
            return true;
        }
        catch (Exception err){
            Log.i("MyTag", err.toString());
            return false;
        }
    }

    public ArrayList<String> consultRecords() {
        String instructionSQL = "SELECT * FROM cites";
        ArrayList <String> datos = new ArrayList<String>();
        try{
            ResultSet results = connect.prepareStatement(instructionSQL).executeQuery();
            while(results.next()) {
                datos.add(results.getString("name") + " " + results.getInt("identification")
                        + " " + results.getString("type_cite")  + " " + results.getString("date")
                        + " " + results.getString("time") + " " + results.getString("profetional"));
            }
        }
        catch (Exception err) {
            Log.d("MyTag", err.toString());
        }
        return datos;
    }
}
