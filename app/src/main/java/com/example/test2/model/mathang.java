package com.example.test2.model;
import com.fasterxml.jackson.annotation.*;
public class mathang {
    private String donvitinh;
    private long gia;
    private String tenhang;

    @JsonProperty("donvitinh")
    public String getDonvitinh() { return donvitinh; }
    @JsonProperty("donvitinh")
    public void setDonvitinh(String value) { this.donvitinh = value; }

    @JsonProperty("gia")
    public long getGia() { return gia; }
    @JsonProperty("gia")
    public void setGia(long value) { this.gia = value; }

    @JsonProperty("tenhang")
    public String getTenhang() { return tenhang; }
    @JsonProperty("tenhang")
    public void setTenhang(String value) { this.tenhang = value; }
}
