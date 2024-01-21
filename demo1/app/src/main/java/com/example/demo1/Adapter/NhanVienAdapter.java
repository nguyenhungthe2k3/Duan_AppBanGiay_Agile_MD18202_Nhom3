package com.example.demo1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.demo1.Dao.CoSoDao;
import com.example.demo1.Fragments.NhanVienFragment;
import com.example.demo1.Model.CoSo;
import com.example.demo1.Model.NhanVien;
import com.example.demo1.R;

import java.util.ArrayList;

public class NhanVienAdapter extends ArrayAdapter<NhanVien> {
    private Context context;
    private ArrayList<NhanVien> list;
    NhanVienFragment fragment;
    TextView tvMaNv, tvHoTen, tvCccd, tvSdt, tvCoSo;
    ImageView btnDelete;

    public NhanVienAdapter(@NonNull Context context, NhanVienFragment fragment, ArrayList<NhanVien> list) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_nhanvien, null);
        }
        NhanVien item = list.get(position);
        if (item != null) {
            CoSoDao coSoDao = new CoSoDao(context);
            CoSo coSo = coSoDao.getID(item.getMaCoSo());
            tvMaNv = v.findViewById(R.id.tvMaNv_item);
            tvHoTen = v.findViewById(R.id.tvHoTen_item);
            tvCoSo = v.findViewById(R.id.tvCoSo_item);
            tvSdt = v.findViewById(R.id.tvSdt_item);
            tvCccd = v.findViewById(R.id.tvCccd_item);
            btnDelete=v.findViewById(R.id.btnDelete_NhanVien);
//
            tvMaNv.setText(item.getMaNv());
            tvHoTen.setText(item.getHoTen());
            tvCccd.setText(item.getCccd() + "");
            tvSdt.setText(item.getSdt() + "");
            if (coSo != null) {
                tvCoSo.setText(coSo.getMaCoSo());
            } else {
                tvCoSo.setText("Không xác định");
            }
        }
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment.xoa(item.getMaNv());
            }
        });
        return v;
    }
}
