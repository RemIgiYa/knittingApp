package com.example.businessapplicationdevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pdfScreen (View view){
        Intent myIntent = new Intent(getBaseContext(),   PDFs_Screen.class);
        startActivity(myIntent);

    }

    public void projectScreen (View view){
        Intent myIntent = new Intent(getBaseContext(),   Projects_Screen.class);
        startActivity(myIntent);
    }

    public void videoTutorialsScreen (View view){
        Intent myIntent = new Intent(getBaseContext(),   Video_Tutorials_Screen.class);
        startActivity(myIntent);
    }

    public void settingsScreen (View view){
        Intent myIntent = new Intent(getBaseContext(),   Settings_Screen.class);
        startActivity(myIntent);
    }

    public void contactScreen (View view){
        Intent myIntent = new Intent(getBaseContext(),   Contact_Screen.class);
        startActivity(myIntent);
    }

    public void additionalMaterialsScreen (View view){
        Intent myIntent = new Intent(getBaseContext(),   Additional_Materials_Screen.class);
        startActivity(myIntent);
    }

}
