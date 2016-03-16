package com.bbisno.quanlybaicat.Models;

import java.util.HashMap;

/**
 * Created by voleq_000 on 02/12/2015.
 */
public class ChuXe {

    private String tenChuXe;
    private long soDTChuXe;
    private HashMap<String, Object> xeSoHuu;

    public ChuXe() {
    }

    public ChuXe(String tenChuXe) {
        this.tenChuXe = tenChuXe;
    }

    public ChuXe(String tenChuXe, long soDTChuXe) {
        this.tenChuXe = tenChuXe;
        this.soDTChuXe = soDTChuXe;
    }

    public ChuXe(String tenChuXe, long soDTChuXe, HashMap<String, Object> xeSoHuu) {
        this.tenChuXe = tenChuXe;
        this.soDTChuXe = soDTChuXe;
        this.xeSoHuu = xeSoHuu;
    }

    public String getTenChuXe() {
        return tenChuXe;
    }


    public long getSoDTChuXe() {
        return soDTChuXe;
    }

    public HashMap<String, Object> getXeSoHuu() {
        return xeSoHuu;
    }
}





