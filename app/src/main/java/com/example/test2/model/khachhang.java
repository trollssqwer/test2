package com.example.test2.model;

public class khachhang {
    private int idkhachhang;
    private String sodienthoai;
    private String email;
    private String facebook;
    private String tenkhachhang;

    public khachhang() {
    }

    public khachhang(int idkhachhang, String sodienthoai, String email, String facebook, String tenkhachhang) {
        this.idkhachhang = idkhachhang;
        this.sodienthoai = sodienthoai;
        this.email = email;
        this.facebook = facebook;
        this.tenkhachhang = tenkhachhang;
    }

    public int getIdkhachhang() {
        return idkhachhang;
    }

    public void setIdkhachhang(int idkhachhang) {
        this.idkhachhang = idkhachhang;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTenkhachhang() {
        return tenkhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
    }



}
