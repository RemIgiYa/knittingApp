package com.example.businessapplicationdevelopment.api.apitest;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import com.example.businessapplicationdevelopment.R;


public class RaverlyProjectAdapter extends ArrayAdapter<Project> {

    private Context context;
    private List<Project> values;

    public RaverlyProjectAdapter(Context context, List<Project> values) {
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

        Project item = values.get(position);
        String message = item.getName();
        textView.setText(message);

        return row;
    }
}