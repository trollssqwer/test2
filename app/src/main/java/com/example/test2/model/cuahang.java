package com.example.test2.model;

public class cuahang {
    int macuahang;
    String tencuahang;
    String diachicuahang;
    String anhcuahang;

    public String getAnhcuahang() {
        return anhcuahang;
    }

    public cuahang(int macuahang, String anhcuahang, String tencuahang, String diachicuahang) {
        this.macuahang = macuahang;
        this.tencuahang = tencuahang;
        this.diachicuahang = diachicuahang;
    }

    public cuahang() {

    }

    public int getMacuahang() {
        return macuahang;
    }

    public void setMacuahang(int macuahang) {
        this.macuahang = macuahang;
    }





    public String getTencuahang() {
        return tencuahang;
    }

    public void setTencuahang(String tencuahang) {
        this.tencuahang = tencuahang;
    }

    public String getDiachicuahang() {
        return diachicuahang;
    }

    public void setDiachicuahang(String diachicuahang) {
        this.diachicuahang = diachicuahang;
    }

    public void setAnhcuahang(String a) {

        anhcuahang=a;
    }
}
