package com.example.businessapplicationdevelopment.api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import com.example.businessapplicationdevelopment.api.volumes.Volume;
import com.example.businessapplicationdevelopment.R;

public class VolumeAdapter extends ArrayAdapter<Volume> {

    private Context context;
    private List<Volume> values;

    public VolumeAdapter(Context context, List<Volume> values) {
        super(context, R.layout.item_list, values);

        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.item_list, parent, false);
        }

        TextView textView = row.findViewById(R.id.patternName);
        TextView textView2 = row.findViewById(R.id.downloadLink);

        Volume item = values.get(position);
        Volume item2 = values.get(position);
        Integer message = item.getId();
        String message2 = item2.getTitle();
        textView.setText(String.valueOf(message));
        textView2.setText(message2);

        return row;
    }
}