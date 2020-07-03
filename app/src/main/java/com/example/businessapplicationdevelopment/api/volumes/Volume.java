
package com.example.businessapplicationdevelopment.api.volumes;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.businessapplicationdevelopment.api.volumes.FirstPhoto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Volume implements Parcelable {

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

    protected Volume(Parcel in) {
        createdAt = in.readString();
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        if (in.readByte() == 0) {
            patternId = null;
        } else {
            patternId = in.readInt();
        }
        updatedAt = in.readString();
        title = in.readString();
        authorName = in.readString();
        if (in.readByte() == 0) {
            patternsCount = null;
        } else {
            patternsCount = in.readInt();
        }
        byte tmpHasDownloads = in.readByte();
        hasDownloads = tmpHasDownloads == 0 ? null : tmpHasDownloads == 1;
        squareImageUrl = in.readString();
        smallImageUrl = in.readString();
    }

    public static final Creator<Volume> CREATOR = new Creator<Volume>() {
        @Override
        public Volume createFromParcel(Parcel in) {
            return new Volume(in);
        }

        @Override
        public Volume[] newArray(int size) {
            return new Volume[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(createdAt);
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(id);
        }
        if (patternId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(patternId);
        }
        parcel.writeString(updatedAt);
        parcel.writeString(title);
        parcel.writeString(authorName);
        if (patternsCount == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(patternsCount);
        }
        parcel.writeByte((byte) (hasDownloads == null ? 0 : hasDownloads ? 1 : 2));
        parcel.writeString(squareImageUrl);
        parcel.writeString(smallImageUrl);
    }
}
