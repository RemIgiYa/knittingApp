package com.example.businessapplicationdevelopment.projectNotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.businessapplicationdevelopment.R;

import java.util.ArrayList;

public class NoteAdapter extends ArrayAdapter<Note> {
    public NoteAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Note> notes) {
        super(context, resource, notes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.note_item, null);
        }
        Note note = getItem(position);
        if (note != null) {
            TextView title = (TextView) convertView.findViewById(R.id.note_title);
            TextView noteDate = (TextView) convertView.findViewById(R.id.note_date);
            TextView content = (TextView) convertView.findViewById(R.id.note_content);

            title.setText(note.getmTitle());
            noteDate.setText(note.dateTimeAsString(getContext()));

            if (note.getmContent().length() > 50) {
                content.setText(note.getmContent().substring(0, 50));
            } else {
                content.setText(note.getmContent());
            }

        }
        return convertView;
    }
}
