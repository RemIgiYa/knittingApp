package com.example.businessapplicationdevelopment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PDFs_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){

            setTheme(R.style.darkTheme);
        }
        else{ setTheme(R.style.AppTheme);}

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfs__screen);
    }

    public void localPDFsScreen (View view) {
        Intent myIntent = new Intent(getBaseContext(), Local_PDFs_Screen.class);
        startActivity(myIntent);
    }

    public void ravelryScreen (View view) {
        Intent myIntent = new Intent(getBaseContext(), Ravelry_Screen.class);
        startActivity(myIntent);
    }
}
