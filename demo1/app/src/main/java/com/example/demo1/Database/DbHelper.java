package com.example.demo1.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public static final String Db_name = "AirStore";

    public DbHelper(@Nullable Context context) {
        super(context, Db_name, null, 6);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Bảng cơ sơ
        String createTableCoSo =
                "create table CoSo(maCoSo text primary key ,diaChi text not null)";
        sqLiteDatabase.execSQL(createTableCoSo);
        sqLiteDatabase.execSQL("insert into CoSo(maCoSo,diaChi) values('Air Store 1','hà nội'),('Air Store 2','Hải dương')");
        //bảng loại giày
        String createTableLoaiGiay =
                "create table LoaiGiay(maLoai integer primary key autoincrement, tenLoai text, loaiHang text)";
        sqLiteDatabase.execSQL(createTableLoaiGiay);
        sqLiteDatabase.execSQL("insert into LoaiGiay(tenLoai,loaiHang) values('Giày thể thao','Đẹp'),('Giày công sở','New')");
        //bảng khách hàng
        String createTableKhachHang =
                "create table KhachHang(maKh integer primary key autoincrement,hoTen text not null, sdt integer not null)";
        sqLiteDatabase.execSQL(createTableKhachHang);
        sqLiteDatabase.execSQL("insert into KhachHang(hoTen,sdt) values('Thanh',0397590876),('Anh Thành',0987927365)");
        //bảng giày
        String createTableGiay =
                "create table Giay(maGiay integer primary key autoincrement ,maLoai integer references LoaiGiay(maLoai),tenGiay text not null, giaMua integer not null, moTa text not null)";
        sqLiteDatabase.execSQL(createTableGiay);
        sqLiteDatabase.execSQL("insert into Giay(maLoai,tenGiay,giaMua,moTa) values(1,'Nike',3000,'Đẹp'),(1,'Adidas',3000,'Đẹp')");
        //Bảng nhân viên
        String createTableNhanVien =
                "create table NhanVien(maNv text primary key,hoTen text not null, matKhau text not null , cccd text not null, sdt integer not null, maCoSo text references CoSo(maCoSo))";
        sqLiteDatabase.execSQL(createTableNhanVien);
        sqLiteDatabase.execSQL("insert into NhanVien(maNv,hoTen,matKhau,cccd,sdt,maCoSo) values('Nv01','Phạm Thành','12345','020203000252',0398789725,'Air Store 1'),('Nv02','Phạm Thành','12345','020203000252',0398789725,'Air Store 2')");
        //Bảng hoá đơn
        String createTableHoaDon =
                "create table HoaDon(maHoaDon integer primary key autoincrement,soHoaDon text not null, maKh integer references KhachHang(maKh),maNv text references NhanVien(maNv),ngay DATE not null, thanhToan integer not null)";
        sqLiteDatabase.execSQL(createTableHoaDon);
//        sqLiteDatabase.execSQL("insert into HoaDon(soHoaDon,maKh,maNv,ngay,thanhToan) values('HD001',1,'Nv01','2023/11/29',0)");
        //Bảng CtHoaDon
        String createTableCtHd = "create table Cthd(maCthd integer primary key autoincrement, maHoaDon integer references HoaDon(maHoaDon), maGiay integer references Giay(maGiay),soLuong integer not null , tongTien integer not null)";
        sqLiteDatabase.execSQL(createTableCtHd);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String dropTableCoSo = "drop table if exists CoSo";
        sqLiteDatabase.execSQL(dropTableCoSo);
        String dropTableLoaiGiay = "drop table if exists LoaiGiay";
        sqLiteDatabase.execSQL(dropTableLoaiGiay);
        String dropTableKhachHang = "drop table if exists KhachHang";
        sqLiteDatabase.execSQL(dropTableKhachHang);
        String dropTableGiay = "drop table if exists Giay";
        sqLiteDatabase.execSQL(dropTableGiay);
        String dropTableNhanVien = "drop table if exists NhanVien";
        sqLiteDatabase.execSQL(dropTableNhanVien);
        String dropTableHoaDon = "drop table if exists HoaDon";
        sqLiteDatabase.execSQL(dropTableHoaDon);
        String dropTableCtHd = "drop table if exists Cthd";
        sqLiteDatabase.execSQL(dropTableCtHd);
        onCreate(sqLiteDatabase);

    }
}
