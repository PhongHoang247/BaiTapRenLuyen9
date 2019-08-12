package com.phong.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.phong.baitaprenluyen9.R;
import com.phong.model.NhanVien;

public class NhanVienAdapter extends ArrayAdapter<NhanVien> {
    Activity context;
    int resource;
    public NhanVienAdapter(Activity context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View customView = this.context.getLayoutInflater().inflate(this.resource, null);
        ImageView imgHinh = (ImageView) customView.findViewById(R.id.imgHinh);
        TextView txtTen = (TextView) customView.findViewById(R.id.txtTen);
        CheckBox chkXoa = (CheckBox) customView.findViewById(R.id.chkXoa);
        final NhanVien nhanVien = getItem(position);
        if (nhanVien.isNu())
        {
            imgHinh.setImageResource(R.drawable.woman);
        }
        else
        {
            imgHinh.setImageResource(R.drawable.nam);
        }
        txtTen.setText(nhanVien.getMa() + " - " + nhanVien.getTen());
        chkXoa.setChecked(nhanVien.isXoa());//Có xóa thì check mà không thì thôi

        chkXoa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //Đối số b ở trên là có đc checked hay ko:
                nhanVien.setXoa(b);
            }
        });
        return customView;
    }
}
