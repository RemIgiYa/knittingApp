
package com.example.businessapplicationdevelopment.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FirstPhoto {

    @SerializedName("x_offset")
    @Expose
    private Integer xOffset;
    @SerializedName("y_offset")
    @Expose
    private Integer yOffset;
    @SerializedName("square_url")
    @Expose
    private String squareUrl;
    @SerializedName("medium_url")
    @Expose
    private String mediumUrl;
    @SerializedName("thumbnail_url")
    @Expose
    private String thumbnailUrl;
    @SerializedName("small_url")
    @Expose
    private String smallUrl;
    @SerializedName("medium2_url")
    @Expose
    private String medium2Url;
    @SerializedName("small2_url")
    @Expose
    private String small2Url;

    public Integer getXOffset() {
        return xOffset;
    }

    public void setXOffset(Integer xOffset) {
        this.xOffset = xOffset;
    }

    public Integer getYOffset() {
        return yOffset;
    }

    public void setYOffset(Integer yOffset) {
        this.yOffset = yOffset;
    }

    public String getSquareUrl() {
        return squareUrl;
    }

    public void setSquareUrl(String squareUrl) {
        this.squareUrl = squareUrl;
    }

    public String getMediumUrl() {
        return mediumUrl;
    }

    public void setMediumUrl(String mediumUrl) {
        this.mediumUrl = mediumUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getSmallUrl() {
        return smallUrl;
    }

    public void setSmallUrl(String smallUrl) {
        this.smallUrl = smallUrl;
    }

    public String getMedium2Url() {
        return medium2Url;
    }

    public void setMedium2Url(String medium2Url) {
        this.medium2Url = medium2Url;
    }

    public String getSmall2Url() {
        return small2Url;
    }

    public void setSmall2Url(String small2Url) {
        this.small2Url = small2Url;
    }

}
