package com.example.businessapplicationdevelopment.api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.businessapplicationdevelopment.R;
import com.example.businessapplicationdevelopment.api.RaverlyRepo;

import java.util.List;

public class RaverlyRepoAdapter extends ArrayAdapter<RaverlyRepo> {

    private Context context;
    private List<RaverlyRepo> values;

    public RaverlyRepoAdapter(Context context, List<RaverlyRepo> values) {
        super(context, R.layout.raverly_pagination, values);

        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.raverly_pagination, parent, false);
        }

        TextView textView = row.findViewById(R.id.raverly_pagination_text);

        RaverlyRepo item = values.get(position);
        String message = item.getName();
        textView.setText(message);

        return row;
    }
}