package com.example.businessapplicationdevelopment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private Switch darkSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){

            setTheme(R.style.darkTheme);
        }
        else{ setTheme(R.style.AppTheme);}

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        darkSwitch = (Switch) findViewById(R.id.darkSwitch);

        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){

            darkSwitch.setChecked(true);

        }

        darkSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    restartApp();

                }
                else{

                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    restartApp();

                }
            }
        });

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

    public void restartApp() {

        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();


    }

}
