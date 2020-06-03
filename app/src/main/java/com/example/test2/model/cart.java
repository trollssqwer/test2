package com.example.test2.model;

public class cart {
    int idHang;
    String tenHang;
    long giaHang;
    int soluong;
    String anhHang;

    public int getIdHang() {
        return idHang;
    }

    public void setIdHang(int idHang) {
        this.idHang = idHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public long getGiaHang() {
        return giaHang;
    }

    public void setGiaHang(long giaHang) {
        this.giaHang = giaHang;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getAnhHang() {
        return anhHang;
    }

    public void setAnhHang(String anhHang) {
        this.anhHang = anhHang;
    }

    public cart(int idHang, String tenHang, long giaHang, int soluong, String anhHang) {
        this.idHang = idHang;
        this.tenHang = tenHang;
        this.giaHang = giaHang;
        this.soluong = soluong;
        this.anhHang = anhHang;
    }
}
