package com.example.manara.capstone_stage2;

import android.os.Parcel;
import android.os.Parcelable;

public class Articales {


    private String author,title,description,url,urlToImage,publishedAt,content,name,id;
    public Articales(String title,String author,String photo_url,String description) {
        this.description=description;
        this.urlToImage=photo_url;
        this.author=author;
        this.title=title;
    }

    public  Articales(){}
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getPublishedAt() {
        return publishedAt;
    }
}

