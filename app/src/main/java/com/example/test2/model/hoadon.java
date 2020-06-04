package com.example.test2.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class hoadon {
    private long id;
    private long idkhachhang;
    private long idnhanvien;
    private double sotiennhan;
    private double sotientralai;
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

    public hoadon() {

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

    public double getSotiennhan() {
        return sotiennhan;
    }

    public void setSotiennhan(double sotiennhan) {
        this.sotiennhan = sotiennhan;
    }

    public double getSotientralai() {
        return sotientralai;
    }

    public void setSotientralai(double sotientralai) {
        this.sotientralai = sotientralai;
    }

    public Date getNgaymua() {
        return ngaymua;
    }

    public void setNgaymua(String ngaymua) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date d=formatter.parse(ngaymua);
        this.ngaymua = d;
    }

}

