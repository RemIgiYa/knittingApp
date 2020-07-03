
package com.example.businessapplicationdevelopment.api;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DownloadLink {

    @SerializedName("activated_at")
    @Expose
    private String activatedAt;
    @SerializedName("expires_at")
    @Expose
    private String expiresAt;
    @SerializedName("url")
    @Expose
    private String url;

    public String getActivatedAt() {
        return activatedAt;
    }

    public void setActivatedAt(String activatedAt) {
        this.activatedAt = activatedAt;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
