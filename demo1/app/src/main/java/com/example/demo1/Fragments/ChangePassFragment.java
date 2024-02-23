package com.example.demo1.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.demo1.Dao.NhanVienDao;
import com.example.demo1.Model.NhanVien;
import com.example.demo1.R;
import com.google.android.material.textfield.TextInputEditText;


public class ChangePassFragment extends Fragment {

    TextInputEditText edPassOld, edPassChange, edRePassChange;
    ImageView btnSaveUserChange, btnCancleUserChange;
    NhanVienDao nhanVienDao;

    public ChangePassFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_change_pass, container, false);
        nhanVienDao = new NhanVienDao(getActivity());
        edPassOld = v.findViewById(R.id.edtOldPass);
        edPassChange = v.findViewById(R.id.edtNewPass);
        edRePassChange = v.findViewById(R.id.edtNhapLaiPass);
        btnSaveUserChange = v.findViewById(R.id.btnSave_ChangePass);
        btnCancleUserChange = v.findViewById(R.id.btnHuy_ChangePass);
        btnCancleUserChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edPassOld.setText("");
                edPassChange.setText("");
                edRePassChange.setText("");
            }
        });
        btnSaveUserChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getActivity().getSharedPreferences("USER_FILE", Context.MODE_PRIVATE);
                String user = pref.getString("userName", "");
                if (validate() > 0) {
                    NhanVien nv = nhanVienDao.getID(user);
                    nv.setMatKhau(edPassChange.getText().toString());
                    if (nhanVienDao.updatePass(nv) > 0) {
                        Toast.makeText(getActivity(), "Thay đổi mật khẩu thành công !", Toast.LENGTH_SHORT).show();
                        edPassOld.setText("");
                        edPassChange.setText("");
                        edRePassChange.setText("");
                    } else {
                        Toast.makeText(getActivity(), "Thay đổi mật khẩu thất bại !", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return v;
    }

    public int validate() {
        int check = 1;
        if (edPassOld.getText().length() == 0 || edPassChange.getText().length() == 0 || edRePassChange.getText().length() == 0) {
            Toast.makeText(getContext(), "Bạn phải nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            check = -1;
        } else {
            SharedPreferences pref = getActivity().getSharedPreferences("USER_FILE", Context.MODE_PRIVATE);
            String passOld = pref.getString("passWord", "");
            String pass = edPassChange.getText().toString();
            String rePass = edRePassChange.getText().toString();
            if (!passOld.equals(edPassOld.getText().toString())) {
                Toast.makeText(getContext(), "Mật khẩu cũ sai !", Toast.LENGTH_SHORT).show();
                check = -1;
            }
            if (!pass.equals(rePass)) {
                Toast.makeText(getContext(), "Mật khẩu không trùng khớp !", Toast.LENGTH_SHORT).show();
                check = -1;
            }
        }
        return check;
    }
}