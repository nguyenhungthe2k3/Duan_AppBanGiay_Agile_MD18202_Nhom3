package com.example.demo1.Model;

public class NhanVien {
    private String maNv;
    private String maCoSo;
    private String hoTen;
    private String matKhau;
    private String cccd;
    private int sdt;

    public NhanVien() {
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public String getMaCoSo() {
        return maCoSo;
    }

    public void setMaCoSo(String maCoSo) {
        this.maCoSo = maCoSo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public NhanVien(String maNv, String maCoSo, String hoTen, String matKhau, String cccd, int sdt) {
        this.maNv = maNv;
        this.maCoSo = maCoSo;
        this.hoTen = hoTen;
        this.matKhau = matKhau;
        this.cccd = cccd;
        this.sdt = sdt;
    }

    public NhanVien(String maNv, String maCoSo, String hoTen, String cccd, int sdt) {
        this.maNv = maNv;
        this.maCoSo = maCoSo;
        this.hoTen = hoTen;
        this.cccd = cccd;
        this.sdt = sdt;
    }
}
