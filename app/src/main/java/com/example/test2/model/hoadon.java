package com.example.test2.model;

import java.util.Date;

public class hoadon {
    private long id;
    private long idkhachhang;
    private long idnhanvien;
    private float sotiennhan;
    private float sotientralai;
    private Date ngaymua;
    private String diachi;

    public hoadon(long id, long idkhachhang, long idnhanvien, float sotiennhan, float sotientralai, Date ngaymua, String diachi) {
        this.id = id;
        this.idkhachhang = idkhachhang;
        this.idnhanvien = idnhanvien;
        this.sotiennhan = sotiennhan;
        this.sotientralai = sotientralai;
        this.ngaymua = ngaymua;
        this.diachi = diachi;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdkhachhang() {
        return idkhachhang;
    }

    public void setIdkhachhang(long idkhachhang) {
        this.idkhachhang = idkhachhang;
    }

    public long getIdnhanvien() {
        return idnhanvien;
    }

    public void setIdnhanvien(long idnhanvien) {
        this.idnhanvien = idnhanvien;
    }

    public float getSotiennhan() {
        return sotiennhan;
    }

    public void setSotiennhan(float sotiennhan) {
        this.sotiennhan = sotiennhan;
    }

    public float getSotientralai() {
        return sotientralai;
    }

    public void setSotientralai(float sotientralai) {
        this.sotientralai = sotientralai;
    }

    public Date getNgaymua() {
        return ngaymua;
    }

    public void setNgaymua(Date ngaymua) {
        this.ngaymua = ngaymua;
    }

}

