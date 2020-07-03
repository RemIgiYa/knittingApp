
package com.example.businessapplicationdevelopment.api;

import android.widget.ListView;

import java.util.List;

import com.example.businessapplicationdevelopment.api.volumes.Volume;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class VolumeDetails {

    @SerializedName("volume")
    @Expose
    private VolumeProduct volume;

    public VolumeProduct getVolume() {
        return volume;
    }

    public void setVolume(VolumeProduct volume) {
        this.volume = volume;
    }

}
