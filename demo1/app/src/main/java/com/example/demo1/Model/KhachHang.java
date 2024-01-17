package com.example.demo1.Model;

public class KhachHang {
    private int maKh;
    private String tenKh;
    private int sdt;

  public KhachHang(){

  }

    public KhachHang(int maKh, String tenKh, int sdt) {
        this.maKh = maKh;
        this.tenKh = tenKh;
        this.sdt = sdt;
    }

    public KhachHang(String tenKh, int sdt) {
        this.tenKh = tenKh;
        this.sdt = sdt;
    }

    public int getMaKh() {
        return maKh;
    }

    public void setMaKh(int maKh) {
        this.maKh = maKh;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }
}
