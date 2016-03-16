package com.bbisno.quanlybaicat.Models;

/**
 * Created by voleq_000 on 02/12/2015.
 */
public class TaiXe {
    private String tenTaiXe;
    private int soDTTaiXe;
    private Xe xeLai;

    public TaiXe() {
    }

    public TaiXe(String tenTaiXe, int soDTTaiXe) {
        this.tenTaiXe = tenTaiXe;
        this.soDTTaiXe = soDTTaiXe;
    }

    public String getTenTaiXe() {
        return tenTaiXe;
    }

    public void setTenTaiXe(String tenTaiXe) {
        this.tenTaiXe = tenTaiXe;
    }

    public int getSoDTTaiXe() {
        return soDTTaiXe;
    }

    public void setSoDTTaiXe(int soDTTaiXe) {
        this.soDTTaiXe = soDTTaiXe;
    }

    public Xe getXeLai() {
        return xeLai;
    }

    public void setXeLai(Xe xeLai) {
        this.xeLai = xeLai;
    }
}
