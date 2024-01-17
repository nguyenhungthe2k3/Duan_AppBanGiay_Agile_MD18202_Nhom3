package com.example.demo1.Model;

public class Photo {
    public Photo(int imgId) {
        this.imgId = imgId;
    }

    public int getImgId() {
        return imgId;
    }

    public Photo() {
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    private int imgId;

}
