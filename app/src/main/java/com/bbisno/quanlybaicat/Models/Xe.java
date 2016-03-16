package com.bbisno.quanlybaicat.Models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by voleq_000 on 02/12/2015.
 */
public class Xe {
    private boolean xeNha;
    private long soXe;
    private double khoiluongXe;
    private HashMap<String,Object>chuXe;


    public Xe() {
    }

    public Xe(boolean xeNha, long soXe, double khoiluongXe) {
        this.xeNha = xeNha;
        this.soXe = soXe;
        this.khoiluongXe = khoiluongXe;

    }

    public Xe(boolean xeNha, long soXe, double khoiluongXe, HashMap<String, Object> chuXe) {
        this.xeNha = xeNha;
        this.soXe = soXe;
        this.khoiluongXe = khoiluongXe;
        this.chuXe = chuXe;
    }

    public boolean getXeNha() {
        return xeNha;
    }

    public void setXeNha(boolean xeNha) {
        this.xeNha = xeNha;
    }

    public Map<String, Object> getChuXe() {
        return chuXe;
    }

    public long getSoXe() {
        return soXe;
    }


    public double getKhoiluongXe() {
        return khoiluongXe;
    }


}
