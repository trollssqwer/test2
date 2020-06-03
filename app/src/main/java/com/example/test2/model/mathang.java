package com.example.test2.model;

public class mathang {
    private int id;
    private String donvitinh;
    private double gia;
    private String tenhang;

    public mathang(int id, String donvitinh, long gia, String tenhang) {
        this.id = id;
        this.donvitinh = donvitinh;
        this.gia = gia;
        this.tenhang = tenhang;
    }
    public mathang()
    {

    }




    public String getDonvitinh() { return donvitinh; }
    public void setDonvitinh(String value) { this.donvitinh = value; }
    public double getGia() { return gia; }
    public void setGia(double value) { this.gia = value; }
    public String getTenhang() { return tenhang; }
    public void setTenhang(String value) { this.tenhang = value; }

    public void setId(int id) {
        this.id = id;
    }
    public int getId()
    {
        return id;
    }
}
