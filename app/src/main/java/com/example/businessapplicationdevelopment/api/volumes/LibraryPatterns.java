
package com.example.businessapplicationdevelopment.api.volumes;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LibraryPatterns {

    @SerializedName("volumes")
    @Expose
    private List<Volume> volumes = null;

    public List<Volume> getVolumes() {
        return volumes;
    }

    public void setVolumes(List<Volume> volumes) {
        this.volumes = volumes;
    }

}
