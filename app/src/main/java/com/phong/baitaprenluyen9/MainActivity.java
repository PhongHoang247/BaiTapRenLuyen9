package com.phong.baitaprenluyen9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;

import com.phong.adapter.NhanVienAdapter;
import com.phong.model.NhanVien;

public class MainActivity extends AppCompatActivity {

    EditText edtMa, edtTen;
    RadioButton radNam, radNu;
    Button btnNhap;
    ImageView imgXoa;
    ListView lvNhanVien;
    NhanVienAdapter nhanVienAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvent();
    }

    private void addEvent() {
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLyNhapNhanVien();
            }
        });
        imgXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLyXoa();
            }
        });
    }

    private void XuLyXoa() {
        for (int i = nhanVienAdapter.getCount()-1; i>=0;i--)
        {
            NhanVien nv = nhanVienAdapter.getItem(i);
            if (nv.isXoa())
            {
                nhanVienAdapter.remove(nv);
            }
        }
    }

    private void XuLyNhapNhanVien() {
        NhanVien nv = new NhanVien();
        nv.setMa(edtMa.getText().toString());
        nv.setTen(edtTen.getText().toString());
        nv.setNu(radNu.isChecked());
        nv.setXoa(false);
        nhanVienAdapter.add(nv);
    }

    private void addControls() {
        edtMa = (EditText) findViewById(R.id.edtMa);
        edtTen = (EditText) findViewById(R.id.edtTen);
        radNam = (RadioButton) findViewById(R.id.radNam);
        radNu = (RadioButton) findViewById(R.id.radNu);
        btnNhap = (Button) findViewById(R.id.btnNhap);
        imgXoa = (ImageView) findViewById(R.id.imgXoa);
        lvNhanVien = (ListView) findViewById(R.id.lvNhanVien);
        nhanVienAdapter = new NhanVienAdapter(MainActivity.this, R.layout.item);
        //Gán Adapter cho ListView:
        lvNhanVien.setAdapter(nhanVienAdapter);
    }
}
