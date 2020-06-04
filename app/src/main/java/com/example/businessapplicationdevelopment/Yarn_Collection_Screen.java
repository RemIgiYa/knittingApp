package com.example.businessapplicationdevelopment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Yarn_Collection_Screen extends AppCompatActivity {

    final List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yarn__collection__screen);

        final ListView listView = findViewById(R.id.listView);
        final TextAdapter adapter = new TextAdapter();

        readInfo();

        adapter.setData(list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog dialog  = new AlertDialog.Builder(Yarn_Collection_Screen.this)
                        .setTitle("Delete the task?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                list.remove(position);
                                adapter.setData(list);
                                saveInfo();
                            }
                        })
                        .setNegativeButton("No", null)
                        .create();
                dialog.show();
            }
        });




        final Button newItemButton = findViewById(R.id.newItemButton);

        newItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                final EditText itemInput = new EditText(Yarn_Collection_Screen.this);
                itemInput.setSingleLine();
                AlertDialog dialog = new AlertDialog.Builder(Yarn_Collection_Screen.this)
                        .setTitle("Add a new Item?")
                        .setMessage("One thing at a time you'll be able to fill the whole world so don't give up!")
                        .setView(itemInput)
                        .setPositiveButton("Let's go!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                list.add(itemInput.getText().toString());
                                adapter.setData((list));
                                saveInfo();
                            }
                        })
                        .setNegativeButton("Oh, Hell no.", null)
                        .create();
                dialog.show();
            }
        });

        final Button deleteAllItemsButton = findViewById(R.id.deleteAllItemsButton);

        deleteAllItemsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog dialog = new AlertDialog.Builder(Yarn_Collection_Screen.this)
                        .setTitle("Delete all Items?")
                        .setMessage("Unlike your dirty past, this list can be wiped out - removed completely with no point of return. Proceed?")
                        .setPositiveButton("Kill them all!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                list.clear();
                                adapter.setData(list);
                                saveInfo();
                            }
                        })
                        .setNegativeButton("...No?", null)
                        .create();
                dialog.show();
            }
        });

    }

    private void saveInfo(){
        try{
            File file = new File(this.getFilesDir(), "saved");

            FileOutputStream fOut = new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fOut));

            for (int i=0; i<list.size(); i++){
                bw.write(list.get(i));
                bw.newLine();
            }
            bw.close();
            fOut.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void readInfo(){
        File file = new File(this.getFilesDir(), "saved");
        if(!file.exists()){
            return;
        }

        try{
            FileInputStream is = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = reader.readLine();
            while(line!=null){
                list.add(line);
                line = reader.readLine();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    class TextAdapter extends BaseAdapter{

        List<String> list = new ArrayList<>();

        void setData(List<String> mList){
            list.clear();
            list.addAll(mList);
            notifyDataSetChanged();
        }

        @Override
        public int getCount(){
            return list.size();
        }

        @Override
        public Object getItem (int position){
            return null;
        }

        @Override
        public long getItemId(int position){
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            if (convertView==null){
                LayoutInflater inflater = (LayoutInflater)
                        Yarn_Collection_Screen.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.item2, parent, false);
            }
            TextView textView = convertView.findViewById(R.id.task);
            if(position%2==0){
                textView.setBackgroundColor(Color.rgb(206, 191, 245));
                textView.setTextColor(Color.BLACK);
            }
            else{
                textView.setBackgroundColor(Color.WHITE);
            }
            textView.setText(list.get(position));
            return convertView;
        }
    }
}
