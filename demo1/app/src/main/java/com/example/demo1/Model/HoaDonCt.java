package com.example.demo1.Model;

public class HoaDonCt {
    private int maCthd;
    private int soHoaDon;
    private  int maGiay;
    private int giaMua;
    private int soLuong;

    public HoaDonCt() {
    }

    public HoaDonCt(int maGiay, int giaMua, int soLuong) {
        this.maGiay = maGiay;
        this.giaMua = giaMua;
        this.soLuong = soLuong;
    }

    public HoaDonCt(int soHoaDon, int maGiay, int giaMua, int soLuong) {
        this.soHoaDon = soHoaDon;
        this.maGiay = maGiay;
        this.giaMua = giaMua;
        this.soLuong = soLuong;
    }

    public int getMaCthd() {
        return maCthd;
    }

    public void setMaCthd(int maCthd) {
        this.maCthd = maCthd;
    }

    public int getSoHoaDon() {
        return soHoaDon;
    }

    public void setSoHoaDon(int soHoaDon) {
        this.soHoaDon = soHoaDon;
    }

    public int getMaGiay() {
        return maGiay;
    }

    public void setMaGiay(int maGiay) {
        this.maGiay = maGiay;
    }

    public int getGiaMua() {
        return giaMua;
    }

    public void setGiaMua(int giaMua) {
        this.giaMua = giaMua;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
