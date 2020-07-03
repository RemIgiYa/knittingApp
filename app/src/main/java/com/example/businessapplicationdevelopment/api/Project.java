package com.example.businessapplicationdevelopment.api;


import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Project {

    @SerializedName("comments_count")
    @Expose
    private Integer commentsCount;
    @SerializedName("completed")
    @Expose
    private String completed;
    @SerializedName("craft_id")
    @Expose
    private Integer craftId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("favorites_count")
    @Expose
    private Integer favoritesCount;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("made_for")
    @Expose
    private String madeFor;
    @SerializedName("made_for_user_id")
    @Expose
    private Object madeForUserId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("pattern_id")
    @Expose
    private Integer patternId;
    @SerializedName("permalink")
    @Expose
    private String permalink;
    @SerializedName("progress")
    @Expose
    private Integer progress;
    @SerializedName("project_status_changed")
    @Expose
    private String projectStatusChanged;
    @SerializedName("project_status_id")
    @Expose
    private Integer projectStatusId;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("started")
    @Expose
    private String started;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("pattern_name")
    @Expose
    private String patternName;
    @SerializedName("craft_name")
    @Expose
    private String craftName;
    @SerializedName("status_name")
    @Expose
    private String statusName;
    @SerializedName("tag_names")
    @Expose
    private List<Object> tagNames = null;
    @SerializedName("first_photo")
    @Expose
    private Object firstPhoto;
    @SerializedName("photos_count")
    @Expose
    private Integer photosCount;
    @SerializedName("ends_per_inch")
    @Expose
    private Object endsPerInch;
    @SerializedName("picks_per_inch")
    @Expose
    private Object picksPerInch;
    @SerializedName("gauge")
    @Expose
    private Object gauge;
    @SerializedName("row_gauge")
    @Expose
    private Object rowGauge;
    @SerializedName("gauge_repeats")
    @Expose
    private Object gaugeRepeats;
    @SerializedName("gauge_divisor")
    @Expose
    private Integer gaugeDivisor;
    @SerializedName("gauge_pattern")
    @Expose
    private String gaugePattern;

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public Integer getCraftId() {
        return craftId;
    }

    public void setCraftId(Integer craftId) {
        this.craftId = craftId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getFavoritesCount() {
        return favoritesCount;
    }

    public void setFavoritesCount(Integer favoritesCount) {
        this.favoritesCount = favoritesCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMadeFor() {
        return madeFor;
    }

    public void setMadeFor(String madeFor) {
        this.madeFor = madeFor;
    }

    public Object getMadeForUserId() {
        return madeForUserId;
    }

    public void setMadeForUserId(Object madeForUserId) {
        this.madeForUserId = madeForUserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPatternId() {
        return patternId;
    }

    public void setPatternId(Integer patternId) {
        this.patternId = patternId;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public String getProjectStatusChanged() {
        return projectStatusChanged;
    }

    public void setProjectStatusChanged(String projectStatusChanged) {
        this.projectStatusChanged = projectStatusChanged;
    }

    public Integer getProjectStatusId() {
        return projectStatusId;
    }

    public void setProjectStatusId(Integer projectStatusId) {
        this.projectStatusId = projectStatusId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getStarted() {
        return started;
    }

    public void setStarted(String started) {
        this.started = started;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getPatternName() {
        return patternName;
    }

    public void setPatternName(String patternName) {
        this.patternName = patternName;
    }

    public String getCraftName() {
        return craftName;
    }

    public void setCraftName(String craftName) {
        this.craftName = craftName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public List<Object> getTagNames() {
        return tagNames;
    }

    public void setTagNames(List<Object> tagNames) {
        this.tagNames = tagNames;
    }

    public Object getFirstPhoto() {
        return firstPhoto;
    }

    public void setFirstPhoto(Object firstPhoto) {
        this.firstPhoto = firstPhoto;
    }

    public Integer getPhotosCount() {
        return photosCount;
    }

    public void setPhotosCount(Integer photosCount) {
        this.photosCount = photosCount;
    }

    public Object getEndsPerInch() {
        return endsPerInch;
    }

    public void setEndsPerInch(Object endsPerInch) {
        this.endsPerInch = endsPerInch;
    }

    public Object getPicksPerInch() {
        return picksPerInch;
    }

    public void setPicksPerInch(Object picksPerInch) {
        this.picksPerInch = picksPerInch;
    }

    public Object getGauge() {
        return gauge;
    }

    public void setGauge(Object gauge) {
        this.gauge = gauge;
    }

    public Object getRowGauge() {
        return rowGauge;
    }

    public void setRowGauge(Object rowGauge) {
        this.rowGauge = rowGauge;
    }

    public Object getGaugeRepeats() {
        return gaugeRepeats;
    }

    public void setGaugeRepeats(Object gaugeRepeats) {
        this.gaugeRepeats = gaugeRepeats;
    }

    public Integer getGaugeDivisor() {
        return gaugeDivisor;
    }

    public void setGaugeDivisor(Integer gaugeDivisor) {
        this.gaugeDivisor = gaugeDivisor;
    }

    public String getGaugePattern() {
        return gaugePattern;
    }

    public void setGaugePattern(String gaugePattern) {
        this.gaugePattern = gaugePattern;
    }

}
