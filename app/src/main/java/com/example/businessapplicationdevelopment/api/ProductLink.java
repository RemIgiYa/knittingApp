
package com.example.businessapplicationdevelopment.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductLink {

    @SerializedName("download_link")
    @Expose
    private DownloadLink downloadLink;

    public DownloadLink getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(DownloadLink downloadLink) {
        this.downloadLink = downloadLink;
    }

}
