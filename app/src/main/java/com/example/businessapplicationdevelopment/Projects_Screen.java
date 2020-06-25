package com.example.businessapplicationdevelopment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.businessapplicationdevelopment.projectNotes.*;

import java.util.ArrayList;

public class Projects_Screen extends AppCompatActivity {
    private ListView mNotes;
    private int mCount;
    private TextView mRowCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects__screen);
        mNotes = (ListView) findViewById(R.id.noteView);
        mRowCounter = (TextView) findViewById(R.id.rowCounter1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_create_note:
                Intent newNoteActivity = new Intent(this, NoteActivity.class);
                startActivity(newNoteActivity);
                break;
        }
        return true;
    }

    @Override
    protected void onResume() {

        super.onResume();
        mNotes.setAdapter(null);
        ArrayList<Note> notes = Utilities.getSavedNotes(this);

        if (notes == null || notes.size() == 0) {
            Toast.makeText(this, "You have no notes saved", Toast.LENGTH_SHORT).show();
        } else {
            NoteAdapter noteAdapter = new NoteAdapter(this, R.layout.note_item, notes);
            mNotes.setAdapter(noteAdapter);

            mNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    String fileName = ((Note) mNotes.getItemAtPosition(position)).getmDateTime() + Utilities.file_extension;

                    Intent viewNote = new Intent(getApplicationContext(), NoteActivity.class);
                    viewNote.putExtra("Note_file", fileName);
                    startActivity(viewNote);
                }
            });
        }

    }

    public void countUp(View view) {
        mCount++;
        if (mRowCounter != null) {
            mRowCounter.setText(Integer.toString(mCount));
        }
    }


}
