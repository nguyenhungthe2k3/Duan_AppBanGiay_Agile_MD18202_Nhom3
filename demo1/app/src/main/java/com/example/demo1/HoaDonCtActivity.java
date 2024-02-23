package com.example.demo1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demo1.Adapter.GiaySpinerAdapter;
import com.example.demo1.Adapter.HoaDonCtAdapter;
import com.example.demo1.Dao.GiayDao;
import com.example.demo1.Dao.HoaDonCtDao;
import com.example.demo1.Model.Giay;
import com.example.demo1.Model.HoaDonCt;

import java.util.ArrayList;

public class HoaDonCtActivity extends AppCompatActivity {
    ListView lvSp;
    EditText edtsoHd, edtSoLuong;
    Spinner spnGiay;
    TextView tvTongTien;
    ImageView imgBack;
    Button btnSave;
    GiaySpinerAdapter giaySpinerAdapter;
    ArrayList<Giay> listGiay;
    HoaDonCtDao hoaDonCtDao;
    ArrayList<HoaDonCt> list;
    HoaDonCtAdapter adapter;
    HoaDonCt hoaDonCt;
    GiayDao giayDao;
    String tenGiay;
    int maGiay, giatien;
    int soHd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don_ct);
        edtsoHd = findViewById(R.id.edtSoHd_itemHdCt);
        lvSp = findViewById(R.id.lvHdCt);
        tvTongTien = findViewById(R.id.tvTongTien);
        edtSoLuong = findViewById(R.id.edtSoLuong_hdct);
        btnSave = findViewById(R.id.btnSave_hdct);
        spnGiay = findViewById(R.id.spGiay_itemHdCt);
        imgBack = findViewById(R.id.imgBack);
        //
        hoaDonCtDao = new HoaDonCtDao(this);
        //
        soHd = getIntent().getIntExtra("soHd", 0);
        edtsoHd.setText(String.valueOf(soHd));
        capNhapLv();
        //Sp giày
        giayDao = new GiayDao(this);
        listGiay = new ArrayList<>();
        listGiay = (ArrayList<Giay>) giayDao.GetAll();
        giaySpinerAdapter = new GiaySpinerAdapter(this, listGiay);
        spnGiay.setAdapter(giaySpinerAdapter);
        spnGiay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                maGiay = listGiay.get(i).getMaGiay();
                giatien = listGiay.get(i).getGiaMua();
                tenGiay = listGiay.get(i).getTenGiay();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String soLuong = edtSoLuong.getText().toString().trim();
                if (soLuong.isEmpty()) {
                    Toast.makeText(HoaDonCtActivity.this, "Nhập số lượng", Toast.LENGTH_SHORT).show();
                    edtSoLuong.requestFocus();
                    return;
                } else {
                    hoaDonCt = new HoaDonCt();
                    hoaDonCt.setSoLuong(Integer.parseInt(soLuong));
                    hoaDonCt.setSoHoaDon(soHd);
                    hoaDonCt.setMaGiay(maGiay);
                    hoaDonCt.setGiaMua(giatien);
                    if (hoaDonCtDao.insertHoaDonCt(hoaDonCt)) {
                        Toast.makeText(HoaDonCtActivity.this, "Thêm  thành công !", Toast.LENGTH_SHORT).show();
                        edtSoLuong.setText("");
                        list.clear();
                        list.addAll(hoaDonCtDao.getAll(soHd));
                        adapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(HoaDonCtActivity.this, "Thêm thất bại !", Toast.LENGTH_SHORT).show();
                    }
                }
                capNhapLv();
            }
        });

    }

    public void capNhapLv() {
        list = (ArrayList<HoaDonCt>) hoaDonCtDao.getAll(soHd);
        adapter = new HoaDonCtAdapter(this, list);
        adapter.setOnDeleteSuccessListener(new HoaDonCtAdapter.OnDeleteSuccessListener() {
            @Override
            public void onDeleteSuccess() {
                int tongTien = adapter.tinhTongTien();
                tvTongTien.setText(tongTien + " $");
            }
        });
        lvSp.setAdapter(adapter);
        int tongTien = adapter.tinhTongTien();
        tvTongTien.setText(tongTien + " $");
    }
}