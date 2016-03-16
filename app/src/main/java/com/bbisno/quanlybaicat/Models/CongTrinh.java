package com.bbisno.quanlybaicat.Models;

/**
 * Created by voleq_000 on 02/12/2015.
 */
public class CongTrinh {
    private String tenCongTrinh;
    private String dchiCTrinh;
    private int giaXeVanChuyen;
    private int congTaiXeLai;
    private String ghiChu;

    public CongTrinh() {
    }

    public CongTrinh(String tenCongTrinh, String dchiCTrinh, int giaXeVanChuyen, int congTaiXeLai) {
        this.tenCongTrinh = tenCongTrinh;
        this.dchiCTrinh = dchiCTrinh;
        this.giaXeVanChuyen = giaXeVanChuyen;
        this.congTaiXeLai = congTaiXeLai;
    }

    public CongTrinh(String tenCongTrinh, String dchiCTrinh, int giaXeVanChuyen, int congTaiXeLai, String ghiChu) {
        this.tenCongTrinh = tenCongTrinh;
        this.dchiCTrinh = dchiCTrinh;
        this.giaXeVanChuyen = giaXeVanChuyen;
        this.congTaiXeLai = congTaiXeLai;
        this.ghiChu = ghiChu;
    }

    public String getTenCongTrinh() {
        return tenCongTrinh;
    }

    public void setTenCongTrinh(String tenCongTrinh) {
        this.tenCongTrinh = tenCongTrinh;
    }

    public String getDchiCTrinh() {
        return dchiCTrinh;
    }

    public void setDchiCTrinh(String dchiCTrinh) {
        this.dchiCTrinh = dchiCTrinh;
    }

    public int getGiaXeVanChuyen() {
        return giaXeVanChuyen;
    }

    public void setGiaXeVanChuyen(int giaXeVanChuyen) {
        this.giaXeVanChuyen = giaXeVanChuyen;
    }

    public int getCongTaiXeLai() {
        return congTaiXeLai;
    }

    public void setCongTaiXeLai(int congTaiXeLai) {
        this.congTaiXeLai = congTaiXeLai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
