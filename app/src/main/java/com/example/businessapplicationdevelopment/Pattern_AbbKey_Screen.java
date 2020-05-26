package com.example.businessapplicationdevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Pattern_AbbKey_Screen extends AppCompatActivity {

    private TextView mKnitTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern__abb_key__screen);
        mKnitTest = (TextView) findViewById(R.id.knitTest);


    }

    public void Knits(View view) {
        mKnitTest.setText(R.string.this_knit);
    }
}
