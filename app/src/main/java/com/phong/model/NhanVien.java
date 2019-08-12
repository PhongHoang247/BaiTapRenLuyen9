package com.phong.model;

import java.io.Serializable;

public class NhanVien implements Serializable {
    protected String ma;
    protected String ten;
    protected boolean nu;
    protected boolean xoa;

    public NhanVien() {
    }

    public NhanVien(String ma, String ten, boolean nu, boolean xoa) {
        this.ma = ma;
        this.ten = ten;
        this.nu = nu;
        this.xoa = xoa;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public boolean isNu() {
        return nu;
    }

    public void setNu(boolean nu) {
        this.nu = nu;
    }

    public boolean isXoa() {
        return xoa;
    }

    public void setXoa(boolean xoa) {
        this.xoa = xoa;
    }
}
