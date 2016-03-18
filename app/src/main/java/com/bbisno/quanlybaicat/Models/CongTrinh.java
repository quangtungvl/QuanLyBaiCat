package com.bbisno.quanlybaicat.Models;

/**
 * Created by voleq_000 on 02/12/2015.
 */
public class CongTrinh {
    private String tenCongTrinh;
    private String dchiCTrinh;
    private long giaXeVanChuyen;
    private long congTaiXeLai;
    private String ghiChu;

    public CongTrinh() {
    }

    public CongTrinh(String tenCongTrinh, String dchiCTrinh, long giaXeVanChuyen, long congTaiXeLai) {
        this.tenCongTrinh = tenCongTrinh;
        this.dchiCTrinh = dchiCTrinh;
        this.giaXeVanChuyen = giaXeVanChuyen;
        this.congTaiXeLai = congTaiXeLai;
    }

    public CongTrinh(String tenCongTrinh, String dchiCTrinh, long giaXeVanChuyen, long congTaiXeLai, String ghiChu) {
        this.tenCongTrinh = tenCongTrinh;
        this.dchiCTrinh = dchiCTrinh;
        this.giaXeVanChuyen = giaXeVanChuyen;
        this.congTaiXeLai = congTaiXeLai;
        this.ghiChu = ghiChu;
    }

    public String getTenCongTrinh() {
        return tenCongTrinh;
    }



    public String getDchiCTrinh() {
        return dchiCTrinh;
    }



    public long getGiaXeVanChuyen() {
        return giaXeVanChuyen;
    }


    public long getCongTaiXeLai() {
        return congTaiXeLai;
    }


    public String getGhiChu() {
        return ghiChu;
    }

}
