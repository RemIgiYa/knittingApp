package com.example.businessapplicationdevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Local_PDFs_Screen extends AppCompatActivity {

    private Adapter adapter;
    private List<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local__pdfs__screen);
        final ListView listView = findViewById(R.id.listView);

        adapter = new Adapter();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listView.setVisibility(View.GONE);
                PDFView pdfView = findViewById(R.id.pdfView);
                pdfView.setVisibility(view.VISIBLE);
                File pdfFile = new File(data.get(position));
                pdfView.fromFile(pdfFile).load();

            }
        });
    }


    private static final String[] PERMISSIONS ={
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    private static final int PERMISSIONS_COUNT =2;

    private static final int REQUEST_PERMISSIONS = 1234;

    @SuppressLint("NewApi")
    @Override
    protected void onResume(){
        super.onResume();

        if(notPermissions()){

            requestPermissions(PERMISSIONS, REQUEST_PERMISSIONS);
        }
        else{
            loadData();
        }
    }

    private boolean notPermissions(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            int permissionPtr = 0;
            while(permissionPtr<PERMISSIONS_COUNT){

                if(checkSelfPermission(PERMISSIONS[permissionPtr])!= PackageManager.PERMISSION_GRANTED){
                    return true;
                }
                permissionPtr++;
            }
        }
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_PERMISSIONS && grantResults.length>0){

            ((ActivityManager) this.getSystemService(ACTIVITY_SERVICE)).clearApplicationUserData();
            recreate();
        }
        else{
            loadData();
        }
    }

    private void loadData(){
        data.clear();
        File downloadsFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File[] files = downloadsFolder.listFiles();
        for(int i =0; i<files.length; i++){

            String filename = files[i].getAbsolutePath();
            if(filename.endsWith(".pdf")){

                data.add(filename);
            }
        }
        adapter.setData(data);
    }

    class Adapter extends BaseAdapter {

        List<String> data = new ArrayList<>();

        void setData(List<String> mData){
            data.clear();
            data.addAll(mData);
            notifyDataSetChanged();
        }

        @Override
        public int getCount(){
            return data.size();
        }

        @Override
        public Object getItem(int position){
            return null;
        }

        @Override
        public long getItemId(int position){
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){

            if(convertView==null){

                LayoutInflater inflater = (LayoutInflater) Local_PDFs_Screen.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.item, parent, false);
            }
            TextView textView = convertView.findViewById(R.id.item);
            String text = data.get(position);
            textView.setText(text.substring(text.lastIndexOf('/')+1));
            return convertView;

        }

    }
}
