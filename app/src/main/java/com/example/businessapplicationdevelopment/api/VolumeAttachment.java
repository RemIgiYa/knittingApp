
package com.example.businessapplicationdevelopment.api;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VolumeAttachment {

    @SerializedName("product_attachment_id")
    @Expose
    private Integer productAttachmentId;
    @SerializedName("filename")
    @Expose
    private String filename;
    @SerializedName("content_type")
    @Expose
    private String contentType;
    @SerializedName("notes")
    @Expose
    private Object notes;
    @SerializedName("bytes")
    @Expose
    private Integer bytes;
    @SerializedName("thumbnail_url")
    @Expose
    private String thumbnailUrl;
    @SerializedName("ravelry_download_url")
    @Expose
    private String ravelryDownloadUrl;
    @SerializedName("language_code")
    @Expose
    private String languageCode;

    public Integer getProductAttachmentId() {
        return productAttachmentId;
    }

    public void setProductAttachmentId(Integer productAttachmentId) {
        this.productAttachmentId = productAttachmentId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Object getNotes() {
        return notes;
    }

    public void setNotes(Object notes) {
        this.notes = notes;
    }

    public Integer getBytes() {
        return bytes;
    }

    public void setBytes(Integer bytes) {
        this.bytes = bytes;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getRavelryDownloadUrl() {
        return ravelryDownloadUrl;
    }

    public void setRavelryDownloadUrl(String ravelryDownloadUrl) {
        this.ravelryDownloadUrl = ravelryDownloadUrl;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

}
