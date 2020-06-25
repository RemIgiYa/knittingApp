package com.example.businessapplicationdevelopment.projectNotes;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Utilities {
    public static final String file_extension = ".bin";

    public static boolean saveNote(Context context, Note note) {
        String fileName = note.getmDateTime() + file_extension;

        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;

        try {
            fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(note);
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            return false;

        }
        return true;
    }

    public static ArrayList<Note> getSavedNotes(Context context) {
        ArrayList<Note> noteList = new ArrayList<>();
        File filesDir = context.getFilesDir();
        ArrayList<String> notes = new ArrayList<>();
        for (String file : filesDir.list()) {
            if (file.endsWith(file_extension)) {
                notes.add(file);
            }
        }
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;

        for (int i = 0; i < notes.size(); i++) {
            try {
                fileInputStream = context.openFileInput(notes.get(i));
                objectInputStream = new ObjectInputStream(fileInputStream);
                noteList.add((Note) objectInputStream.readObject());

                fileInputStream.close();
                objectInputStream.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
            ;
        }
        return noteList;
    }

    public static Note getOneNote(Context context, String fileName) {
        File file = new File(context.getFilesDir(), fileName);
        Note note;
        if (file.exists()) {
            FileInputStream fileInputStream;
            ObjectInputStream objectInputStream;

            try {
                fileInputStream = context.openFileInput(fileName);
                objectInputStream = new ObjectInputStream(fileInputStream);

                note = (Note) objectInputStream.readObject();
                fileInputStream.close();
                objectInputStream.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
            return note;
        }
        return null;
    }


    public static void deleteNote(Context context, String fileName) {
        File filesDir = context.getFilesDir();
        File file = new File(filesDir, fileName);
        if (file.exists()) {
            file.delete();

        }

    }
}
