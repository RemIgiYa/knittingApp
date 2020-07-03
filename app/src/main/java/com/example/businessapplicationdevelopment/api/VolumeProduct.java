
package com.example.businessapplicationdevelopment.api;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VolumeProduct {

    @SerializedName("asking_price_cents")
    @Expose
    private Object askingPriceCents;
    @SerializedName("asking_price_currency")
    @Expose
    private Object askingPriceCurrency;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("pattern_id")
    @Expose
    private Integer patternId;
    @SerializedName("pattern_source_id")
    @Expose
    private Object patternSourceId;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("volume_status_id")
    @Expose
    private Object volumeStatusId;
    @SerializedName("volume_attachments")
    @Expose
    private List<VolumeAttachment> volumeAttachments = null;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("author_name")
    @Expose
    private String authorName;
    @SerializedName("patterns_count")
    @Expose
    private Integer patternsCount;
    @SerializedName("has_downloads")
    @Expose
    private Boolean hasDownloads;
    @SerializedName("cover_image_url")
    @Expose
    private Object coverImageUrl;
    @SerializedName("cover_image_size")
    @Expose
    private Object coverImageSize;
    @SerializedName("square_image_url")
    @Expose
    private String squareImageUrl;
    @SerializedName("small_image_url")
    @Expose
    private String smallImageUrl;
    @SerializedName("first_photo")
    @Expose
    private FirstPhoto firstPhoto;
    @SerializedName("notes")
    @Expose
    private Object notes;
    @SerializedName("notes_html")
    @Expose
    private Object notesHtml;
    @SerializedName("for_sale")
    @Expose
    private Boolean forSale;
    @SerializedName("for_trade")
    @Expose
    private Boolean forTrade;

    public Object getAskingPriceCents() {
        return askingPriceCents;
    }

    public void setAskingPriceCents(Object askingPriceCents) {
        this.askingPriceCents = askingPriceCents;
    }

    public Object getAskingPriceCurrency() {
        return askingPriceCurrency;
    }

    public void setAskingPriceCurrency(Object askingPriceCurrency) {
        this.askingPriceCurrency = askingPriceCurrency;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatternId() {
        return patternId;
    }

    public void setPatternId(Integer patternId) {
        this.patternId = patternId;
    }

    public Object getPatternSourceId() {
        return patternSourceId;
    }

    public void setPatternSourceId(Object patternSourceId) {
        this.patternSourceId = patternSourceId;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getVolumeStatusId() {
        return volumeStatusId;
    }

    public void setVolumeStatusId(Object volumeStatusId) {
        this.volumeStatusId = volumeStatusId;
    }

    public List<VolumeAttachment> getVolumeAttachments() {
        return volumeAttachments;
    }

    public void setVolumeAttachments(List<VolumeAttachment> volumeAttachments) {
        this.volumeAttachments = volumeAttachments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getPatternsCount() {
        return patternsCount;
    }

    public void setPatternsCount(Integer patternsCount) {
        this.patternsCount = patternsCount;
    }

    public Boolean getHasDownloads() {
        return hasDownloads;
    }

    public void setHasDownloads(Boolean hasDownloads) {
        this.hasDownloads = hasDownloads;
    }

    public Object getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(Object coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public Object getCoverImageSize() {
        return coverImageSize;
    }

    public void setCoverImageSize(Object coverImageSize) {
        this.coverImageSize = coverImageSize;
    }

    public String getSquareImageUrl() {
        return squareImageUrl;
    }

    public void setSquareImageUrl(String squareImageUrl) {
        this.squareImageUrl = squareImageUrl;
    }

    public String getSmallImageUrl() {
        return smallImageUrl;
    }

    public void setSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
    }

    public FirstPhoto getFirstPhoto() {
        return firstPhoto;
    }

    public void setFirstPhoto(FirstPhoto firstPhoto) {
        this.firstPhoto = firstPhoto;
    }

    public Object getNotes() {
        return notes;
    }

    public void setNotes(Object notes) {
        this.notes = notes;
    }

    public Object getNotesHtml() {
        return notesHtml;
    }

    public void setNotesHtml(Object notesHtml) {
        this.notesHtml = notesHtml;
    }

    public Boolean getForSale() {
        return forSale;
    }

    public void setForSale(Boolean forSale) {
        this.forSale = forSale;
    }

    public Boolean getForTrade() {
        return forTrade;
    }

    public void setForTrade(Boolean forTrade) {
        this.forTrade = forTrade;
    }

}
