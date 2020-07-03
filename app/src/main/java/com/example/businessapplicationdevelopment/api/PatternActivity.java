package com.example.businessapplicationdevelopment.api;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.businessapplicationdevelopment.api.volumes.LibraryPatterns;
import com.example.businessapplicationdevelopment.api.volumes.Volume;

import com.example.businessapplicationdevelopment.R;

import org.w3c.dom.Text;

import java.nio.file.WatchEvent;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PatternActivity extends AppCompatActivity {
    //private TextView pName ;
    //private TextView pCode ;

    //private TextView pLink ;
    private String pVolId;
    private List aVolume;
    private int pickedVolume;
    private String sampleToken;
    private WebView linkView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        final TextView pName = (TextView) findViewById(R.id.pattern_name);
        final TextView pCode = (TextView) findViewById(R.id.pattern_code);

        final TextView pLink = (TextView) findViewById(R.id.pattern_link);
        final TextView pExpire = (TextView) findViewById(R.id.expire_date);


        Bundle extras = getIntent().getExtras();

        pickedVolume = getIntent().getIntExtra("pattern_file", 43);
        sampleToken = getIntent().getStringExtra("heres_token");

        Log.d("Volume", " the token from the api is:  " + sampleToken);

        final RaverlyClient raverlyClient = ServiceGenerator.createService(RaverlyClient.class, " Bearer" + " " + sampleToken);
        Call<VolumeDetails> volumeDetailsCall = raverlyClient.volumeDetail(pickedVolume);
        volumeDetailsCall.enqueue(new Callback<VolumeDetails>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<VolumeDetails> call, Response<VolumeDetails> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(PatternActivity.this, "Yay", Toast.LENGTH_SHORT).show();
                    ArrayList detail_array = (ArrayList) response.body().getVolume().getVolumeAttachments();
                    if (detail_array.isEmpty()) {

                        pName.setText("This file doesnt have a download link. Sorry");
                        pCode.setText(" ");
                        pLink.setText(" ");
                    } else {
                        VolumeAttachment item = (VolumeAttachment) detail_array.get(0);

                        String fileName = item.getFilename();
                        Integer productId = item.getProductAttachmentId();

                        pName.setText(" Name: " + fileName);
                        pCode.setText(" Pattern id: " + String.valueOf(productId));

                        Call<ProductLink> productLinkCall = raverlyClient.getPatternLink(productId);
                        productLinkCall.enqueue(new Callback<ProductLink>() {
                            @Override
                            public void onResponse(Call<ProductLink> call, Response<ProductLink> response) {
                                Toast.makeText(PatternActivity.this, "Yay, here's your link", Toast.LENGTH_SHORT).show();
                                final String links = response.body().getDownloadLink().getUrl();
                                String expires = response.body().getDownloadLink().getExpiresAt();
                                pLink.setText(" Download link: " + links);


                                pExpire.setText(" Expires at: " + expires);

                            }


                            @Override
                            public void onFailure(Call<ProductLink> call, Throwable t) {

                            }
                        });


                    }


                } else {
                    Toast.makeText(PatternActivity.this, " Couldn't  get the request", Toast.LENGTH_SHORT).show();
                    Log.d("Response", "request: " + response.raw().request() + "response:  " + response.raw());
                }
            }

            @Override
            public void onFailure(Call<VolumeDetails> call, Throwable t) {
                Toast.makeText(PatternActivity.this, " error :(", Toast.LENGTH_SHORT).show();
            }
        });


    }


}