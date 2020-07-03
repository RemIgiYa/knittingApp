package com.example.businessapplicationdevelopment.api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.businessapplicationdevelopment.R;

import java.util.List;

public class VolumeDetailAdapter extends ArrayAdapter<VolumeAttachment> {

    private Context context;
    private List<VolumeAttachment> values;

    public VolumeDetailAdapter(Context context, List<VolumeAttachment> values) {
        super(context, R.layout.activity_details, values);

        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.activity_details, parent, false);
        }

        TextView textView = row.findViewById(R.id.pattern_name);
        TextView textView2 = row.findViewById(R.id.pattern_code);
        TextView textView3 = row.findViewById(R.id.pattern_link);

        VolumeAttachment item = values.get(position);
        VolumeAttachment item2 = values.get(position);
        VolumeAttachment item3 = values.get(position);
        String message2 = item.getFilename();
        Integer message = item.getProductAttachmentId();
        String message3 = item2.getRavelryDownloadUrl();
        textView.setText(message2);
        textView2.setText(String.valueOf(message));
        textView3.setText(message3);

        return row;
    }
}