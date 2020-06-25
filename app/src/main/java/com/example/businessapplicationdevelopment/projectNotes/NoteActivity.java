package com.example.businessapplicationdevelopment.projectNotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.businessapplicationdevelopment.R;

public class NoteActivity extends AppCompatActivity {
    private EditText mTitle;
    private EditText mContent;
    private String mNoteName;
    private Note mSavedNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        mTitle = (EditText) findViewById(R.id.titleText);
        mContent = (EditText) findViewById(R.id.textContent);
        mNoteName = getIntent().getStringExtra("Note_file");
        if (mNoteName != null && !mNoteName.isEmpty()) {
            mSavedNote = com.example.businessapplicationdevelopment.projectNotes.Utilities.getOneNote(this, mNoteName);

            if (mSavedNote != null) {
                mTitle.setText(mSavedNote.getmTitle());
                mContent.setText(mSavedNote.getmContent());
            }
            //

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_save_note:
                saveNote();
            case R.id.main_delete_note:
                deleteNote();
                break;
        }
        return true;
    }

    private void saveNote() {
        Note note;

        if (mTitle.getText().toString().trim().isEmpty() || mContent.getText().toString().trim().isEmpty()) {
            Toast.makeText(NoteActivity.this, " This is an empty note, please add some text", Toast.LENGTH_SHORT).show();
            return;

        }
        if (mSavedNote == null) {
            note = new Note(System.currentTimeMillis(), mTitle.getText().toString(), mContent.getText().toString());
        } else {
            note = new Note(mSavedNote.getmDateTime(), mTitle.getText().toString(), mContent.getText().toString());

        }

        if (com.example.businessapplicationdevelopment.projectNotes.Utilities.saveNote(this, note)) {
            Toast.makeText(NoteActivity.this, " Yay note is saved", Toast.LENGTH_SHORT).show();


        } else {
            Toast.makeText(NoteActivity.this, " No note here bud", Toast.LENGTH_SHORT).show();

        }
        finish();

    }

    private void deleteNote() {
        if (mSavedNote == null) {
            finish();

        } else {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this).setTitle("Are you sure you want to delete the note?").setMessage("The note being deleted is " + mTitle.getText().toString())
                    .setPositiveButton("Yes, delete pls", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            com.example.businessapplicationdevelopment.projectNotes.Utilities.deleteNote(getApplicationContext(), mSavedNote.getmDateTime() + com.example.businessapplicationdevelopment.projectNotes.Utilities.file_extension);
                            Toast.makeText(getApplicationContext(), "Note is now deleted", Toast.LENGTH_SHORT).show();
                            finish();

                        }

                    })
                    .setNegativeButton("No, dont delete!", null)
                    .setCancelable(false);

            dialog.show();

        }
    }
}